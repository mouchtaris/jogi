package jogi
package record

import list.Record

trait RelNToN[a <: Record, b <: Record] extends Any with Relation[a, b]
