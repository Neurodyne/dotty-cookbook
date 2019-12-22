package pizza

enum CrustSize {
  case Small, Medium, Large
}

enum CrustType {
  case Thin, Thick, Regular
}

enum Topping {
  case Cheese, Pepperoni, Olives
}

  case class Pizza (
  crustSize: CrustSize,
  crustType: CrustType,
  toppings: Seq[Topping]
)

object Pizza extends App {

  import CrustSize._
  import CrustType._
  import Topping._
  
  // passing enums as method parameters
  val smallThinCheesePizza = Pizza(
    Small, Thin, Seq(Cheese)
  )

  val largeThickWorks = Pizza(
    Large, Thick, Seq(Cheese, Pepperoni, Olives)
  )

  println(smallThinCheesePizza)
  println(largeThickWorks)

  // using an enum as a method parameter and in a match expression
  printCrustSize(Small)
  def printCrustSize(cs: CrustSize) = cs match {
    case Small  => println("small")
    case Medium => println("medium")
    case Large  => println("large")
  }
}