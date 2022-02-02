package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  // println(aParameterlessFunction)   // Warning - it works in Scala 2

  def aRepeatingFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + "\n" + aRepeatingFunction(aString, n-1)   // calling yourself - recursive function
  }

  println(aRepeatingFunction("Hi", 5))

  // WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n-1)
  }
  println(aBigFunction(100))


  // EXERCISES:
  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  def aGreetingFunction(aName: String, anAge: Int): String = {
    "Hi, my name is " + aName + " and I am " + anAge + " years old."
  }
  println(aGreetingFunction("Tomek", 27))

  // 2. Factorial function 1 * 2 * 3 * ... * n
  def aFactorialFunction(n: Int): Int = {
    if (n <= 0) 1 else n * aFactorialFunction(n-1)
  }
  println(aFactorialFunction(0))
  println(aFactorialFunction(1))
  println(aFactorialFunction(2))
  println(aFactorialFunction(3))
  println(aFactorialFunction(4))
  println(aFactorialFunction(10))

  // 3. A Fibonacci function f(n) = f(n-1) + f(n-2), f(1) = f(2) = 1
  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)
  }
  println(aFibonacciFunction(1))
  println(aFibonacciFunction(2))
  println(aFibonacciFunction(3))
  println(aFibonacciFunction(4))
  println(aFibonacciFunction(10))

  // 4. Check if a number is prime
  def isPrimeFunction(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n/2)
  }
  println(isPrimeFunction(17))
  println(isPrimeFunction(37))
  println(isPrimeFunction(100))
  println(isPrimeFunction(10000001))
  println(isPrimeFunction(17 * 37))
}
