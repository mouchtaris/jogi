package jogi
import predef._

object foff {
  def main(args: Array[String]): Unit = {
    Incubate.record.main(args)
  }
}

object Incubate {

  object pig {
    trait Pig[t] {
      final type T = t
      val desc: String
      final override def toString: String = desc
    }

    object Pig {
      //      @inline implicit def forType[t: ClassTag]: Pig[t] =
      //        new Pig[t] {
      //          val desc: String = implicitly[ClassTag[t]].runtimeClass.getName
      //        }

      @inline def apply[t](d: String): Pig[t] =
        new Pig[t] {
          val desc: String = d
        }

      @inline def apply[t: Pig]: Pig[t] =
        implicitly

      @inline def of[t: Pig](t: t): Pig[t] =
        Pig[t]
    }
  }

  object record {
    import jogi.list
    import list.{ Nil, _ }
    import list.ops._

    import jogi.typelevel._
    import typelevel._
    import pig.Pig

    implicit val shortPig: Pig[Short] = Pig("Short")
    implicit val intPig: Pig[Int] = Pig("Int")
    implicit val longPig: Pig[Long] = Pig("Long")
    implicit val stringPig: Pig[String] = Pig("String")
    implicit val floatPig: Pig[Float] = Pig("Float")
    implicit val doublePig: Pig[Double] = Pig("Double")
    //    implicit val charPig: Pig[Char] = Pig("Char")
    //    implicit val nothingPig: Pig[Nothing] = Pig("Nothing")
    implicit val unitPig: Pig[Unit] = Pig("Unit")
    implicit val nilPig: Pig[Nil] = Pig("Nil")

    @inline implicit def vectorPig[vectorT: Pig]: Pig[Vector[vectorT]] =
      Pig(s"Vector[${Pig[vectorT]}]")

    @inline implicit def recordPig[h: Pig, t <: Record: Pig]: Pig[h :: t] =
      Pig(s"${Pig[h]} :: ${Pig[t]}")

    @inline implicit def containsPig[a: Pig, s <: Record: Pig]: Pig[Contains[s, a]] =
      Pig(s"(${Pig[a]} in ${Pig[s]})")

    @inline implicit def andPig[a: Pig, b: Pig]: Pig[And[a, b]] =
      Pig(s"${Pig[a]} AND ${Pig[b]}")

    def main(args: Array[String]): Unit = {

      type s = Short :: Int :: Long :: Float :: Double :: String :: Unit :: Nil

      type a = Long :: Double :: Nil

      //      type b = Short :: Float :: Unit :: Vector[Int] :: Nil
      //
      //      trait c
      //      trait d
      //      trait e
      //      implicit object c extends c
      //      implicit object d extends d
      //      implicitly[And[c, d]]
      //      type known[t] = t
      //      type li = c :: d :: Nil
      //      val li: li = new c {} :: new d {} :: Nil
      //      val lm = imply[ListMap[known, li]]
      //      val w: lm.Out = c :: d :: Nil
      //      trait clue[a]
      //      implicit object cluec extends clue[c]
      //      implicit object clued extends clue[d]
      //      val cluelm = imply[ListMap[clue, li]]
      //      val ww: cluelm.Out = new clue[c] {} :: new clue[d] {} :: Nil
      //      val cluefm = imply[ListMap[clue, a :: b :: Nil]]
      //      val wwf: cluefm.Out = new clue[a] {} :: new clue[b] {} :: Nil
      //      implicitly[ListFold[And, lm.Out]]
      //      val lf = imply[ListFold[And, cluelm.Out]]
      //      val lff = imply[ListFold[And, cluefm.Out]]
      //      implicitly[lf.Out]
      //      implicitly[ForAll[li, clue]]
      //      implicitly[Contains[a, Long]]
      //      proof: ForAll[a, Contains.in[s]#typ]
      //      listMap:  ListMap.Aux[pred, r, mapOut],
      val lm = imply[ListMap[Contains.in[s]#typ, a]]
      val lf = imply[ListFold[And, lm.Out]]
      val fa = imply[ForAll[a, Contains.in[s]#typ]]
      val subs = imply[Subset[a, s]]
      type tryme = lf.Out
      val pig = Pig[tryme]
      val triedme = imply[tryme]
      val pig2 = Pig of triedme
      println(pig)
      println(pig2)
      //      val proof = implicitly[lf.Out]
      //            implicitly[ForAll[a, Contains.in[s]#typ]]
      //      implicitly[Subset[a, s]]
    }
  }

  object patron3 {
    app ⇒
    import jogi.list._

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
