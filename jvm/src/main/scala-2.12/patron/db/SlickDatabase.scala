package patron.db

import com.typesafe.config.Config

abstract class SlickDatabase(
    val conf:              Config,
    val jdbcDriverClass:   Class[t] forSome { type t },
    val slickProfileClass: Class[t] forSome { type t },
    val tables:            schema.traditional.Tables,
    val jdbcUrlConfPath:   String
) {
  final val profile: tables.profile.type = tables.profile
  final val api: profile.api.type = profile.api

  final val jdbcDriver: String = jdbcDriverClass.getName
  final val slickProfile: String = slickProfileClass getName

  final lazy val conn: api.Database = {
    Class forName jdbcDriver // load jdbcDriver
    api.Database forURL (conf getString jdbcUrlConfPath)
  }

}
