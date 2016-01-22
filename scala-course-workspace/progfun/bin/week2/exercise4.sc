package week2

import math.abs

object exercise4 {
// code to check whether function is converging to a fix ed point
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
  	abs((x - y) / x) / x < tolerance          //> isCloseEnough: (x: Double, y: Double)Boolean
  
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		val next = f(guess)
  		if (isCloseEnough(guess,next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  fixedPoint(x => 1 + x/2)(1)                     //> res0: Double = 1.999755859375
  
  ///////////////////////////////////////////////////////////////////
  def sqrt_infloop(x: Double) =
  	fixedPoint(y =>  x / y)(1.0)              //> sqrt_infloop: (x: Double)Double
  	
  def sqrt(x: Double) =
  	fixedPoint(y => (y + x / y)/ 2)(1.0)      //> sqrt: (x: Double)Double
  	
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) /2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  
  def sqrtAD(x: Double) = fixedPoint(averageDamp(y => x/y))(1)
                                                  //> sqrtAD: (x: Double)Double
  // call fixed point with fn being the average of first guess and anon fn for guessing sqrt
  // param in to anon fn is 1 which is first guess
  
  sqrtAD(2)                                       //> res1: Double = 1.4142135623746899
}