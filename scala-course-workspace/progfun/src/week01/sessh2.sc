package week01

object sessh2 {
  1 + 3                                           //> res0: Int(4) = 4
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
 
 def sqrt(x: Double) = {
  def abs(x: Double) = if (x < 0) -x else x
  /** Calculates the square root of parameter x */
	def sqrtIter(guess: Double): Double =
		if (isGoodEnough(guess)) guess
		else sqrtIter(improve(guess))
	
	def isGoodEnough(guess:Double) =
		abs(guess*guess - x)/x < 0.001
		
	def improve(guess:Double) =
		(guess + x/ guess) / 2
	
	sqrtIter(1.0)
	}                                         //> sqrt: (x: Double)Double
	
	sqrt(2)                                   //> res1: Double = 1.4142156862745097
	sqrt(4)                                   //> res2: Double = 2.000609756097561
	sqrt(49)                                  //> res3: Double = 7.001406475243939
	sqrt(0.001)                               //> res4: Double = 0.03162278245070105
	sqrt(0.6)                                 //> res5: Double = 0.7745967741935484
	sqrt(1.0e-6)                              //> res6: Double = 0.0010000001533016628
	sqrt(1.0e60)                              //> res7: Double = 1.0000788456669446E30
	sqrt(0.1e-20)                             //> res8: Double = 3.1633394544890125E-11
	sqrt(1.0e20)                              //> res9: Double = 1.0000021484861237E10
	sqrt(1.0e50)                              //> res10: Double = 1.0000003807575104E25
	}