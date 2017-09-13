package jogi
package record

import list.List

trait RelNToN[a <: List, b <: List] extends Any with Relation[a, b]
