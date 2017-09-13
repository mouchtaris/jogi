package patron2

package object record extends AnyRef
    with Subset.PackageExtension {

  type ::[a, b <: Record] = Cons[a, b]

  type Record = a :: b forSome {
    type a
    type b
  }

  type Nil = NilBrick :: NilBrick

  type `1-1`[a <: Record, b <: Record] = Rel1To1[a, b]
  type `1-n`[a <: Record, b <: Record] = Rel1ToN[a, b]
  type `n-n`[a <: Record, b <: Record] = RelNToN[a, b]

}
