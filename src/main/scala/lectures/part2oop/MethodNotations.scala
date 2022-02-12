package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 35) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"$name hangs out with ${person.name}"
    def +(str: String): Person = new Person(name = this.name + s" (${str})", favoriteMovie = this.favoriteMovie)
    def unary_! : String = s"$name, how are you?"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi! My name is $name and I like $favoriteMovie."
    def apply(x: Int): String = s"$name watched $favoriteMovie $x times."
    def learns(skill: String): String = s"$name learns $skill."
    def learnsScala: String = this learns "Scala"
  }


  val tomek = new Person("Tomek", "Seven")
  println(tomek.likes("Inception"))
  println(tomek likes "Inception")  // equivalent
  // infix notation - operator notation (syntactic sugar)

  // *Operators* in Scala
  val aga = new Person("Aga", "Titanic")
  println(aga + tomek)
  println(tomek.+(aga))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS!
  // Akka actors have ? !

  // Prefix notation
  val x = -1  // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary only work with - + ~ !

  println(tomek.unary_!)
  println(!aga)

  // Postfix notation
  println(tomek.isAlive)
  println(aga isAlive)

  // apply
  println(tomek.apply())
  println(aga())  // equivalent

// EXERCISES:
//  1. Overload the + operator
//    mary + "the rockstar" => new Person "Mary (the rockstar)"
  val tomek2 = tomek + "dad"
  println(tomek2.name)
  println((aga + "the Nurse")())
//  2. Add an age to the Person class
//    Add a unary + operator => new person with the age + 1
//    +mary => mary with the age incremented
  val tomek3 = tomek2.unary_+
  println(tomek3.age)
  println((+(+aga)).age)
//  3. Add a "learns" method in the Person class => "Mary learns Scala"
//    Add a learnsScala method, calls learns method with "Scala"
//    Use it in postfix notation
  println(tomek.learnsScala)
  println(aga.learns("Python"))
//  4. Overload the  apply method
//    mary.apply(2) => "Mary watched Inception 2 times"
  println(aga(8))

}
