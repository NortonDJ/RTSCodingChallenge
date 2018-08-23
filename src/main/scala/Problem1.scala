object Problem1 extends App {
  val (above, below) = AboveBelowCounter.count(Array(1, 5, 2, 1, 10), 6)
  println(s"above: ${above}, below: ${below}")
}
