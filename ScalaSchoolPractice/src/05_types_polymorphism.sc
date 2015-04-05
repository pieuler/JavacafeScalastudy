/* Parametric Polymorphism */
val res = 2 :: 1 :: "bar" :: "foo" :: Nil
res.head


def drop[A](l: List[A]) = l.tail
drop(res)
drop(List(1,2,3))


/* rank-1 polymorphism */
def toList[A](a: A) = List(a)
//def foo[A,B](f: A => List[A], b: B) = f(b)
//def foo[A](f: A => List[A], b: Int) = f(b)


/* Type Inference */
//{ x => x }
def id[T](x: T) = x
val x = id(322)
val y = id("hey")
val z = id(Array(1,2,3,4))


/* Variance */
// co-variant     [+T]
// contra-variant [-T]
// in-variant     [T]


class Covariant[+A]
val cv1 : Covariant[AnyRef] = new Covariant[String]
//val cv2 : Covariant[String] = new Covariant[AnyRef]

class Convariant[-A]
val cnv1: Convariant[String] = new Convariant[AnyRef]
//val cnv2: Convariant[AnyRef] = new Convariant[String]

// trait Function1 [-T1, +R] extends AnyRef
class Animal                 {          val sound = "rustle" }
class Bird    extends Animal { override val sound = "call"   }
class Chicken extends Bird   { override val sound = "cluck"  }

// ContraVariant for Parameter (Bird < Animal)
val getTweeet: ( Bird=>String ) = {
  (a: Animal) => a.sound
}
// CoVariant for Return (Bird > Chicken)
val hatch: ( ()=>Bird ) = {
  () => new Chicken
}


/* Bound */

//def cacophony[T](things: Seq[T]) = things.map(_.sound)
def biophony[T <: Animal](things: Seq[T]) = things.map(_.sound)
biophony(Seq(new Chicken, new Bird))

