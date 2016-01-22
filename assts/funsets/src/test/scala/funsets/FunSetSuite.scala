package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = (x: Int) => x == 3 || x == 4 || x == 5
    val s5 = (x: Int) => false
    val s6 = (x: Int) => x == 4 || x == 5
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect") {
    new TestSets {
      
      val s = intersect(s3, s4)
      val s_1 = intersect(s4, s6)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(contains(s, 3), "Intersect 3")
      assert(contains(s_1, 4), "Intersect 4")
      assert(contains(s_1, 5), "Intersect 5")
      assert(!contains(s_1, 3), "Intersect 6")
    }
  }
  
  test("diff and filter") {
    new TestSets {
      
      val s = diff(s4, s3)
      val s_1 = diff(s4, s6)
      val s_2 = diff(s1,s2)
      val s_3 = diff(s1,s1)
      
      assert(contains(s_2, 1), "diff1")
      assert(!contains(s_3, 1), "diff 2")
      assert(!contains(s, 3), "diff 3")
      assert(!contains(s_1, 4), "diff 4")
      assert(!contains(s_1, 5), "diff 5")
      assert(contains(s_1, 3), "diff 6")
      // filter
      val s_4 = filter(s4, s6)
      val s_5 = filter(s1, (x: Int) => x == 1)
      val s_6 = filter(s2, s6)
      
      assert(!contains(s_4, 3), "filter 1")
      assert(contains(s_4, 4), "filter 2")
      assert(contains(s_4, 5), "filter 3")
      
      assert(!contains(s_5, 4), "filter 4")
      assert(contains(s_5, 1), "filter 5")
      assert(!contains(s_6, 3), "filter 6")
      assert(!contains(s_6, 2), "filter 7")
    }
  }
    test("for all and exists and map") {
    new TestSets {
      // 
      val s = diff(s4, s3) // 4 ,5 
      val s_1 = diff(s4, s6) // 3
      val s_2 = diff(s1,s2) // 1
      val s_3 = diff(s1,s1)// {}
      // filter
      val s_4 = filter(s4, s6) // 4,5
      val s_5 = filter(s1, (x: Int) => x == 1) // 1
      val s_6 = filter(s2, s6) // {}
      
      val s_11 = forall(s_6,(x:Int)=> x < 100)
      val s_12 = forall(s_4,(x:Int)=> x <=5)
      val s_13 = forall(s_4,(x:Int)=> x >=4)
      val s_14 = forall(s_4,(x:Int)=> x <=4)
      val s_15 = forall(s_4,(x:Int)=> x == 0)
      // forall
      assert(s_11, "forall1")
      assert(s_12, "foralll 2")
      assert(s_13, "forall 3")
      assert(!s_14, "forall 4")
      assert(!s_15, "forall 5")
      // exists
      assert(!exists(s_6, (x:Int)=> x < 100), "exists 1")
      assert(!exists(s_4, (x:Int)=> x < 4), "exists 2")
      assert(exists(s_4, (x:Int)=> x < 100), "exists 3")
      // map
      val s_21 = map(s, (x:Int)=> x + 1)
      val s_22 = map(s, (x:Int)=> 1)
      assert(contains(s_21,6), "map 1")
      assert(contains(s_21,5), "map 2")
      assert(!contains(s_21,7), "map 3")
      //
      assert(!contains(s_22, 5), "map 4")
      assert(contains(s_22, 1), "map 5")
    }
  }
}
