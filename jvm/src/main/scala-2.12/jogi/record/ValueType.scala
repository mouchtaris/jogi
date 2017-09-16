package jogi.record

trait ValueType[scalaType] {
  final type ScalaType = scalaType
  val name: String
}
