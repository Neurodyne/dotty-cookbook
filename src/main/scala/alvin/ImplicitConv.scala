package alvin 

import MyImplicitMethods.personToEmployee
import scala.language.implicitConversions

object ImplicitConv extends App 
  val p = Person("Barb Saxet")
  val e: Employee = p
  println(s"Employee: $e")



object MyImplicitMethods 
  implicit def personToEmployee(p: Person): Employee = Employee(p.name)

case class Employee (name: String)
case class Person (name: String)

