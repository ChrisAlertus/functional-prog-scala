package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1,r-1) + pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(chars: List[Char], ctl: Int, ctr:Int): Boolean = {
      if (chars.isEmpty && ctl - ctr == 0) true
      else if (chars.isEmpty && ctl - ctr != 0) false
      if (ctl - ctr < 0) false
      else if (chars.head == '(') loop(chars.tail, ctl+1, ctr)
      else if (chars.head == ')') loop(chars.tail, ctl, ctr+1)
      else loop(chars.tail,ctl,ctr)
    }
    loop(chars,0,0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
     if (coins.isEmpty) 0
     else if (money == 0) 1
     else if (money < 0) 0
     else countChange(money - coins.head,coins) + countChange(money,coins.tail)
  }
}
