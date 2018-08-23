package solutions.problem2

object StringRotator {

  /**
    * Given a String input, and an amount to shift by, this method
    * returns a String such that the characters are shifted to the right,
    * with attention to overflow being shifted to the front of the string.
    *
    * @param input the String to rotate
    * @param shift the amount to shift by; if this value is negative, then we shift
    *              with overflow to the left
    * @return the shifted String
    */
  def rotate(input: String, shift: Int): String = {
    def magnitudeOfShift(str: String, shift: Int) = shift % str.length

    def indexFromTheRight(str: String, indexFromTheLeft: Int) =
      str.length - indexFromTheLeft

    def applyShift(str: String, index: Int) = {
      val (left, right) = str.splitAt(index)
      right.concat(left)
    }

    def indexFromTheLeft(magnitude: Int) = {
      Math.abs(magnitude)
    }

    input match {
      case null => null
      case "" => ""
      case str => {
        val magnitude = magnitudeOfShift(str, shift)

        val indexToApplySplit =
          if (magnitude < 0)
            indexFromTheLeft(magnitude)
          else
            indexFromTheRight(str, magnitude)

        applyShift(str, indexToApplySplit)
      }
    }
  }
}
