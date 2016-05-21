package chapters.second

import scala.annotation.tailrec

object Chapter {

  /**
    * Tail recursion
    * Ex.1
    * Gets the nth Fibonacci number, uses local tail-recursive function
    *
    * @param n - Fibonacci number to count
    * @return value of Fibonacci number
    */
  def fib(n: Int): Int = {

    @tailrec
    def loop(a: Int, b: Int, n: Int): Int = {
      if (n > 0) {
        loop(b, a + b, n - 1)
      } else {
        b
      }
    }

    if (n == 1) {
      0
    } else if (n == 2) {
      1
    } else {
      loop(0, 1, n - 2)
    }
  }

  /**
    * Polymorphic functions
    * Ex.2
    * Checks whether an Array[A] is sorted according to a given comparison function
    *
    * @param as      - array to check if it's sorted
    * @param ordered - compare function
    * @tparam A - type
    * @return true if array is sorted, otherwise false
    */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {

    @tailrec
    def loop(i: Int): Boolean = {
      if (i + 1 < as.length) {
        if (ordered(as(i), as(i + 1))) {
          loop(i + 1)
        } else {
          false
        }
      } else {
        true
      }
    }

    if (as.length < 2) {
      true
    } else {
      loop(0)
    }
  }

  /**
    * Currying
    * Ex.3 Converts a function f of two arguments into a function of one argument that partially applies f
    *
    * @param f - function to curry
    * @tparam A - type
    * @tparam B - type
    * @tparam C - type
    * @return curried function
    */
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  /**
    * Uncurrying
    * Ex.4
    * Converts a function f of one argument that partially applies returned function to function of two arguments
    *
    * @param f - function to uncurry
    * @tparam A - type
    * @tparam B - type
    * @tparam C - type
    * @return uncurried function
    */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }
}
