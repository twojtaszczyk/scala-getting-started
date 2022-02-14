package lectures.part2oop

import scala.runtime.Nothing$

abstract class MyList {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the lis
  */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(x: Int): MyList
//  def print: String = {
//    if (isEmpty) ""
//    else head.toString + " " + tail.print
//  }
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
  println(list.isEmpty)
  val list2 = list.add(2)
  println(list2.head)
  println(list2.tail)
  println(list2.tail.head)
  println(list2.isEmpty)
//  println(list.print)
//  println(list2.print)
  println(list2.toString)
}