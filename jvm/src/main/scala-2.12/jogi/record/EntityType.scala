package jogi
package record

import list.{ List }

trait EntityType[record <: List] {
  final type Record = record
  val name: String
}