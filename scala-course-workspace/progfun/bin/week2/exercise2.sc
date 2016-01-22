package week2

object exercise2 {
  
  // summing the values of f evaluated on ints
  // between a and b
  def sum(f: Int => Int,a: Int, b: Int): Int = {
		// accumulator function to get tail recursion
		@scala.annotation.tailrec
		def loop(a: Int, acc: Int): Int = {
			if(a > b) acc
			else loop(a + 1, acc + f(a))
		}
		loop(a,0)
	}                                         //> sum: (f: Int => Int, a: Int, b: Int)Int
	sum(x => x*x, 3, 5)                       //> res0: Int = 50
}