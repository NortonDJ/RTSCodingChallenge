package solutions.problem2

/**
  * #2  Rotate the characters in a string by a given input and have the
  * overflow appear at the beginning.
  *
  * e.g. “MyString” rotated by 2 is “ngMyStri”.
  *
  * ADDITIONALLY (for fun), by providing a negative input,
  * have the characters rotate in the other direction.
  *
  * e.g. "MyString" rotated by -2 is "StringMy"
  */
object Problem2 extends App {
  private val input = "MyString"
  private var shiftAmount = 2

  println(s"Running Problem 2 for input: $input by shifting $shiftAmount characters")

  val rotatedString = StringRotator.rotate(input, shiftAmount)
  println(rotatedString)

  shiftAmount = -2;
  println(s"Running Problem 2 for input: $input by shifting $shiftAmount characters")
  val negativelyRotatedString = StringRotator.rotate(input, shiftAmount)
  println(negativelyRotatedString)
}
