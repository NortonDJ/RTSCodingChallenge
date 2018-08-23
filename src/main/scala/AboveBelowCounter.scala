object AboveBelowCounter {

  /**
    * Given an array and a pivot, this method calculates two counts:
    * 1. the number of elements above the pivot,
    * 2. and the number of elements below the pivot
    *
    * @param array an Array of Ints
    * @param pivot the pivot
    * @return (number of elements above the pivot, number of elements below the pivot)
    */
  def count(array: Array[Int], pivot: Int): (Int, Int) = {
    array match {
      // handle the case where the user passes null
      case null => (0, 0)

      // otherwise the input is valid
      case values => values.foldLeft((0, 0)) {
        case ((above, below), elem) =>
          if (elem < pivot)
            (above, below + 1)
          else if (elem > pivot)
            (above + 1, below)
          else
            (above, below)
      }
    }
  }
}
