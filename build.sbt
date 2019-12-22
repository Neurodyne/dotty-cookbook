val dottyVersion    = "0.22.0-bin-20191220-d45fea0-NIGHTLY"
val scala212Version = "2.13.1"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "cookbook",
    version := "0.0.1",
    // To make the default compiler and REPL use Dotty
    scalaVersion := dottyVersion,
    // To cross compile with Dotty and Scala 2
    crossScalaVersions := Seq(dottyVersion, scala212Version),
    scalacOptions ++= Seq("-noindent")
  ) //

// Aliases
addCommandAlias("rel", "reload")
addCommandAlias("com", "all compile test:compile")
addCommandAlias("fix", "all compile:scalafix test:scalafix")
addCommandAlias("fmt", "all scalafmtSbt scalafmtAll")
