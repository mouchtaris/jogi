package patron
package cross.jvm

final case class App() {

  def main(args: Array[String]): Unit = {
    val accounts: isi.store.Repository = isi.store.cross.jvm.InMemory()
  }

}
