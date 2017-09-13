package jogi

object foff {
  def main(args: Array[String]): Unit = {
    println("ibo")
    Incubate.patron3.main(args)
  }
}

object Incubate {

  object patron3 {
    app ⇒
    import record._
    import testor._
    import predef._

    def main(args: Array[String]): Unit = {
      val ral = imply[RelationAlias[Following]]
      val n1 = implicitly[ral.NameA].toString
      val n2 = implicitly[ral.NameB].toString
      println(s"$ral: $n1 + $n2")
    }

    object relations {
      trait user_account extends (Account `1-n` User)
      trait user_media_item extends (User `1-n` MediaItem)
      trait user_creative_type extends (User `1-n` CreativeType)
    }

  }
}
