package jogi
package record

import list.{ List }

trait Entity[record <: List] {
  companion ⇒

  trait T extends EntityType[record] {
    final val name: String = companion.toString
  }

  final implicit case object Instance extends T
}