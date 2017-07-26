package leon

import java.nio.file.{ Path, Paths }

import isi.tap._
import leon.Cleaner._
import org.jruby.embed.ScriptingContainer
import spray.json.DefaultJsonProtocol._
import spray.json._

import scala.language.postfixOps

final case class Cleaner(
    errorIn: String = samplein,
    root:    Path   = Paths get "/host/vbshare/_leon/arch"
) {

  val Error = raw"\s*::\s*File (.*) is corrupted".r.unanchored

  /** Get errors from errorIn */
  lazy val errors: Set[Path] =
    Error findAllMatchIn errorIn map (_ group 1) map (Paths get _) map (_ getFileName) toSet

  val index: Path =
    root resolve "human_index"

  val indexFiles: Array[Path] =
    index toFile () list () map (index resolve _)

  val converterArgv: Array[String] =
    indexFiles map (_ toString)

  val jruby: ScriptingContainer =
    new ScriptingContainer()
      .tap(_ setArgv converterArgv)

  val jsonString: String = {
    val output = "Json"
    jruby runScriptlet converterRb(output)
    (jruby get output).asInstanceOf[String]
  }

  val json: JsObject =
    jsonString.parseJson asJsObject ()

  val entries: Map[Path, Path] =
    json.fields map {
      case (pathName, JsArray(values)) ⇒
        val path = root resolve (Paths get pathName getFileName ()) normalize ()
        val `package` = Paths get values.last.convertTo[String] normalize ()
        (path, `package`)

      case (pathname, json) ⇒
        throw new Exception(s"Json entry for $pathname is not an array of strings but $json")
    }

  val errorEntries: Map[Path, Path] =
    entries collect {
      case entry @ (_, pack) if errors contains pack ⇒ entry
    }

  def deleteErrors(): Unit = {
    import Console.{ CYAN, GREEN, RED, RESET }
    errorEntries foreach {
      case (path, pack) ⇒
        val file = path toFile ()
        print(s"deleting $CYAN$pack$RESET (${if (file.exists) "found" else s"not found: $path"})")
        val result = file.delete()
        println(if (result) s"$GREEN OK$RESET" else s"$RED FAIL$RESET")
    }
  }

}

object Cleaner {

  val samplein: String =
    """
      |error: glibc: signature from "Jan Alexander Steffens (heftig) <jan.steffens@gmail.com>" is invalid
      |:: File /var/cache/pacman/pkg/glibc-2.25-5-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: gtk3: signature from "Jan Alexander Steffens (heftig) <jan.steffens@gmail.com>" is invalid
      |:: File /var/cache/pacman/pkg/gtk3-3.22.16-1-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: libbluray: signature from "Maxime Gauduin <alucryd@alucryd.xyz>" is invalid
      |:: File /var/cache/pacman/pkg/libbluray-1.0.1-1-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: systemd: signature from "Christian Hesse (Arch Linux Package Signing) <arch@eworm.de>" is invalid
      |:: File /var/cache/pacman/pkg/systemd-233.75-3-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: electron: signature from "Bartlomiej Piotrowski <b@bpiotrowski.pl>" is invalid
      |:: File /var/cache/pacman/pkg/electron-1.4.16-3-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: python2: signature from "Evangelos Foutras <evangelos@foutrelis.com>" is invalid
      |:: File /var/cache/pacman/pkg/python2-2.7.13-3-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: atom: signature from "Nicola Squartini <tensor5@gmail.com>" is invalid
      |:: File /var/cache/pacman/pkg/atom-1.18.0-2-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: mariadb: signature from "Christian Hesse (Arch Linux Package Signing) <arch@eworm.de>" is invalid
      |:: File /var/cache/pacman/pkg/mariadb-10.1.25-1-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: tcl: signature from "Antonio Rojas <arojas@archlinux.org>" is invalid
      |:: File /var/cache/pacman/pkg/tcl-8.6.6-2-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: bullet: signature from "Sven-Hendrik Haase <svenstaro@gmail.com>" is invalid
      |:: File /var/cache/pacman/pkg/bullet-2.86-2-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: gcc: signature from "Bartlomiej Piotrowski <b@bpiotrowski.pl>" is invalid
      |:: File /var/cache/pacman/pkg/gcc-7.1.1-3-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: clang: signature from "Evangelos Foutras <evangelos@foutrelis.com>" is invalid
      |:: File /var/cache/pacman/pkg/clang-4.0.1-1-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: firefox: signature from "Jan Alexander Steffens (heftig) <jan.steffens@gmail.com>" is invalid
      |:: File /var/cache/pacman/pkg/firefox-54.0.1-1-x86_64.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: intellij-idea-community-edition: signature from "Lukas Jirkovsky <l.jirkovsky@gmail.com>" is invalid
      |:: File /var/cache/pacman/pkg/intellij-idea-community-edition-2:2017.1.4-1-any.pkg.tar.xz is corrupted (invalid or corrupted package (PGP signature)).
      |Do you want to delete it? [Y/n]
      |error: failed to commit transaction (invalid or corrupted package)
      |
    """.stripMargin

  final def converterRb(output: String): String =
    s"""
      |require 'yaml'
      |require 'json'
      |
      |$output = ARGV
      | .map(&File.method(:read))
      | .map(&YAML.method(:load))
      | .zip(ARGV)
      | .map { |j, n| [n, j] }
      | .to_h
      | .to_json
    """.stripMargin

}