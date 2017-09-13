package jogi
package record

import list.List

trait Relation[a <: List, b <: List] extends Any {
  final type A = a
  final type B = b
}

object Relation {

  type Any = Relation[a, b] forSome {
    type a <: List
    type b <: List
  }

}