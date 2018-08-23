package solutions.problem2

import org.scalatest.FunSuite

class StringRotatorTest extends FunSuite {

  test("testRotate") {
    assert(StringRotator.rotate("MyString", 2) === "ngMyStri")
    assert(StringRotator.rotate("MyString", 0) === "MyString")
    assert(StringRotator.rotate("MyString", 8) === "MyString")
    assert(StringRotator.rotate("MyString", 10) === "ngMyStri")
    assert(StringRotator.rotate("", 0) === "")
    assert(StringRotator.rotate("", 5) === "")
    assert(StringRotator.rotate(null, 5) === null)
    assert(StringRotator.rotate("MyString", -1) === "yStringM")
    assert(StringRotator.rotate("MyString", -8) === "MyString")
    assert(StringRotator.rotate("MyString", -4) === "ringMySt")
  }

}
