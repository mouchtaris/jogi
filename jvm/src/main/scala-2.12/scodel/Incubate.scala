package scodel

import shapeless.ops.tuple.ToTraversable

import scala.reflect.ClassTag
import shapeless.{::, HList, HNil, Lub, poly}

import scala.annotation.tailrec

trait Incubate {

  trait inc {

    final case class typ[t](
      runtimeClass: Class[t]
    )

    object typ {
      def apply[t: ClassTag]: typ[t] = typ(
        implicitly[ClassTag[t]].runtimeClass.asInstanceOf[Class[t]]
      )
    }

    abstract class Struct[fields](
      final val fields: fields
    ) {
      final val name: String = toString
    }

  }

  trait listop {
    trait Collect[a] {
      type Out
      val pf: PartialFunction[a, Out]
    }
    object Collect {
      type Aux[a, r] = Collect[a] { type Out = r }
      def apply[a: Collect]: Collect[a] = implicitly
      def apply[a, r](_pf: PartialFunction[a, r]): Aux[a, r] = new Collect[a] {
        type Out = r
        val pf: PartialFunction[a, r] = _pf
      }
    }

    trait ListCollect[l <: HList] {
      type Out <: HList
      def apply(l: l): Out
    }

    object ListCollect {
      type Aux[l <: HList, r <: HList] = ListCollect[l] { type Out = r }

      implicit val forHNil: Aux[HNil, HNil] = new ListCollect[HNil] {
        type Out = HNil
        def apply(l: HNil): HNil = l
      }

      implicit def forHList[h, t <: HList](implicit col: Collect[h], lcol: ListCollect[t]): Aux[h :: t, Option[col.Out] :: lcol.Out] =
        new ListCollect[h :: t] {
          private[this] final val none: Any ⇒ Option[col.Out] = _ ⇒ None
          private[this] final val lnone: Any => HNil = _ ⇒ HNil
          type Out = Option[col.Out] :: lcol.Out
          def apply(l: h :: t): Out = l match {
            case h :: t ⇒
              val opt1 = if (col.pf.isDefinedAt(h)) Some(col.pf(h)) else None
              opt1 :: lcol(t)
          }
        }

      def apply[l <: HList](l: l)(implicit lcol: ListCollect[l]): lcol.Out = lcol(l)
    }

    trait Map[a] {
      type Out
      def apply(a: a): Out
    }
    object Map {
      type Aux[a, r] = Map[a] { type Out = r }
    }

    trait ListMap[l <: HList] {
      type Out <: HList
      def apply(l: l): Out
    }

    object ListMap {
      type Aux[l <: HList, r <: HList] = ListMap[l] { type Out = r }

      implicit def forHNil: ListMap.Aux[HNil, HNil] = new ListMap[HNil] {
        type Out = HNil
        def apply(l: HNil): HNil = l
      }

      implicit def forHList[h, t <: HList](implicit map: Map[h], lmap: ListMap[t]): ListMap.Aux[h :: t, map.Out :: lmap.Out] =
        new ListMap[h :: t] {
          type Out = map.Out :: lmap.Out
          def apply(l: h :: t): Out = l match {
            case h :: t ⇒ map(h) :: lmap(t)
          }
        }

      def apply[l <: HList](l: l)(implicit lmap: ListMap[l]): lmap.Out = lmap(l)
    }
  }

  trait gen {
    type Inc <: inc
    val inc: Inc
    type ListOp <: listop
    val listop: ListOp

    import listop.{ ListMap }

    final def genCaseClass[fields <: HList, lub](struct: inc.Struct[fields]): String = {
      s"""
         |final case class ${struct.name} {
       """.stripMargin
    }

  }
}

object test {

  app ⇒
  object Incubate extends Incubate
  object inc extends Incubate.inc
  object listop extends Incubate.listop
  object gen extends Incubate.gen {
    final type Inc = app.inc.type
    final val inc: Inc = app.inc
    final type ListOp = app.listop.type
    final val listop: ListOp = app.listop
  }

  final case object Point extends inc.Struct(
    fields =
      ('x → inc.typ[Int]) ::
        ('y → inc.typ[Int]) ::
        HNil
  )

  def main(args: Array[String]): Unit = {
    println { Point.fields }
    println { gen.genCaseClass(Point) }
    println {
      implicit def map[s, t]: listop.Map.Aux[(s, inc.typ[t]), String] =
        new listop.Map[(s, inc.typ[t])] {
          type Out = String
          def apply(p: (s, inc.typ[t])): String = p._1.toString
        }

      listop.ListMap(Point.fields)
    }
    println {
      implicit def col[s, t]: listop.Collect.Aux[(s, inc.typ[t]), String] =
        new listop.Collect[(s, inc.typ[t])] {
          type Out = String
          val pf: PartialFunction[(s,inc.typ[t]), String] = {
            case p ⇒ p._1.toString
          }
        }

      listop.ListCollect(Point.fields)
    }
    println {
      Point.fields.toList
    }
  }

}