package week3

object intsets {
  println("Welcome to the Scala worksheet")
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 3
  val t3 = Empty
  val t4 = Empty
  val t5 = t3 union t4
  
  val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
	val b: Array[IntSet] = a
	b(0) = Empty
	val s: NonEmpty = a(0)
}

// abstract classes
  abstract class IntSet{
  	def incl(x: Int): IntSet
  	def contains(x: Int): Boolean
  	def union(other: IntSet): IntSet
  }
  
  //class Empty extends IntSet {
  object Empty extends IntSet {
  	def contains(x: Int): Boolean = false
  	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  	override def toString = "."
  	def union(other: IntSet): IntSet = other
  }
  
  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  	def contains(x: Int): Boolean =
  		if (x < elem) left contains x
  		else if (x > elem) right contains x
  		else true
  	
  	def incl(x: Int): IntSet =
  		if (x < elem) new NonEmpty(elem, left incl x, right)
  		else if (x > elem) new NonEmpty(elem, left, right incl x)
  		else this
  	def union(other: IntSet): IntSet =
  		(((left union right) union other) incl elem)
  		// each time union called it is on a smaller intset and so it eventually terminates
  	override def toString = "{" + left + elem + right + "}"
  }
  
  