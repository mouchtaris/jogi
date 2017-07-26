package patron.db

import patron.db.schema.traditional.Tables

class SlickPostgresqlDatabase(
  confName:   String,
  val tables: Tables = Tables
)
    extends Database {

  val slickProfileClass = classOf[slick.jdbc.PostgresProfile]
  val slickProfile: String = slickProfileClass getName

  val jdbcDriverClass = classOf[org.postgresql.Driver]
  val jdbcDriver: String = jdbcDriverClass getName

  val conn: api.Database = {
    Class forName jdbcDriver // load jdbcDriver
    api.Database forConfig confName
  }
}
