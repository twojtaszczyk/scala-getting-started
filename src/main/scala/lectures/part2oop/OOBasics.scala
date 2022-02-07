package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  println("EXERCISES:\n")
  val cDickens = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  print(cDickens.fullName())

  val oliverTwist = new Novel("Oliver Twist", 1838, cDickens)
  println("\n" + oliverTwist.authorAge())
  println(oliverTwist.isWrittenBy(cDickens))
  val twist2nd = oliverTwist.copy(1900)
  println(twist2nd.year)
  println(twist2nd.isWrittenBy(imposter))

  val counter = new Counter(55)
  counter.inc.print
  counter.dec.dec.dec.print
  counter.inc(100).print
}

// constructor
class Person(name: String, val age: Int) {
  // class parameters are NOT FIELDS (you have to add val or var)
  //body
  val x = 2  // field
  println(1 + 3)

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/* Exercises:
  Novel and a Writer

  Writer: first name, surname, year
  - method fullName

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel

  Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount
*/

class Writer(name: String, surname: String, val year: Int) {
  def fullName(): String = this.name + " " + this.surname
}

class Novel(name: String, val year: Int, var author: Writer) {
  def authorAge(): Int = year - this.author.year
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

class Counter(val count: Int) {
  def inc = new Counter(count + 1)  // immutability
  def dec = new Counter(count - 1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}