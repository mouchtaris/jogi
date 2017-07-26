package patron.db

trait Database {
  val tables: schema.traditional.Tables

  final val profile: tables.profile.type = tables.profile
  final val api: profile.api.type = profile.api

  val conn: api.Database
}
