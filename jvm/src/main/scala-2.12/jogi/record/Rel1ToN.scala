package jogi
package record

import list.Record

trait Rel1ToN[a <: Record, b <: Record] extends Any with Relation[a, b]