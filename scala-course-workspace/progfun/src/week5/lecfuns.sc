package week5

object lecfuns {
  def scaleList2(xs: List[Double], factor: Double): List[Double] = xs match {
  	case Nil => xs
  	case y :: ys => y * factor :: scaleList2(ys, factor)
  }                                               //> scaleList2: (xs: List[Double], factor: Double)List[Double]
  
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil     => Nil
    case y :: ys => y*y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x*x)                             //> squareList2: (xs: List[Int])List[Int]
    
  def posElems(xs: List[Int]): List[Int] = xs match {
		case Nil => xs
		case y :: ys => if(y > 0) y :: posElems(ys) else posElems(ys)
	}                                         //> posElems: (xs: List[Int])List[Int]
	
	def posElems2(xs: List[Int]): List[Int] =
		xs filter (x => x > 0)            //> posElems2: (xs: List[Int])List[Int]
		
		
	def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
    		val (first, rest) = xs span (y => y == x)
    		first :: pack(rest)
	}                                         //> pack: [T](xs: List[T])List[List[T]]
  def encode[T](xs: List[T]): List[(T,Int)] = {
  	 pack(xs) map (ys => (ys.head,ys.length))
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  
  
  def sum(xs: List[Int]) = (xs foldLeft 0) (_+_)  //> sum: (xs: List[Int])Int
	def product(xs: List[Int]) = (xs foldLeft 1) (_*_)
                                                  //> product: (xs: List[Int])Int
	
	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())((x,y) => f(x) :: y ) //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (x,y) => 1 + y )            //> lengthFun: [T](xs: List[T])Int
	
  // Examples
  
	val data = List("a","a","a","b","c","c","a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
 	pack(data)                                //> res0: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )
	encode(data)                              //> res1: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
	
	
	 val nums = List(8,-5,3,4,2,-1,1)         //> nums  : List[Int] = List(8, -5, 3, 4, 2, -1, 1)
	 val fruits = List("apple", "pineapple", "orange")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange)
	 
	 nums filter (x => x > 0)                 //> res2: List[Int] = List(8, 3, 4, 2, 1)
	 nums filterNot (x => x > 0)              //> res3: List[Int] = List(-5, -1)
	 nums partition (x => x > 0)              //> res4: (List[Int], List[Int]) = (List(8, 3, 4, 2, 1),List(-5, -1))
	 
	 nums takeWhile (x => x > 0)              //> res5: List[Int] = List(8)
	 nums dropWhile (x => x > 0)              //> res6: List[Int] = List(-5, 3, 4, 2, -1, 1)
	 nums span (x => x > 0)                   //> res7: (List[Int], List[Int]) = (List(8),List(-5, 3, 4, 2, -1, 1))
	 
	 mapFun(nums, (x: Int) =>( x + 1))        //> res8: List[Int] = List(9, -4, 4, 5, 3, 0, 2)
	 lengthFun(Nil)                           //> res9: Int = 0
}

abstract class List2[T] {
	// Map: apply to all
	//def map[U](f: T => U): List[U] = this match {
	//	case Nil => this
	//	case x :: xs => f(x) :: xs.map(f)
	//}
	
	def scaleList(xs: List[Double], factor: Double) =
		xs map (x => factor * x)
	// Filtering
	
	//def filter(p: T => Boolean): List[T] = this match {
	//	case Nil => this
	//	case y :: ys => if(p(y)) y :: ys.filter(p) else ys.filter2(p)
	//}
	// List Reduction
//	def reduceLeft(op: (T,T) => T): T = this match {
//		case Nil => throw new Error("Nil.reduceLeft")
//		case x :: xs => (xs foldLeft x)(op)
//	}
	
	//def foldLeft[U](z: U)(op: (U,T) => U): U = this match {
	//	case Nil => z
	//	case x :: xs => (xs foldLeft op(z,x))(op)
	//}
	
	//def reduceRight(op: (T,T) => T): T = this match {
	//	case Nil => throw new Error("Nil.reduceRight")
	//	case x :: Nil => x
	//	case x :: xs => op(x, xs.reduceRight(op))
	//}
	
	//def foldRight[U](z: U)(op: (U,T) => U): U = this match {
	//	case Nil => z
	//	case x :: xs => op(x, (xs foldRight z)(op))
	//}
	
	//def concat[T](xs: List[T], ys: List[T]): List[T]
	//	(xs foldRight ys) (_::_)
		
		

}