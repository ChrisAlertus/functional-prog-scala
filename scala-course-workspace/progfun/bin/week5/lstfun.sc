package week5
import math.Ordering

object week5 {
	def last[T](xs: List[T]): T = xs match {
		case List() => throw new Error("last of empty list")
		case List(x) => x
		case y :: ys => last(ys)
	} // O(n)                                 //> last: [T](xs: List[T])T

	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("init of empty list")
		case List(x) => Nil
		case y :: ys => y :: init(ys)
		// O(n)
	}                                         //> init: [T](xs: List[T])List[T]
	
	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match { // pattern amtch on xs since we build list from left to right starting with head of xs
		case List() => ys
		case z :: zs => z :: concat(zs,ys)
	} //O(|xs|)                               //> concat: [T](xs: List[T], ys: List[T])List[T]
	
	def reverse[T](xs: List[T]): List[T] = xs match {
		case List() => xs
		case y :: ys => reverse(ys) ++ List(y)
	} // O(M*M)                               //> reverse: [T](xs: List[T])List[T]
	
	//def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
	//	case List() => Nil
	//	case y :: ys => if(n == 0) ys else y :: removeAt(n-1, xs)
	//}
	def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
	
	def flatten(xs: List[Any]): List[Any] = xs match {
		case List() => Nil
		case (z :: zs) :: ys => flatten(z :: zs) ::: flatten(ys)
		case z :: zs => z ::flatten(zs)
	}                                         //> flatten: (xs: List[Any])List[Any]
	flatten(List(List(1,1),2, List(3,List(5,8))))
                                                  //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)

	def msort0(xs: List[Int]): List[Int] = {
		val n = xs.length/2
		if(n == 0) xs
		else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs,ys) match {
				case (Nil,ys) => ys
				case (xs,Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if( x < y) x :: merge(xs1,ys)
					else y :: merge(xs, ys1)
			
			}
		val (fst,snd) = xs splitAt n
		merge(msort0(fst), msort0(snd))
		}
	}                                         //> msort0: (xs: List[Int])List[Int]
	def msort3[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
		val n = xs.length/2
		if(n == 0) xs
		else {
			def merge(xs:List[T], ys:List[T]): List[T] = (xs,ys) match{
				case (Nil,ys) => ys
				case (xs,Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (lt(x,y)) x :: merge(xs1,ys)
					else y :: merge(xs, ys1)
			}
			val (fst,snd) = xs splitAt n
			merge(msort3(fst)(lt), msort3(snd)(lt))
		}
	}                                         //> msort3: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
	// with ordering
	def msort4[T](xs: List[T])(ord: Ordering[T]): List[T] = {
		val n = xs.length/2
		if(n == 0) xs
		else {
			def merge(xs:List[T], ys:List[T]): List[T] = (xs,ys) match{
				case (Nil,ys) => ys
				case (xs,Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (ord.lt(x,y)) x :: merge(xs1,ys)
					else y :: merge(xs, ys1)
			}
			val (fst,snd) = xs splitAt n
			merge(msort4(fst)(ord), msort4(snd)(ord))
		}
	}                                         //> msort4: [T](xs: List[T])(ord: scala.math.Ordering[T])List[T]
	// implicit ordering
	def msort5[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
		val n = xs.length/2
		if(n == 0) xs
		else {
			def merge(xs:List[T], ys:List[T]): List[T] = (xs,ys) match{
				case (Nil,ys) => ys
				case (xs,Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (ord.lt(x,y)) x :: merge(xs1,ys)
					else y :: merge(xs, ys1)
			}
			val (fst,snd) = xs splitAt n
			merge(msort5(fst), msort5(snd))
		}
	}                                         //> msort5: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]
	//def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
		//		case Nil =>
			//		ys
			//	case x :: xs1 =>
			//		ys match {
			//			case Nil =>
			//				xs
			//			case y :: ys1 =>
			//				if(x < y) x :: merge(xs1,ys1)
			//				else y :: merge(xs,ys1)
			//		}
				//case z :: zs => {
				//	if(ys.isEmpty) xs
					//else if(z < ys.head) z :: merge(xs.tail,ys)
					//else ys.head :: merge(xs, ys.tail)
				//}
 val nums = List(8,5,3,4,2,1,1)                   //> nums  : List[Int] = List(8, 5, 3, 4, 2, 1, 1)
	msort3(List(8,5,3,4,2,1,1))((x: Int, y: Int)=> x < y)
                                                  //> res1: List[Int] = List(1, 1, 2, 3, 4, 5, 8)
	
	val fruits = List("apple", "pineapple", "orange")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange)
	msort5(fruits)                            //> res2: List[String] = List(apple, orange, pineapple)
	msort5(nums)                              //> res3: List[Int] = List(1, 1, 2, 3, 4, 5, 8)
}

object lstfun {
  println("Welcome to the Scala worksheet")
}