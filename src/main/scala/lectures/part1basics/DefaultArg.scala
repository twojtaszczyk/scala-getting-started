package lectures.part1basics

object DefaultArg extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10)
  println(fact10)
  println(trFact(10, 2))

  /*
    1. pass in every leading argument
    2. name the arguments (order doesn't matter)
  */
}
