package leon

object Main {

  def main(args: Array[String]): Unit = {

    val cleaner = Cleaner()

    cleaner deleteErrors ()
    //    println(cleaner.errors)
    //    println(cleaner.errorEntries)
  }

}
