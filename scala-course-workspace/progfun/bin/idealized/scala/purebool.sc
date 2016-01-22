package idealized.scala

object purebool {
  println("Welcome to the Scala worksheet")
  
  //if (cond) te else ee
  //cond.ifThenElse(te,ee)
  //(1 > 2).ifThenElse(true,false)
}


class Int {
	def + (that: Double): Double
	def + (that: Long): Long
	def + (that: Float): Float
	def + (that: Int): Int // same for -, *, /, %
	
	def << (cnt: Int): Int // same for >>, >>>,
	
	def & (that: Long): Long
	def & (that: Int): Int // same for |, ^
	
	def == (that: Double): Boolean
	def == (that: Float): Boolean
	def == (that: Long): Boolean // same for !=, <, >, <=, >=
}