package jogi

package object list extends AnyRef
    with Pigs.PackageExtension {

  type ::[a, b <: List] = Cons[a, b]

  type List = a :: b forSome {
    type a
    type b
  }

  type Nil = NilBrick :: NilBrick

}
