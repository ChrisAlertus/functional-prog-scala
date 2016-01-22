package week3

object exercise_rationals {
  val x = new Rational(1,2)                       //> x  : week3.Rational = 1/2
  val y = new Rational(2,3)                       //> y  : week3.Rational = 2/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 2
  
  x.add( y).toString()                            //> res2: String = 7/6
  x.sub( y).toString()                            //> res3: String = 1/-6
  x.neg().toString()                              //> res4: String = 1/-2
  val x1 = new Rational(1,3)                      //> x1  : week3.Rational = 1/3
  val y1 = new Rational(5,7)                      //> y1  : week3.Rational = 5/7
  val z1 = new Rational(3,2)                      //> z1  : week3.Rational = 3/2
  x1.sub(y1).sub(z1).toString()                   //> res5: String = -79/42
  
  y1.add(y1)                                      //> res6: week3.Rational = 10/7
  
  x.less(y)                                       //> res7: Boolean = true
  x1.max(y1)                                      //> res8: week3.Rational = 5/7
  //val strange = new Rational(1,0)  throws error from require
  //strange.add(strange)
  
  new Rational(2)                                 //> res9: week3.Rational = 2/1
}

class Rational(x: Int, y: Int){
	require(y != 0, "denominator must be non-zero")
	
	def this(x: Int) = this(x, 1)
	
	// private helper: client shouldnt see
	private def gcd(a: Int, b: Int): Int = if (b ==0) a else gcd(b, a % b)
	private val g = gcd(x, y)
	def numer = x / g
	def denom = y / g
	// orrr: if numer and denom are called infrequently
	// def numer = x / gcd(x, y)
	// def denom = y / gcd(x, y)
	// ORR : if numer and denom are called often
	// val numer = x / gcd(x, y)
	// val denom = y / gcd(x, y)
	
	// arithmetic on rationals
	def add(that: Rational): Rational =
		new Rational(
			numer * that.denom + that.numer * denom,
		  denom * that.denom)
	
	// printing pretty as string
	override def toString() = numer + "/" + denom
	
	// negation fn
	def neg() = new Rational(-numer, denom)
	
	// sub fn
	//def sub(that: Rational): Rational =
	//	new Rational(
	//		numer * that.denom - that.numer * denom,
	//	  denom * that.denom)
	def sub(that: Rational): Rational = add(that.neg)
	
	//less : comparison operator
	def less(that: Rational) = this.numer * that.denom < that.numer * this.denom
	
	// max
	def max(that: Rational) = if(this.less(that)) that else this
}