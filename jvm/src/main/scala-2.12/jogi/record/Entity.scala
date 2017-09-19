package jogi
package record

import typelevel.list.{ List }

/**
 * A marker trait for an Entity (not a value0.
 *
 * @tparam record the underlying values, composing this entity
 */
trait Entity[record <: List]