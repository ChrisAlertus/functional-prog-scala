package week01

object session {
  1 + 3                                           //> res0: Int(4) = 4
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
 
 def sqrt(x: Double) = {
  def abs(x: Double) = if (x < 0) -x else x
  /** Calculates the square root of parameter x */
	def sqrtIter(guess: Double, x: Double): Double =
		if (isGoodEnough(guess,x)) guess
		else sqrtIter(improve(guess, x), x)
	
	def isGoodEnough(guess:Double, x:Double) =
		abs(guess*guess - x)/x < 0.001
		
	def improve(guess:Double, x:Double) =
		(guess + x/ guess) / 2
	
	sqrtIter(1.0,x)
	}                                         //> sqrt: (x: Double)Double
	
	sqrt(2)                                   //> res1: Double = 1.4142156862745097
	sqrt(4)                                   //> res2: Double = 2.000609756097561
	sqrt(49)                                  //> res3: Double = 7.001406475243939
	sqrt(0.001)                               //> res4: Double = 0.03162278245070105
	sqrt(0.1e-20)                             //> res5: Double = 3.1633394544890125E-11
	sqrt(1.0e20)                              //> res6: Double = 1.0000021484861237E10
	sqrt(1.0e50)                              //> res7: Double = 1.0000003807575104E25
	// Not good for small or large numbers sicne the square root loses decimal points
	// and the numebrs are small to begin with so it would converge prematurely
	// for large numbers it would take too long to convrge since stop criteria is fixed
	// as opposed to bearing in mind the number size
	// FIX: stop criteria a percentage of the number we want the root of
	// Maybe change number type from Double to long?
	//
}