package jogi
package record

import list.List

trait Rel1ToN[a <: List, b <: List] extends Any with Relation[a, b]