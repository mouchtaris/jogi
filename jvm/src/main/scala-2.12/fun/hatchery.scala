package fun

object hatchery {
  def imply[e <: AnyRef](implicit e: e): e.type = e
}

object test {
  app ⇒

  def main(args: Array[String]): Unit = {

    import list._
    import ops._
    //    import wat._

    val li = 1 :: "hello" :: 45.45 :: nil

    //    val omg = wat.ops(nil).to[Vector]

  }
}

