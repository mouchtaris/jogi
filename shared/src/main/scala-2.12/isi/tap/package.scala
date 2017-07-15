package isi

package object tap {

  final implicit class TapDecoration[t](val self: t) extends AnyVal {
    def tap[r](block: t ⇒ Unit): t = { block(self); self }
  }

}
