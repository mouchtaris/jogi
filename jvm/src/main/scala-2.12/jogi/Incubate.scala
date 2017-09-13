package jogi

object Incubate {

  object patron3 {
    app ⇒
    import list._
    import record._
    import testor._

    object relations {
      trait user_account extends (account `1-n` user)
      trait user_media_item extends (user `1-n` media_item)
      trait user_creative_type extends (user `1-n` creative_type)
      trait cover_media extends (user `1-1` media_item)
      trait like extends (user `1-n` media_item)
      trait following extends (user `1-n` user)
    }

  }
}
