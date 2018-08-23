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
  val rotatedString = StringRotator.rotate("MyString", 2)
  println(rotatedString)

  val negativelyRotatedString = StringRotator.rotate("MyString", -2)
  println(negativelyRotatedString)
}
