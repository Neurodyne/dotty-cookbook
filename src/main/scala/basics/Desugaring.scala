// TBD: how to desugar this ? Reify doesn't compile since its a Scala2 macros

package basics


// Simple enum
enum Color { 
  case Red, Green, Blue
}

// GADT 
enum Option[+T] {
  case Some[+T](x: T) extends Option[T]
  case None
}

// Notice the Main method ;)
@main def runme = {
  val col = Color.Red
}
  