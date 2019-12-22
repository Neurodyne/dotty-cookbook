package alvin

import java.io.{FileInputStream, BufferedInputStream}
import scala.io.Source

@main def readBinaryFile = 
    val filename = "src/main/resources/access.log"
    val bis = BufferedInputStream(FileInputStream(filename))
    Iterator.continually(bis.read())
        .takeWhile(_ != -1)
        .foreach(b => b)  // do whatever you want with each byte
    bis.close

@main def readTextFile = 
  val filename = "src/main/resources/access.log"
  val readmeText : Iterator[String] = Source.fromFile(filename).getLines
  println (readmeText)