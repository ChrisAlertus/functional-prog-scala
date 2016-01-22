package week4
//import week4.Rationals             - named imports
//import week4.{Rational, Hello}     - named imports
import week4._               //      - wildcard import

object scratch {
 	new Rationals(1,2)                        //> res0: week4.Rationals = 1/2
 	
 	def error(msg: String) = throw new Error(msg)
                                                  //> error: (msg: String)Nothing
 	
 	//error("Test")
 	 // return type is nothing and error thrown
  
  val x = null                                    //> x  : Null = null
	val y: String = null                      //> y  : String = null
	//val z: Int = null // type mismatch
}