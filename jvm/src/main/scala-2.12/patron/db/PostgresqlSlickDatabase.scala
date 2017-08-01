package patron.db

import com.typesafe.config.Config
import patron.db.schema.traditional.Tables

class PostgresqlSlickDatabase(
  jdbcUrlConfPath: String,
  conf:            Config,
  tables:          Tables = Tables
)
    extends SlickDatabase(
      conf              = conf,
      jdbcUrlConfPath   = jdbcUrlConfPath,
      tables            = tables,
      jdbcDriverClass   = classOf[org.postgresql.Driver],
      slickProfileClass = classOf[slick.jdbc.PostgresProfile]
    )
