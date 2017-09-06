package patron2
import predef._

object Incubate {

  object record {
    import patron2.record.{ Nil, _ }

    import patron2.typelevel._
    import typelevel._

  }

  object patron3 {
    app ⇒
    import patron2.record._

    type Bytes = Array[Byte]
    trait Enum extends (Value.Int :: Nil) {
      trait values
    }

    trait Value[t]

    object Value {
      def apply[t](): Value[t] = new Value[t] {}
      trait String extends Value[Predef.String]
      trait Bytes extends Value[patron3.Bytes]
      trait Int extends Value[scala.Int]
      trait Boolean extends Value[scala.Boolean]
      trait Uri extends Value[akka.http.scaladsl.model.Uri]
      implicit case object String extends String
      implicit case object Bytes extends Bytes
      implicit case object Int extends Int
      implicit case object Boolean extends Boolean
      implicit def singleFieldValue[t: Value]: Value[t :: Nil] = Value()
      type of[t] = t :: Nil
    }

    object values {
      trait email extends Value.String
      trait passhash extends Value.Bytes
      trait passsalt extends Value.Bytes

      object account {
        trait email extends values.email
        trait passhash extends values.passhash
        trait passsalt extends values.passsalt
      }
      trait account extends (account.email :: account.passhash :: account.passsalt :: Nil)

      trait creative_type extends Enum
      object creative_type {
        trait music extends creative_type
        trait photo extends creative_type
        trait dance extends creative_type
        trait theater extends creative_type
      }

      object user {
        trait `type` extends Enum
        object `type` {
          trait creative extends `type`
          trait patron extends `type`
        }

        trait creative_type extends values.creative_type
        trait bio extends Value.String

        final implicit case object user extends user
      }
      trait user extends (user.`type` :: user.bio :: Nil)

      object media_item {
        trait uri extends Value.Uri
        trait title extends Value.String
        trait description extends Value.String

        trait `type` extends Enum
        trait image extends `type`
        trait video extends `type`
        trait audio extends `type`
      }
      trait media_item extends (media_item.uri :: media_item.title :: media_item.`type` :: media_item.description :: Nil)
    }

    object relations {
      import values._
      trait user_account extends (account `1-n` user)
      trait user_media_item extends (user `1-n` media_item)
      trait user_creative_type extends (user `1-n` creative_type)
      trait cover_media extends (user `1-1` media_item)
      trait like extends (user `1-n` media_item)
      trait following extends (user `1-n` user)
    }

  }
}