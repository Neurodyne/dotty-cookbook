val dottyVersion    = "0.22.0-bin-20191220-d45fea0-NIGHTLY"
val scala212Version = "2.13.1"
val zioVersion      = "1.0.0-RC17"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

lazy val commonDeps = libraryDependencies ++= Seq(
  )

lazy val zioDeps = libraryDependencies ++= Seq(
  "dev.zio" %% "zio"          % zioVersion,
  "dev.zio" %% "zio-test"     % zioVersion % "test",
  "dev.zio" %% "zio-test-sbt" % zioVersion % "test"
)

lazy val catsDeps = libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core"   % "2.1.0-RC1",
  "org.typelevel" %% "cats-effect" % "2.0.0"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-cookbook",
    version := "0.0.1",
    scalaVersion := dottyVersion,
    crossScalaVersions := Seq(dottyVersion, scala212Version),
    scalacOptions ++= Seq(
      "-language:implicitConversions"
      // "-noindent"
    ),
    commonDeps,
    catsDeps,
    libraryDependencies := libraryDependencies.value.map(_.withDottyCompat(scalaVersion.value)),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )

// Aliases
addCommandAlias("rel", "reload")
addCommandAlias("com", "all compile test:compile")
addCommandAlias("fix", "all compile:scalafix test:scalafix")
addCommandAlias("fmt", "all scalafmtSbt scalafmtAll")
