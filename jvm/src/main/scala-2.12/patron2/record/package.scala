package patron2

package object record {

  type Record = a :: b forSome {
    type a
    type b
  }

  type `1-1`[a <: Record, b <: Record] = rel_1_to_1[a, b]
  type `1-n`[a <: Record, b <: Record] = rel_1_to_n[a, b]
  type `n-n`[a <: Record, b <: Record] = rel_n_to_n[a, b]

}
