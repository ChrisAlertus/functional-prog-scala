package week2

object exercise3 {
  def product(f: Int => Int)(a: Int, b: Int): Int =
  	if(a > b) 1 else f(a) * product(f) (a + 1, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x * x)(3, 4)                       //> res0: Int = 144
  
  def factorial(n: Int): Int = product(x => x)(1, n)
                                                  //> factorial: (n: Int)Int
  	
  factorial(5)                                    //> res1: Int = 120
  
  // note: mapping over all elements in the interval
  // f is the function you callon each element
  // combine is how you aggregate the results of each map output
  // a, b is specifying the range to MR on
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  	if (a > b) zero
  	else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  	
  def product2(f: Int => Int)(a: Int, b: Int): Int =
  	mapReduce(f, (x, y) => x * y, 1)(a, b)    //> product2: (f: Int => Int)(a: Int, b: Int)Int
 
 product2(x => x*x)(3, 4)                         //> res2: Int = 144
  	
  def factorial2(n: Int): Int = product2(x => x)(1, n)
                                                  //> factorial2: (n: Int)Int
}