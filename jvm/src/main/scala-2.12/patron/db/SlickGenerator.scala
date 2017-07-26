package patron.db

object SlickGenerator {

  /**
   * <pre>
   * uri Config URL and/or fragment for path in typesafe config, e.g. “url#slick.db.default”
   * profile Fully qualified name of the profile class, e.g. “slick.jdbc.H2Profile”
   * jdbcDriver Fully qualified name of the JDBC driver class, e.g. “org.h2.Driver”
   * url JDBC url, e.g. “jdbc:postgresql://localhost/test”
   * outputFolder Place where the package folder structure should be put
   * pkg Scala package the generated code should be places in
   * user database connection user name
   * password database connection password
   * </pre>
   */
  def main(args: Array[String]): Unit = {
    val database = new SlickPostgresqlDatabase(args(0))
    val profile: String = database.slickProfile
    val jdbcDriver: String = database.jdbcDriver
    val user = "pat"
    val password = "pat"
    val url = "jdbc:postgresql:pat"
    val outputFolder = "/home/nikos/op/poli/jogi-js/jvm/src/main/scala-2.12/"
    val pkg = "patron.db.schema.traditional"

    slick.codegen.SourceCodeGenerator.main(
      Array(profile, jdbcDriver, url, outputFolder, pkg, user, password)
    )

  }

}
