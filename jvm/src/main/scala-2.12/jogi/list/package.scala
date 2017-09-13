package jogi

package object list extends AnyRef
    with Pigs.PackageExtension {

  type ::[a, b <: Record] = Cons[a, b]

  type Record = a :: b forSome {
    type a
    type b
  }

  type Nil = NilBrick :: NilBrick

}
