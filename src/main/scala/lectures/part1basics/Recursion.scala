package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): BigInt = {
    if (n <= 1) 1
    else {
      println("For factorial of " + n + ", I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Already got factorial of " + n)
      result
    }
  }
  println(factorial(10))
  // println(factorial(5000))  // StackOverflowError

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)  // TAIL RECURSION - use recursive call as the last expression

    factorialHelper(n, 1)
  }
  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION!

  // EXERCISES:
  // 1. Concatenate a string n times
  def concatenateString(aString: String, n: Int): String = {
    @tailrec
    def concatenateHelper(res: String, x: Int, accumulator: String): String = {
      if (x <= 0) accumulator
      else concatenateHelper(res, x - 1, res + accumulator)
    }

  concatenateHelper(aString, n,"")
  }
  println(concatenateString("Tomek", 5))
  println(concatenateString("Tomek", 1))
  println(concatenateString("Tomek", 15))

  // 2. IsPrime function tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }
  println(isPrime(17))
  println(isPrime(37))
  println(isPrime(100011))
  println(isPrime(17 * 37))

  // 3. Fibonacci function, tail recursive
  def fibonacci(n: Int): BigInt = {
    def fibHelper(x: Int, acc1: BigInt, acc2: BigInt): BigInt = {
      if (x <= 2) acc1 + acc2
      else fibHelper(x - 1, acc2, acc1+acc2)
    }

    fibHelper(n, 0, 1)
  }
  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(30))
  println(fibonacci(100))
  println(fibonacci(1000))

  def fibonacci2(n: Int): BigInt = {
    def fibHelper2(x: Int, last: BigInt, nextToLast: BigInt): BigInt = {
      if (x >= n) last
      else fibHelper2(x + 1, last + nextToLast, last)
    }

    fibHelper2(2, 1, 1)
  }
  println(fibonacci2(1))
  println(fibonacci2(2))
  println(fibonacci2(30))
  println(fibonacci2(100))
  println(fibonacci2(1000))

}
