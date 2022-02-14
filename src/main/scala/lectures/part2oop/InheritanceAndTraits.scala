package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance
  sealed class Animal {
    def eat = println("nomnom")  // if private then Cat can't use it
    protected val fly = false
  }

  class Cat extends Animal {
    def move = {
      println(fly)  // Protected item is accessible inside child class
      println("It can't fly.")
    }
  }

  val cat = new Cat
  cat.move

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Eagle extends Animal {
    override val fly = true // It could be used in constructor
    override def eat = {
      super.eat
      println("crunch crunch")
    }
  }
  val eagle = new Eagle
  eagle.eat
  println(eagle.fly)

  // Type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Eagle
  unknownAnimal.eat

  // Super
  // Look at 31 line

  // Preventin overrides
  // 1 - use final on member
  // 2 - use final on entire class
  // 3 - seal the class (word 'sealed') - extends classes in THIS file, prevent extension in other files
}
