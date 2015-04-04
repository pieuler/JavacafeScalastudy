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
val cv1 : Covariant[AnyRef]
    = new Covariant[String]
//val cv2 : Covariant[String]
//    = new Covariant[AnyRef]
