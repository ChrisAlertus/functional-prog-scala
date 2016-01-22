package week5

object pairs {
  // want all pairs (i,j) where 1 <= j < i < n and i + j is prime
	// functional way: generate all pairs (i,j) then filter to condition
	//def ourseq(i: Int,j: Int,n: Int) =
	def isPrime(n: Int): Boolean =
		(2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
	val n = 7                                 //> n  : Int = 7
	(1 until n) flatMap ( i =>
		(1 until i) map (j => (i,j))) filter (pair =>
			isPrime(pair._1 + pair._2))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
 for {
		i <- 1 until n
		j <- 1 until i
		if isPrime(i + j)
	} yield (i,j)                             //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
	(for ((x,y) <- xs zip ys) yield (x * y)).sum
                                                  //> scalarProduct: (xs: List[Double], ys: List[Double])Double
// vector because the map modified range is an indexed seq
// and the default type is a vector
//hence need to concat elemnt vectors into one list of pairs
// with a vecotr of seq can combine with foldright concat
//(xss foldRight Seq[Int]())(_ ++ _)

//OR

//xss.flatten
}