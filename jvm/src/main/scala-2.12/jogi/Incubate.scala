package jogi

object foff {
  def main(args: Array[String]): Unit = {
    println("ibo")
  }
}

object Incubate {

  object patron3 {
    app ⇒
    import list._
    import record._
    import testor._

    object relations {
      trait user_account extends (Account `1-n` User)
      trait user_media_item extends (User `1-n` MediaItem)
      trait user_creative_type extends (User `1-n` CreativeType)
      trait cover_media extends (User `1-1` MediaItem)
      trait like extends (User `1-n` MediaItem)
      trait following extends (User `1-n` User)
    }

  }
}
