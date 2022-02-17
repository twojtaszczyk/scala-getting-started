package lectures.part2oop

import scala.runtime.Nothing$

abstract class GMyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the lis
  */
  def head: A
  def tail: GMyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GMyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object GEmpty extends GMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: GMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GMyList[B] = new GCons(element, GEmpty)
  def printElements: String = ""
}

class GCons[+A](h: A, t: GMyList[A]) extends GMyList[A] {
  def head: A = h
  def tail: GMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): GMyList[B] = new GCons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + ", " + t.printElements
}

object GListTest extends App {
  val listOfIntegers: GMyList[Int] = new GCons(3, new GCons(2, new GCons(5, GEmpty)))
  val listOfStrings: GMyList[String] = new GCons("Python", new GCons("Scala", new GCons("Java", GEmpty)))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
