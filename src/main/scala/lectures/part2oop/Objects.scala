package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Scala uses objects for "static"/"class" level functionality
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS - using object and class with the same name in one scope
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val john = Person
    println(mary == john)

    val person1 = new Person("Tom")
    val person2 = new Person("Tom")
    println(person1 == person2)

    val bobby = Person(person1, person2)
  }
  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
