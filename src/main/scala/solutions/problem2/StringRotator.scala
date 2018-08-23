package solutions.problem2

object StringRotator {
  def rotate(input: String, shift: Int): String = {
    def magnitudeOfShift(str: String, shift: Int) = shift % str.length

    def indexFromTheRight(str: String, indexFromTheLeft: Int) =
      str.length - indexFromTheLeft

    def applyShift(str: String, index: Int): String = {
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
