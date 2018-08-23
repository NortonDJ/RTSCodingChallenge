package solutions.problem1

import org.scalatest.FunSuite

class AboveBelowCounterTest extends FunSuite {

  test("testBucketize") {
    assert(AboveBelowCounter.count(Array(1, 2, 3, 4, 5), 3) === (2, 2))
    assert(AboveBelowCounter.count(Array(5, 4, 3, 2, 1), 3) === (2, 2))
    assert(AboveBelowCounter.count(Array(5, 1, -5, 0, 5), 2) === (2, 3))
    assert(AboveBelowCounter.count(Array(1, 5, 2, 1, 10), 6) === (1, 4))
    assert(AboveBelowCounter.count(Array(1, 5, 2, 1, 10), 11) === (0, 5))
    assert(AboveBelowCounter.count(Array(1, 5, 2, 1, 10), 0) === (5, 0))
    assert(AboveBelowCounter.count(Array(1, 5, 2, 1, 10), 10) === (0, 4))
    assert(AboveBelowCounter.count(Array(1, 1, 1, 1, 1), 1) === (0, 0))
    assert(AboveBelowCounter.count(Array(), 1) === (0, 0))
    assert(AboveBelowCounter.count(null, 1) === (0, 0))
  }

}
