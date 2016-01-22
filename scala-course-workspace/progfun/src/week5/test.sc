package week5

object test {
  

// array working like a sequence
val xs = Array(1,2,3,44)                          //> xs  : Array[Int] = Array(1, 2, 3, 44)
xs map (x=> x*2)                                  //> res0: Array[Int] = Array(2, 4, 6, 88)

// string working like a sequence
val s1 = "Hello World"                            //> s1  : String = Hello World
s1 filter (c => c.isUpper)                        //> res1: String = HW

val r: Range = 1 until 5                          //> r  : Range = Range(1, 2, 3, 4)
val s: Range = 1 to 5                             //> s  : Range = Range(1, 2, 3, 4, 5)
1 to 10 by 3                                      //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
6 to 1 by -2                                      //> res3: scala.collection.immutable.Range = Range(6, 4, 2)

s1 exists (c => c.isUpper)                        //> res4: Boolean = true
s1 forall (c => c.isUpper)                        //> res5: Boolean = false

val pairs = s1 zip xs                             //> pairs  : scala.collection.immutable.IndexedSeq[(Char, Int)] = Vector((H,1), 
                                                  //| (e,2), (l,3), (l,44))
pairs.unzip                                       //> res6: (scala.collection.immutable.IndexedSeq[Char], scala.collection.immutab
                                                  //| le.IndexedSeq[Int]) = (Vector(H, e, l, l),Vector(1, 2, 3, 44))
s1 flatMap (c=> List('.',c))                      //> res7: String = .H.e.l.l.o. .W.o.r.l.d

xs.sum                                            //> res8: Int = 50
xs.max                                            //> res9: Int = 44
xs.min                                            //> res10: Int = 1

// All combinations x,y where x from 1..M and y from 1..N:

val M = 2                                         //> M  : Int = 2
val N = 3                                         //> N  : Int = 3
(1 to M) flatMap (x => 1 to N map (y=> (x,y)))    //> res11: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,
                                                  //| 2), (1,3), (2,1), (2,2), (2,3))

// Scalar product of two vectors
def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
	// method 1 : literal
	//(xs zip ys).map(xy=> xy._1 * xy._2).sum
	// method 2 pattern amtch
	(xs zip ys).map{ case (x,y) => x*y }.sum  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double

(1 until 4).map(x => 4 % x == 0)                  //> res12: scala.collection.immutable.IndexedSeq[Boolean] = Vector(true, true, f
                                                  //| alse)
// isprime
def isPrime(n: Int): Boolean =
	(2 until n) forall (d => n % d != 0)      //> isPrime: (n: Int)Boolean
	//(2 until n).map(x => n % x == 0) forall (y => y == false)
	
isPrime(26)                                       //> res13: Boolean = false
}