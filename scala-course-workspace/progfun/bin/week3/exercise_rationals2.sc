package week3

object exercise_rationals2 {
  val x = new Rational2(1,2)                      //> x  : week3.Rational2 = 1/2
  val y = new Rational2(2,3)                      //> y  : week3.Rational2 = 2/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2
  
  (x + y).toString()                              //> res2: String = 7/6
  (x - y).toString()                              //> res3: String = 1/-6
  (-x).toString()                                 //> res4: String = 1/-2
  val x1 = new Rational2(1,3)                     //> x1  : week3.Rational2 = 1/3
  val y1 = new Rational2(5,7)                     //> y1  : week3.Rational2 = 5/7
  val z1 = new Rational2(3,2)                     //> z1  : week3.Rational2 = 3/2
  (x1 - y1 -z1).toString()                        //> res5: String = -79/42
  
  y1 + y1                                         //> res6: week3.Rational2 = 10/7
  
  x < y                                           //> res7: Boolean = true
  x1 max y1                                       //> res8: week3.Rational2 = 5/7
 
  new Rational2(2)                                //> res9: week3.Rational2 = 2/1
}

// Modifying so that the numbers are simplified only when converted to strings
class Rational2(x: Int, y: Int){
	require(y != 0, "denominator must be non-zero")
	
	def this(x: Int) = this(x, 1)
	
	// private helper: client shouldnt see
	private def gcd(a: Int, b: Int): Int = if (b ==0) a else gcd(b, a % b)
	//private val g = gcd(x, y)
	val numer = x
	val denom = y
	// val numer = x / gcd(x, y)
	// val denom = y / gcd(x, y)
	
	// arithmetic on rationals
	def + (that: Rational2): Rational2 =
		new Rational2(
			numer * that.denom + that.numer * denom,
		  denom * that.denom)
	
	// printing pretty as string
	override def toString() = {
		val g = gcd(this.numer,this.denom)
		this.numer / g + "/" + this.denom / g
	}
	// negation fn
	def unary_- : Rational2 = new Rational2(-numer, denom)
	
	// sub fn
	//def sub(that: Rational): Rational =
	//	new Rational(
	//		numer * that.denom - that.numer * denom,
	//	  denom * that.denom)
	def - (that: Rational2): Rational2 = this + -that
	
	//less : comparison operator
	def < (that: Rational2) = this.numer * that.denom < that.numer * this.denom
	
	// max
	def max(that: Rational2) = if(this < that) that else this
}