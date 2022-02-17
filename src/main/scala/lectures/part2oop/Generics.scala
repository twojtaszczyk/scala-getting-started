package lectures.part2oop

import scala.runtime.Nothing$

object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
    */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  // val emptyListOfIntegers = MyList.empty[Int]  // throws  an error

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // List[Cat] extends List[Animal] ?
  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? Hard question.

  // 2. No = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // throws error when try new InvariantList[Cat]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // Exercise: expand MyList to be generic

}
