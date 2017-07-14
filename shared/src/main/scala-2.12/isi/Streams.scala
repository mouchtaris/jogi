package isi

import java.io.{ ByteArrayOutputStream, CharArrayWriter, PrintStream, PrintWriter }
import java.nio.charset.StandardCharsets

import isi.Collectable._

import scala.util.Try

trait Streams {

  final val StandardCharsetName: String = StandardCharsets.UTF_8.name

  final def streamPrintToString(block: PrintStream ⇒ Unit): Try[String] =
    using(new ByteArrayOutputStream(4096)) { bytes ⇒
      using(new PrintStream(bytes, false, StandardCharsetName)) { stream ⇒
        block(stream)
        stream.flush()
        bytes.flush()
        bytes.toString(StandardCharsetName)
      }
    }.flatten

  final def printToString(block: PrintWriter ⇒ Unit): Try[String] =
    using(new CharArrayWriter(4096)) { chars ⇒
      using(new PrintWriter(chars)) { writer ⇒
        block(writer)
        writer.flush()
        chars.flush()
        chars.toString
      }
    }.flatten

}

object Streams extends Streams