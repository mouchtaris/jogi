package isi

import scala.reflect.{ ClassTag ⇒ sClassTag }

trait ClassTag {

  @inline final def classTag[t: sClassTag]: sClassTag[t] = implicitly

}

object ClassTag extends ClassTag
