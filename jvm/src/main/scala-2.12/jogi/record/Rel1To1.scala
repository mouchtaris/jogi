package jogi
package record

import list.List

trait Rel1To1[a <: List, b <: List] extends Any with Relation[a, b]