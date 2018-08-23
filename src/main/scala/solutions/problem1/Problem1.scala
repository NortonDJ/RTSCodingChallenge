package solutions.problem1

/**
  * #1  Print the number of integers in an array that are above the given input
  * and the number that are below.
  *
  * e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.
  */
object Problem1 extends App {
  val (above, below) = AboveBelowCounter.count(Array(1, 5, 2, 1, 10), 6)
  println(s"above: $above, below: $below")
}
