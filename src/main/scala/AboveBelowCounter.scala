object AboveBelowCounter {

  /**
    *
    * @param array
    * @param pivot
    * @return
    */
  def count(array: Array[Int], pivot: Int): (Int, Int) = {
    array match {
      case null => (0, 0)
      case list => list.foldLeft((0, 0)) {
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
