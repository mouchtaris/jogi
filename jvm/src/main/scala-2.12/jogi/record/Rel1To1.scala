package jogi
package record

import list.Record

trait Rel1To1[a <: Record, b <: Record] extends Any with Relation[a, b]