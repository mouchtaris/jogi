package patron2.record

trait RelNToN[a <: Record, b <: Record] extends Any with Relation[a, b]
