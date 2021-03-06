package patron.db.schema.traditional
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{ GetResult ⇒ GR }

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(AdditionalEmails.schema, Addresses.schema, Admins.schema, Availabilities.schema, BankAccounts.schema, BookingInstances.schema, BookingOptions.schema, CancellationPolicies.schema, CollectionItems.schema, Collections.schema, Conversations.schema, ConversationUsers.schema, CoverMedia.schema, CreativeTypeMaps.schema, CreativeTypes.schema, CreditCards.schema, FeaturedCreatives.schema, Follows.schema, InviteRequests.schema, Inviters.schema, Likes.schema, Locations.schema, ManagedAccounts.schema, Media.schema, Messages.schema, MessageTemplates.schema, NotificationCenters.schema, Notifications.schema, OauthAccessGrants.schema, OauthAccessTokens.schema, OauthApplications.schema, PatronMembers.schema, Payments.schema, Reviews.schema, SchemaMigrations.schema, ServiceOptions.schema, Services.schema, SocialAccounts.schema, TagMaps.schema, Tags.schema, Transfers.schema, Users.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /**
   * Entity class storing rows of table AdditionalEmails
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param email Database column email SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class AdditionalEmailsRow(id: Int, userId: Int, email: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching AdditionalEmailsRow objects using plain SQL queries */
  implicit def GetResultAdditionalEmailsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[java.sql.Timestamp], e3: GR[Option[java.sql.Timestamp]]): GR[AdditionalEmailsRow] = GR {
    prs ⇒
      import prs._
      AdditionalEmailsRow.tupled((<<[Int], <<[Int], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table additional_emails. Objects of this class serve as prototypes for rows in queries. */
  class AdditionalEmails(_tableTag: Tag) extends profile.api.Table[AdditionalEmailsRow](_tableTag, "additional_emails") {
    def * = (id, userId, email, createdAt, updatedAt, deletedAt) <> (AdditionalEmailsRow.tupled, AdditionalEmailsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), email, Rep.Some(createdAt), Rep.Some(updatedAt), deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ AdditionalEmailsRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column email SqlType(varchar), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table AdditionalEmails */
  lazy val AdditionalEmails = new TableQuery(tag ⇒ new AdditionalEmails(tag))

  /**
   * Entity class storing rows of table Addresses
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param addressLine1 Database column address_line_1 SqlType(varchar), Default(None)
   *  @param addressLine2 Database column address_line_2 SqlType(varchar), Default(None)
   *  @param city Database column city SqlType(varchar), Default(None)
   *  @param state Database column state SqlType(varchar), Default(None)
   *  @param zipcode Database column zipcode SqlType(varchar), Default(None)
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class AddressesRow(id: Int, addressLine1: Option[String] = None, addressLine2: Option[String] = None, city: Option[String] = None, state: Option[String] = None, zipcode: Option[String] = None, userId: Option[Int] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching AddressesRow objects using plain SQL queries */
  implicit def GetResultAddressesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp], e4: GR[Option[java.sql.Timestamp]]): GR[AddressesRow] = GR {
    prs ⇒
      import prs._
      AddressesRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table addresses. Objects of this class serve as prototypes for rows in queries. */
  class Addresses(_tableTag: Tag) extends profile.api.Table[AddressesRow](_tableTag, "addresses") {
    def * = (id, addressLine1, addressLine2, city, state, zipcode, userId, createdAt, updatedAt, deletedAt) <> (AddressesRow.tupled, AddressesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), addressLine1, addressLine2, city, state, zipcode, userId, Rep.Some(createdAt), Rep.Some(updatedAt), deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ AddressesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8.get, _9.get, _10))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column address_line_1 SqlType(varchar), Default(None) */
    val addressLine1: Rep[Option[String]] = column[Option[String]]("address_line_1", O.Default(None))
    /** Database column address_line_2 SqlType(varchar), Default(None) */
    val addressLine2: Rep[Option[String]] = column[Option[String]]("address_line_2", O.Default(None))
    /** Database column city SqlType(varchar), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Default(None))
    /** Database column state SqlType(varchar), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Default(None))
    /** Database column zipcode SqlType(varchar), Default(None) */
    val zipcode: Rep[Option[String]] = column[Option[String]]("zipcode", O.Default(None))
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table Addresses */
  lazy val Addresses = new TableQuery(tag ⇒ new Addresses(tag))

  /**
   * Entity class storing rows of table Admins
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param email Database column email SqlType(varchar), Default()
   *  @param encryptedPassword Database column encrypted_password SqlType(varchar), Default()
   *  @param resetPasswordToken Database column reset_password_token SqlType(varchar), Default(None)
   *  @param resetPasswordSentAt Database column reset_password_sent_at SqlType(timestamp), Default(None)
   *  @param rememberCreatedAt Database column remember_created_at SqlType(timestamp), Default(None)
   *  @param signInCount Database column sign_in_count SqlType(int4), Default(0)
   *  @param currentSignInAt Database column current_sign_in_at SqlType(timestamp), Default(None)
   *  @param lastSignInAt Database column last_sign_in_at SqlType(timestamp), Default(None)
   *  @param currentSignInIp Database column current_sign_in_ip SqlType(inet), Length(2147483647,false), Default(None)
   *  @param lastSignInIp Database column last_sign_in_ip SqlType(inet), Length(2147483647,false), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   */
  final case class AdminsRow(id: Int, email: String = "", encryptedPassword: String = "", resetPasswordToken: Option[String] = None, resetPasswordSentAt: Option[java.sql.Timestamp] = None, rememberCreatedAt: Option[java.sql.Timestamp] = None, signInCount: Int = 0, currentSignInAt: Option[java.sql.Timestamp] = None, lastSignInAt: Option[java.sql.Timestamp] = None, currentSignInIp: Option[String] = None, lastSignInIp: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
  /** GetResult implicit for fetching AdminsRow objects using plain SQL queries */
  implicit def GetResultAdminsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]], e4: GR[java.sql.Timestamp]): GR[AdminsRow] = GR {
    prs ⇒
      import prs._
      AdminsRow.tupled((<<[Int], <<[String], <<[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table admins. Objects of this class serve as prototypes for rows in queries. */
  class Admins(_tableTag: Tag) extends profile.api.Table[AdminsRow](_tableTag, "admins") {
    def * = (id, email, encryptedPassword, resetPasswordToken, resetPasswordSentAt, rememberCreatedAt, signInCount, currentSignInAt, lastSignInAt, currentSignInIp, lastSignInIp, createdAt, updatedAt) <> (AdminsRow.tupled, AdminsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(email), Rep.Some(encryptedPassword), resetPasswordToken, resetPasswordSentAt, rememberCreatedAt, Rep.Some(signInCount), currentSignInAt, lastSignInAt, currentSignInIp, lastSignInIp, Rep.Some(createdAt), Rep.Some(updatedAt)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ AdminsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7.get, _8, _9, _10, _11, _12.get, _13.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email SqlType(varchar), Default() */
    val email: Rep[String] = column[String]("email", O.Default(""))
    /** Database column encrypted_password SqlType(varchar), Default() */
    val encryptedPassword: Rep[String] = column[String]("encrypted_password", O.Default(""))
    /** Database column reset_password_token SqlType(varchar), Default(None) */
    val resetPasswordToken: Rep[Option[String]] = column[Option[String]]("reset_password_token", O.Default(None))
    /** Database column reset_password_sent_at SqlType(timestamp), Default(None) */
    val resetPasswordSentAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("reset_password_sent_at", O.Default(None))
    /** Database column remember_created_at SqlType(timestamp), Default(None) */
    val rememberCreatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("remember_created_at", O.Default(None))
    /** Database column sign_in_count SqlType(int4), Default(0) */
    val signInCount: Rep[Int] = column[Int]("sign_in_count", O.Default(0))
    /** Database column current_sign_in_at SqlType(timestamp), Default(None) */
    val currentSignInAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("current_sign_in_at", O.Default(None))
    /** Database column last_sign_in_at SqlType(timestamp), Default(None) */
    val lastSignInAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_sign_in_at", O.Default(None))
    /** Database column current_sign_in_ip SqlType(inet), Length(2147483647,false), Default(None) */
    val currentSignInIp: Rep[Option[String]] = column[Option[String]]("current_sign_in_ip", O.Length(2147483647, varying = false), O.Default(None))
    /** Database column last_sign_in_ip SqlType(inet), Length(2147483647,false), Default(None) */
    val lastSignInIp: Rep[Option[String]] = column[Option[String]]("last_sign_in_ip", O.Length(2147483647, varying = false), O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")

    /** Uniqueness Index over (email) (database name index_admins_on_email) */
    val index1 = index("index_admins_on_email", email, unique = true)
    /** Uniqueness Index over (resetPasswordToken) (database name index_admins_on_reset_password_token) */
    val index2 = index("index_admins_on_reset_password_token", resetPasswordToken, unique = true)
  }
  /** Collection-like TableQuery object for table Admins */
  lazy val Admins = new TableQuery(tag ⇒ new Admins(tag))

  /**
   * Entity class storing rows of table Availabilities
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param day Database column day SqlType(int4)
   *  @param time Database column time SqlType(time)
   *  @param available Database column available SqlType(bool), Default(false)
   */
  final case class AvailabilitiesRow(id: Int, userId: Int, day: Int, time: java.sql.Time, available: Boolean = false)
  /** GetResult implicit for fetching AvailabilitiesRow objects using plain SQL queries */
  implicit def GetResultAvailabilitiesRow(implicit e0: GR[Int], e1: GR[java.sql.Time], e2: GR[Boolean]): GR[AvailabilitiesRow] = GR {
    prs ⇒
      import prs._
      AvailabilitiesRow.tupled((<<[Int], <<[Int], <<[Int], <<[java.sql.Time], <<[Boolean]))
  }
  /** Table description of table availabilities. Objects of this class serve as prototypes for rows in queries. */
  class Availabilities(_tableTag: Tag) extends profile.api.Table[AvailabilitiesRow](_tableTag, "availabilities") {
    def * = (id, userId, day, time, available) <> (AvailabilitiesRow.tupled, AvailabilitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), Rep.Some(day), Rep.Some(time), Rep.Some(available)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ AvailabilitiesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column day SqlType(int4) */
    val day: Rep[Int] = column[Int]("day")
    /** Database column time SqlType(time) */
    val time: Rep[java.sql.Time] = column[java.sql.Time]("time")
    /** Database column available SqlType(bool), Default(false) */
    val available: Rep[Boolean] = column[Boolean]("available", O.Default(false))

    /** Index over (day) (database name index_availabilities_on_day) */
    val index1 = index("index_availabilities_on_day", day)
    /** Index over (userId) (database name index_availabilities_on_user_id) */
    val index2 = index("index_availabilities_on_user_id", userId)
  }
  /** Collection-like TableQuery object for table Availabilities */
  lazy val Availabilities = new TableQuery(tag ⇒ new Availabilities(tag))

  /**
   * Entity class storing rows of table BankAccounts
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param managedAccountId Database column managed_account_id SqlType(int4), Default(None)
   *  @param stripeBankAccountId Database column stripe_bank_account_id SqlType(varchar), Default(None)
   *  @param bankName Database column bank_name SqlType(varchar), Default(None)
   *  @param last4 Database column last4 SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   *  @param accountHolderName Database column account_holder_name SqlType(varchar), Default(None)
   *  @param accountHolderType Database column account_holder_type SqlType(int4), Default(None)
   *  @param idNumber Database column id_number SqlType(varchar), Default(None)
   *  @param stripeStatus Database column stripe_status SqlType(varchar), Default(None)
   *  @param stripeStatusNote Database column stripe_status_note SqlType(varchar), Default(None)
   *  @param addressId Database column address_id SqlType(int4), Default(None)
   */
  final case class BankAccountsRow(id: Int, managedAccountId: Option[Int] = None, stripeBankAccountId: Option[String] = None, bankName: Option[String] = None, last4: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, deletedAt: Option[java.sql.Timestamp] = None, accountHolderName: Option[String] = None, accountHolderType: Option[Int] = None, idNumber: Option[String] = None, stripeStatus: Option[String] = None, stripeStatusNote: Option[String] = None, addressId: Option[Int] = None)
  /** GetResult implicit for fetching BankAccountsRow objects using plain SQL queries */
  implicit def GetResultBankAccountsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]]): GR[BankAccountsRow] = GR {
    prs ⇒
      import prs._
      BankAccountsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table bank_accounts. Objects of this class serve as prototypes for rows in queries. */
  class BankAccounts(_tableTag: Tag) extends profile.api.Table[BankAccountsRow](_tableTag, "bank_accounts") {
    def * = (id, managedAccountId, stripeBankAccountId, bankName, last4, createdAt, updatedAt, deletedAt, accountHolderName, accountHolderType, idNumber, stripeStatus, stripeStatusNote, addressId) <> (BankAccountsRow.tupled, BankAccountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), managedAccountId, stripeBankAccountId, bankName, last4, createdAt, updatedAt, deletedAt, accountHolderName, accountHolderType, idNumber, stripeStatus, stripeStatusNote, addressId).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ BankAccountsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column managed_account_id SqlType(int4), Default(None) */
    val managedAccountId: Rep[Option[Int]] = column[Option[Int]]("managed_account_id", O.Default(None))
    /** Database column stripe_bank_account_id SqlType(varchar), Default(None) */
    val stripeBankAccountId: Rep[Option[String]] = column[Option[String]]("stripe_bank_account_id", O.Default(None))
    /** Database column bank_name SqlType(varchar), Default(None) */
    val bankName: Rep[Option[String]] = column[Option[String]]("bank_name", O.Default(None))
    /** Database column last4 SqlType(varchar), Default(None) */
    val last4: Rep[Option[String]] = column[Option[String]]("last4", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column account_holder_name SqlType(varchar), Default(None) */
    val accountHolderName: Rep[Option[String]] = column[Option[String]]("account_holder_name", O.Default(None))
    /** Database column account_holder_type SqlType(int4), Default(None) */
    val accountHolderType: Rep[Option[Int]] = column[Option[Int]]("account_holder_type", O.Default(None))
    /** Database column id_number SqlType(varchar), Default(None) */
    val idNumber: Rep[Option[String]] = column[Option[String]]("id_number", O.Default(None))
    /** Database column stripe_status SqlType(varchar), Default(None) */
    val stripeStatus: Rep[Option[String]] = column[Option[String]]("stripe_status", O.Default(None))
    /** Database column stripe_status_note SqlType(varchar), Default(None) */
    val stripeStatusNote: Rep[Option[String]] = column[Option[String]]("stripe_status_note", O.Default(None))
    /** Database column address_id SqlType(int4), Default(None) */
    val addressId: Rep[Option[Int]] = column[Option[Int]]("address_id", O.Default(None))

    /** Foreign key referencing Addresses (database name fk_rails_5d696dd229) */
    lazy val addressesFk = foreignKey("fk_rails_5d696dd229", addressId, Addresses)(r ⇒ Rep.Some(r.id), onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BankAccounts */
  lazy val BankAccounts = new TableQuery(tag ⇒ new BankAccounts(tag))

  /**
   * Entity class storing rows of table BookingInstances
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param patronId Database column patron_id SqlType(int4), Default(None)
   *  @param creativeId Database column creative_id SqlType(int4), Default(None)
   *  @param serviceId Database column service_id SqlType(int4), Default(None)
   *  @param serviceCharge Database column service_charge SqlType(int4)
   *  @param serviceOptionsCharge Database column service_options_charge SqlType(int4)
   *  @param location Database column location SqlType(varchar), Default(None)
   *  @param chargedAt Database column charged_at SqlType(timestamp), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   *  @param message Database column message SqlType(text), Default(None)
   *  @param status Database column status SqlType(int4), Default(None)
   *  @param addressLine1 Database column address_line_1 SqlType(varchar), Default(None)
   *  @param addressLine2 Database column address_line_2 SqlType(varchar), Default(None)
   *  @param city Database column city SqlType(varchar), Default(None)
   *  @param state Database column state SqlType(varchar), Default(None)
   *  @param zipcode Database column zipcode SqlType(varchar), Default(None)
   *  @param confirmationNumber Database column confirmation_number SqlType(varchar), Default(None)
   *  @param bookingDate Database column booking_date SqlType(timestamp), Default(None)
   *  @param bookingDuration Database column booking_duration SqlType(int4), Default(None)
   */
  final case class BookingInstancesRow(id: Int, patronId: Option[Int] = None, creativeId: Option[Int] = None, serviceId: Option[Int] = None, serviceCharge: Option[Int], serviceOptionsCharge: Option[Int], location: Option[String] = None, chargedAt: Option[java.sql.Timestamp] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, deletedAt: Option[java.sql.Timestamp] = None, message: Option[String] = None, status: Option[Int] = None, addressLine1: Option[String] = None, addressLine2: Option[String] = None, city: Option[String] = None, state: Option[String] = None, zipcode: Option[String] = None, confirmationNumber: Option[String] = None, bookingDate: Option[java.sql.Timestamp] = None, bookingDuration: Option[Int] = None)
  /** GetResult implicit for fetching BookingInstancesRow objects using plain SQL queries */
  implicit def GetResultBookingInstancesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]], e4: GR[java.sql.Timestamp]): GR[BookingInstancesRow] = GR {
    prs ⇒
      import prs._
      BookingInstancesRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[java.sql.Timestamp], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[Int]))
  }
  /** Table description of table booking_instances. Objects of this class serve as prototypes for rows in queries. */
  class BookingInstances(_tableTag: Tag) extends profile.api.Table[BookingInstancesRow](_tableTag, "booking_instances") {
    def * = (id, patronId, creativeId, serviceId, serviceCharge, serviceOptionsCharge, location, chargedAt, createdAt, updatedAt, deletedAt, message, status, addressLine1, addressLine2, city, state, zipcode, confirmationNumber, bookingDate, bookingDuration) <> (BookingInstancesRow.tupled, BookingInstancesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), patronId, creativeId, serviceId, serviceCharge, serviceOptionsCharge, location, chargedAt, Rep.Some(createdAt), Rep.Some(updatedAt), deletedAt, message, status, addressLine1, addressLine2, city, state, zipcode, confirmationNumber, bookingDate, bookingDuration).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ BookingInstancesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9.get, _10.get, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column patron_id SqlType(int4), Default(None) */
    val patronId: Rep[Option[Int]] = column[Option[Int]]("patron_id", O.Default(None))
    /** Database column creative_id SqlType(int4), Default(None) */
    val creativeId: Rep[Option[Int]] = column[Option[Int]]("creative_id", O.Default(None))
    /** Database column service_id SqlType(int4), Default(None) */
    val serviceId: Rep[Option[Int]] = column[Option[Int]]("service_id", O.Default(None))
    /** Database column service_charge SqlType(int4) */
    val serviceCharge: Rep[Option[Int]] = column[Option[Int]]("service_charge")
    /** Database column service_options_charge SqlType(int4) */
    val serviceOptionsCharge: Rep[Option[Int]] = column[Option[Int]]("service_options_charge")
    /** Database column location SqlType(varchar), Default(None) */
    val location: Rep[Option[String]] = column[Option[String]]("location", O.Default(None))
    /** Database column charged_at SqlType(timestamp), Default(None) */
    val chargedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("charged_at", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column message SqlType(text), Default(None) */
    val message: Rep[Option[String]] = column[Option[String]]("message", O.Default(None))
    /** Database column status SqlType(int4), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("status", O.Default(None))
    /** Database column address_line_1 SqlType(varchar), Default(None) */
    val addressLine1: Rep[Option[String]] = column[Option[String]]("address_line_1", O.Default(None))
    /** Database column address_line_2 SqlType(varchar), Default(None) */
    val addressLine2: Rep[Option[String]] = column[Option[String]]("address_line_2", O.Default(None))
    /** Database column city SqlType(varchar), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Default(None))
    /** Database column state SqlType(varchar), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Default(None))
    /** Database column zipcode SqlType(varchar), Default(None) */
    val zipcode: Rep[Option[String]] = column[Option[String]]("zipcode", O.Default(None))
    /** Database column confirmation_number SqlType(varchar), Default(None) */
    val confirmationNumber: Rep[Option[String]] = column[Option[String]]("confirmation_number", O.Default(None))
    /** Database column booking_date SqlType(timestamp), Default(None) */
    val bookingDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("booking_date", O.Default(None))
    /** Database column booking_duration SqlType(int4), Default(None) */
    val bookingDuration: Rep[Option[Int]] = column[Option[Int]]("booking_duration", O.Default(None))
  }
  /** Collection-like TableQuery object for table BookingInstances */
  lazy val BookingInstances = new TableQuery(tag ⇒ new BookingInstances(tag))

  /**
   * Entity class storing rows of table BookingOptions
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param bookingId Database column booking_id SqlType(int4), Default(None)
   *  @param serviceOptionId Database column service_option_id SqlType(int4), Default(None)
   */
  final case class BookingOptionsRow(id: Int, bookingId: Option[Int] = None, serviceOptionId: Option[Int] = None)
  /** GetResult implicit for fetching BookingOptionsRow objects using plain SQL queries */
  implicit def GetResultBookingOptionsRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[BookingOptionsRow] = GR {
    prs ⇒
      import prs._
      BookingOptionsRow.tupled((<<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table booking_options. Objects of this class serve as prototypes for rows in queries. */
  class BookingOptions(_tableTag: Tag) extends profile.api.Table[BookingOptionsRow](_tableTag, "booking_options") {
    def * = (id, bookingId, serviceOptionId) <> (BookingOptionsRow.tupled, BookingOptionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), bookingId, serviceOptionId).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ BookingOptionsRow.tupled((_1.get, _2, _3))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column booking_id SqlType(int4), Default(None) */
    val bookingId: Rep[Option[Int]] = column[Option[Int]]("booking_id", O.Default(None))
    /** Database column service_option_id SqlType(int4), Default(None) */
    val serviceOptionId: Rep[Option[Int]] = column[Option[Int]]("service_option_id", O.Default(None))

    /** Uniqueness Index over (bookingId,serviceOptionId) (database name index_booking_options_on_booking_id_and_service_option_id) */
    val index1 = index("index_booking_options_on_booking_id_and_service_option_id", (bookingId, serviceOptionId), unique = true)
  }
  /** Collection-like TableQuery object for table BookingOptions */
  lazy val BookingOptions = new TableQuery(tag ⇒ new BookingOptions(tag))

  /**
   * Entity class storing rows of table CancellationPolicies
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param time Database column time SqlType(int4), Default(None)
   *  @param timeUnit Database column time_unit SqlType(int4), Default(None)
   *  @param fee Database column fee SqlType(int4), Default(None)
   *  @param feeUnit Database column fee_unit SqlType(int4), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class CancellationPoliciesRow(id: Int, userId: Option[Int] = None, time: Option[Int] = None, timeUnit: Option[Int] = None, fee: Option[Int] = None, feeUnit: Option[Int] = None, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CancellationPoliciesRow objects using plain SQL queries */
  implicit def GetResultCancellationPoliciesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[CancellationPoliciesRow] = GR {
    prs ⇒
      import prs._
      CancellationPoliciesRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table cancellation_policies. Objects of this class serve as prototypes for rows in queries. */
  class CancellationPolicies(_tableTag: Tag) extends profile.api.Table[CancellationPoliciesRow](_tableTag, "cancellation_policies") {
    def * = (id, userId, time, timeUnit, fee, feeUnit, deletedAt) <> (CancellationPoliciesRow.tupled, CancellationPoliciesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), userId, time, timeUnit, fee, feeUnit, deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CancellationPoliciesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column time SqlType(int4), Default(None) */
    val time: Rep[Option[Int]] = column[Option[Int]]("time", O.Default(None))
    /** Database column time_unit SqlType(int4), Default(None) */
    val timeUnit: Rep[Option[Int]] = column[Option[Int]]("time_unit", O.Default(None))
    /** Database column fee SqlType(int4), Default(None) */
    val fee: Rep[Option[Int]] = column[Option[Int]]("fee", O.Default(None))
    /** Database column fee_unit SqlType(int4), Default(None) */
    val feeUnit: Rep[Option[Int]] = column[Option[Int]]("fee_unit", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))

    /** Index over (userId) (database name index_cancellation_policies_on_user_id) */
    val index1 = index("index_cancellation_policies_on_user_id", userId)
  }
  /** Collection-like TableQuery object for table CancellationPolicies */
  lazy val CancellationPolicies = new TableQuery(tag ⇒ new CancellationPolicies(tag))

  /**
   * Entity class storing rows of table CollectionItems
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param collectionId Database column collection_id SqlType(int4), Default(None)
   *  @param itemType Database column item_type SqlType(varchar), Default(None)
   *  @param itemId Database column item_id SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class CollectionItemsRow(id: Int, collectionId: Option[Int] = None, itemType: Option[String] = None, itemId: Option[Int] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CollectionItemsRow objects using plain SQL queries */
  implicit def GetResultCollectionItemsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]]): GR[CollectionItemsRow] = GR {
    prs ⇒
      import prs._
      CollectionItemsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table collection_items. Objects of this class serve as prototypes for rows in queries. */
  class CollectionItems(_tableTag: Tag) extends profile.api.Table[CollectionItemsRow](_tableTag, "collection_items") {
    def * = (id, collectionId, itemType, itemId, createdAt, updatedAt, deletedAt) <> (CollectionItemsRow.tupled, CollectionItemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), collectionId, itemType, itemId, createdAt, updatedAt, deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CollectionItemsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column collection_id SqlType(int4), Default(None) */
    val collectionId: Rep[Option[Int]] = column[Option[Int]]("collection_id", O.Default(None))
    /** Database column item_type SqlType(varchar), Default(None) */
    val itemType: Rep[Option[String]] = column[Option[String]]("item_type", O.Default(None))
    /** Database column item_id SqlType(int4), Default(None) */
    val itemId: Rep[Option[Int]] = column[Option[Int]]("item_id", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table CollectionItems */
  lazy val CollectionItems = new TableQuery(tag ⇒ new CollectionItems(tag))

  /**
   * Entity class storing rows of table Collections
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param description Database column description SqlType(varchar), Default(None)
   *  @param backgroundImageUrl Database column background_image_url SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   *  @param explore Database column explore SqlType(bool), Default(None)
   */
  final case class CollectionsRow(id: Int, name: Option[String] = None, description: Option[String] = None, backgroundImageUrl: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, deletedAt: Option[java.sql.Timestamp] = None, explore: Option[Boolean] = None)
  /** GetResult implicit for fetching CollectionsRow objects using plain SQL queries */
  implicit def GetResultCollectionsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]], e3: GR[Option[Boolean]]): GR[CollectionsRow] = GR {
    prs ⇒
      import prs._
      CollectionsRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[Boolean]))
  }
  /** Table description of table collections. Objects of this class serve as prototypes for rows in queries. */
  class Collections(_tableTag: Tag) extends profile.api.Table[CollectionsRow](_tableTag, "collections") {
    def * = (id, name, description, backgroundImageUrl, createdAt, updatedAt, deletedAt, explore) <> (CollectionsRow.tupled, CollectionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, description, backgroundImageUrl, createdAt, updatedAt, deletedAt, explore).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CollectionsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column description SqlType(varchar), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column background_image_url SqlType(varchar), Default(None) */
    val backgroundImageUrl: Rep[Option[String]] = column[Option[String]]("background_image_url", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column explore SqlType(bool), Default(None) */
    val explore: Rep[Option[Boolean]] = column[Option[Boolean]]("explore", O.Default(None))
  }
  /** Collection-like TableQuery object for table Collections */
  lazy val Collections = new TableQuery(tag ⇒ new Collections(tag))

  /**
   * Entity class storing rows of table Conversations
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   */
  final case class ConversationsRow(id: Int, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching ConversationsRow objects using plain SQL queries */
  implicit def GetResultConversationsRow(implicit e0: GR[Int], e1: GR[Option[java.sql.Timestamp]]): GR[ConversationsRow] = GR {
    prs ⇒
      import prs._
      ConversationsRow.tupled((<<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table conversations. Objects of this class serve as prototypes for rows in queries. */
  class Conversations(_tableTag: Tag) extends profile.api.Table[ConversationsRow](_tableTag, "conversations") {
    def * = (id, createdAt, updatedAt) <> (ConversationsRow.tupled, ConversationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), createdAt, updatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ ConversationsRow.tupled((_1.get, _2, _3))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table Conversations */
  lazy val Conversations = new TableQuery(tag ⇒ new Conversations(tag))

  /**
   * Entity class storing rows of table ConversationUsers
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param unreadCount Database column unread_count SqlType(int4), Default(Some(0))
   *  @param conversationId Database column conversation_id SqlType(int4)
   *  @param userId Database column user_id SqlType(int4)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   */
  final case class ConversationUsersRow(id: Int, unreadCount: Option[Int] = Some(0), conversationId: Int, userId: Int, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching ConversationUsersRow objects using plain SQL queries */
  implicit def GetResultConversationUsersRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[ConversationUsersRow] = GR {
    prs ⇒
      import prs._
      ConversationUsersRow.tupled((<<[Int], <<?[Int], <<[Int], <<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table conversation_users. Objects of this class serve as prototypes for rows in queries. */
  class ConversationUsers(_tableTag: Tag) extends profile.api.Table[ConversationUsersRow](_tableTag, "conversation_users") {
    def * = (id, unreadCount, conversationId, userId, createdAt, updatedAt) <> (ConversationUsersRow.tupled, ConversationUsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), unreadCount, Rep.Some(conversationId), Rep.Some(userId), createdAt, updatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ ConversationUsersRow.tupled((_1.get, _2, _3.get, _4.get, _5, _6))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column unread_count SqlType(int4), Default(Some(0)) */
    val unreadCount: Rep[Option[Int]] = column[Option[Int]]("unread_count", O.Default(Some(0)))
    /** Database column conversation_id SqlType(int4) */
    val conversationId: Rep[Int] = column[Int]("conversation_id")
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))

    /** Index over (conversationId) (database name index_conversation_users_on_conversation_id) */
    val index1 = index("index_conversation_users_on_conversation_id", conversationId)
    /** Index over (userId) (database name index_conversation_users_on_user_id) */
    val index2 = index("index_conversation_users_on_user_id", userId)
  }
  /** Collection-like TableQuery object for table ConversationUsers */
  lazy val ConversationUsers = new TableQuery(tag ⇒ new ConversationUsers(tag))

  /**
   * Entity class storing rows of table CoverMedia
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param mediaId Database column media_id SqlType(int4), Default(None)
   *  @param textOverImageFileName Database column text_over_image_file_name SqlType(varchar), Default(None)
   *  @param textOverImageContentType Database column text_over_image_content_type SqlType(varchar), Default(None)
   *  @param textOverImageFileSize Database column text_over_image_file_size SqlType(int4), Default(None)
   *  @param textOverImageUpdatedAt Database column text_over_image_updated_at SqlType(timestamp), Default(None)
   */
  final case class CoverMediaRow(id: Int, userId: Int, mediaId: Option[Int] = None, textOverImageFileName: Option[String] = None, textOverImageContentType: Option[String] = None, textOverImageFileSize: Option[Int] = None, textOverImageUpdatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CoverMediaRow objects using plain SQL queries */
  implicit def GetResultCoverMediaRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]]): GR[CoverMediaRow] = GR {
    prs ⇒
      import prs._
      CoverMediaRow.tupled((<<[Int], <<[Int], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table cover_media. Objects of this class serve as prototypes for rows in queries. */
  class CoverMedia(_tableTag: Tag) extends profile.api.Table[CoverMediaRow](_tableTag, "cover_media") {
    def * = (id, userId, mediaId, textOverImageFileName, textOverImageContentType, textOverImageFileSize, textOverImageUpdatedAt) <> (CoverMediaRow.tupled, CoverMediaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), mediaId, textOverImageFileName, textOverImageContentType, textOverImageFileSize, textOverImageUpdatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CoverMediaRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column media_id SqlType(int4), Default(None) */
    val mediaId: Rep[Option[Int]] = column[Option[Int]]("media_id", O.Default(None))
    /** Database column text_over_image_file_name SqlType(varchar), Default(None) */
    val textOverImageFileName: Rep[Option[String]] = column[Option[String]]("text_over_image_file_name", O.Default(None))
    /** Database column text_over_image_content_type SqlType(varchar), Default(None) */
    val textOverImageContentType: Rep[Option[String]] = column[Option[String]]("text_over_image_content_type", O.Default(None))
    /** Database column text_over_image_file_size SqlType(int4), Default(None) */
    val textOverImageFileSize: Rep[Option[Int]] = column[Option[Int]]("text_over_image_file_size", O.Default(None))
    /** Database column text_over_image_updated_at SqlType(timestamp), Default(None) */
    val textOverImageUpdatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("text_over_image_updated_at", O.Default(None))

    /** Index over (mediaId) (database name index_cover_media_on_media_id) */
    val index1 = index("index_cover_media_on_media_id", mediaId)
    /** Index over (userId) (database name index_cover_media_on_user_id) */
    val index2 = index("index_cover_media_on_user_id", userId)
  }
  /** Collection-like TableQuery object for table CoverMedia */
  lazy val CoverMedia = new TableQuery(tag ⇒ new CoverMedia(tag))

  /**
   * Entity class storing rows of table CreativeTypeMaps
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param creativeTypeId Database column creative_type_id SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   */
  final case class CreativeTypeMapsRow(id: Int, userId: Option[Int] = None, creativeTypeId: Option[Int] = None, createdAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CreativeTypeMapsRow objects using plain SQL queries */
  implicit def GetResultCreativeTypeMapsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[CreativeTypeMapsRow] = GR {
    prs ⇒
      import prs._
      CreativeTypeMapsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table creative_type_maps. Objects of this class serve as prototypes for rows in queries. */
  class CreativeTypeMaps(_tableTag: Tag) extends profile.api.Table[CreativeTypeMapsRow](_tableTag, "creative_type_maps") {
    def * = (id, userId, creativeTypeId, createdAt) <> (CreativeTypeMapsRow.tupled, CreativeTypeMapsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), userId, creativeTypeId, createdAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CreativeTypeMapsRow.tupled((_1.get, _2, _3, _4))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column creative_type_id SqlType(int4), Default(None) */
    val creativeTypeId: Rep[Option[Int]] = column[Option[Int]]("creative_type_id", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))

    /** Foreign key referencing CreativeTypes (database name fk_rails_8026284fa1) */
    lazy val creativeTypesFk = foreignKey("fk_rails_8026284fa1", creativeTypeId, CreativeTypes)(r ⇒ Rep.Some(r.id), onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

    /** Uniqueness Index over (userId,creativeTypeId) (database name index_creative_type_maps_on_user_id_and_creative_type_id) */
    val index1 = index("index_creative_type_maps_on_user_id_and_creative_type_id", (userId, creativeTypeId), unique = true)
  }
  /** Collection-like TableQuery object for table CreativeTypeMaps */
  lazy val CreativeTypeMaps = new TableQuery(tag ⇒ new CreativeTypeMaps(tag))

  /**
   * Entity class storing rows of table CreativeTypes
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Default(None)
   */
  final case class CreativeTypesRow(id: Int, name: Option[String] = None)
  /** GetResult implicit for fetching CreativeTypesRow objects using plain SQL queries */
  implicit def GetResultCreativeTypesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[CreativeTypesRow] = GR {
    prs ⇒
      import prs._
      CreativeTypesRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table creative_types. Objects of this class serve as prototypes for rows in queries. */
  class CreativeTypes(_tableTag: Tag) extends profile.api.Table[CreativeTypesRow](_tableTag, "creative_types") {
    def * = (id, name) <> (CreativeTypesRow.tupled, CreativeTypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CreativeTypesRow.tupled((_1.get, _2))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
  }
  /** Collection-like TableQuery object for table CreativeTypes */
  lazy val CreativeTypes = new TableQuery(tag ⇒ new CreativeTypes(tag))

  /**
   * Entity class storing rows of table CreditCards
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param stripeId Database column stripe_id SqlType(varchar), Default(None)
   *  @param stripeCustomerId Database column stripe_customer_id SqlType(varchar), Default(None)
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param last4 Database column last4 SqlType(varchar), Default(None)
   *  @param expMonth Database column exp_month SqlType(int4), Default(None)
   *  @param expYear Database column exp_year SqlType(int4), Default(None)
   *  @param brand Database column brand SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class CreditCardsRow(id: Int, stripeId: Option[String] = None, stripeCustomerId: Option[String] = None, userId: Option[Int] = None, last4: Option[String] = None, expMonth: Option[Int] = None, expYear: Option[Int] = None, brand: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching CreditCardsRow objects using plain SQL queries */
  implicit def GetResultCreditCardsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]]): GR[CreditCardsRow] = GR {
    prs ⇒
      import prs._
      CreditCardsRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table credit_cards. Objects of this class serve as prototypes for rows in queries. */
  class CreditCards(_tableTag: Tag) extends profile.api.Table[CreditCardsRow](_tableTag, "credit_cards") {
    def * = (id, stripeId, stripeCustomerId, userId, last4, expMonth, expYear, brand, createdAt, updatedAt, deletedAt) <> (CreditCardsRow.tupled, CreditCardsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), stripeId, stripeCustomerId, userId, last4, expMonth, expYear, brand, createdAt, updatedAt, deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ CreditCardsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column stripe_id SqlType(varchar), Default(None) */
    val stripeId: Rep[Option[String]] = column[Option[String]]("stripe_id", O.Default(None))
    /** Database column stripe_customer_id SqlType(varchar), Default(None) */
    val stripeCustomerId: Rep[Option[String]] = column[Option[String]]("stripe_customer_id", O.Default(None))
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column last4 SqlType(varchar), Default(None) */
    val last4: Rep[Option[String]] = column[Option[String]]("last4", O.Default(None))
    /** Database column exp_month SqlType(int4), Default(None) */
    val expMonth: Rep[Option[Int]] = column[Option[Int]]("exp_month", O.Default(None))
    /** Database column exp_year SqlType(int4), Default(None) */
    val expYear: Rep[Option[Int]] = column[Option[Int]]("exp_year", O.Default(None))
    /** Database column brand SqlType(varchar), Default(None) */
    val brand: Rep[Option[String]] = column[Option[String]]("brand", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table CreditCards */
  lazy val CreditCards = new TableQuery(tag ⇒ new CreditCards(tag))

  /**
   * Entity class storing rows of table FeaturedCreatives
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(varchar), Default(None)
   *  @param imageurl Database column imageUrl SqlType(varchar), Default(None)
   *  @param videourl Database column videoUrl SqlType(varchar), Default(None)
   *  @param darktext Database column darkText SqlType(bool), Default(None)
   *  @param orderposition Database column orderPosition SqlType(int4), Default(None)
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param featured Database column featured SqlType(bool), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   */
  final case class FeaturedCreativesRow(id: Int, username: Option[String] = None, imageurl: Option[String] = None, videourl: Option[String] = None, darktext: Option[Boolean] = None, orderposition: Option[Int] = None, name: Option[String] = None, featured: Option[Boolean] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
  /** GetResult implicit for fetching FeaturedCreativesRow objects using plain SQL queries */
  implicit def GetResultFeaturedCreativesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Boolean]], e3: GR[Option[Int]], e4: GR[java.sql.Timestamp]): GR[FeaturedCreativesRow] = GR {
    prs ⇒
      import prs._
      FeaturedCreativesRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[Boolean], <<?[Int], <<?[String], <<?[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table featured_creatives. Objects of this class serve as prototypes for rows in queries. */
  class FeaturedCreatives(_tableTag: Tag) extends profile.api.Table[FeaturedCreativesRow](_tableTag, "featured_creatives") {
    def * = (id, username, imageurl, videourl, darktext, orderposition, name, featured, createdAt, updatedAt) <> (FeaturedCreativesRow.tupled, FeaturedCreativesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), username, imageurl, videourl, darktext, orderposition, name, featured, Rep.Some(createdAt), Rep.Some(updatedAt)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ FeaturedCreativesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9.get, _10.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(varchar), Default(None) */
    val username: Rep[Option[String]] = column[Option[String]]("username", O.Default(None))
    /** Database column imageUrl SqlType(varchar), Default(None) */
    val imageurl: Rep[Option[String]] = column[Option[String]]("imageUrl", O.Default(None))
    /** Database column videoUrl SqlType(varchar), Default(None) */
    val videourl: Rep[Option[String]] = column[Option[String]]("videoUrl", O.Default(None))
    /** Database column darkText SqlType(bool), Default(None) */
    val darktext: Rep[Option[Boolean]] = column[Option[Boolean]]("darkText", O.Default(None))
    /** Database column orderPosition SqlType(int4), Default(None) */
    val orderposition: Rep[Option[Int]] = column[Option[Int]]("orderPosition", O.Default(None))
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column featured SqlType(bool), Default(None) */
    val featured: Rep[Option[Boolean]] = column[Option[Boolean]]("featured", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
  }
  /** Collection-like TableQuery object for table FeaturedCreatives */
  lazy val FeaturedCreatives = new TableQuery(tag ⇒ new FeaturedCreatives(tag))

  /**
   * Entity class storing rows of table Follows
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param followingId Database column following_id SqlType(int4)
   *  @param followerId Database column follower_id SqlType(int4)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   */
  final case class FollowsRow(id: Int, followingId: Int, followerId: Int, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
  /** GetResult implicit for fetching FollowsRow objects using plain SQL queries */
  implicit def GetResultFollowsRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp]): GR[FollowsRow] = GR {
    prs ⇒
      import prs._
      FollowsRow.tupled((<<[Int], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table follows. Objects of this class serve as prototypes for rows in queries. */
  class Follows(_tableTag: Tag) extends profile.api.Table[FollowsRow](_tableTag, "follows") {
    def * = (id, followingId, followerId, createdAt, updatedAt) <> (FollowsRow.tupled, FollowsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(followingId), Rep.Some(followerId), Rep.Some(createdAt), Rep.Some(updatedAt)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ FollowsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column following_id SqlType(int4) */
    val followingId: Rep[Int] = column[Int]("following_id")
    /** Database column follower_id SqlType(int4) */
    val followerId: Rep[Int] = column[Int]("follower_id")
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")

    /** Index over (followerId) (database name index_follows_on_follower_id) */
    val index1 = index("index_follows_on_follower_id", followerId)
    /** Index over (followingId) (database name index_follows_on_following_id) */
    val index2 = index("index_follows_on_following_id", followingId)
    /** Uniqueness Index over (followingId,followerId) (database name index_follows_on_following_id_and_follower_id) */
    val index3 = index("index_follows_on_following_id_and_follower_id", (followingId, followerId), unique = true)
  }
  /** Collection-like TableQuery object for table Follows */
  lazy val Follows = new TableQuery(tag ⇒ new Follows(tag))

  /**
   * Entity class storing rows of table InviteRequests
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param email Database column email SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param fullName Database column full_name SqlType(varchar), Default(None)
   *  @param website Database column website SqlType(varchar), Default(None)
   */
  final case class InviteRequestsRow(id: Int, email: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, fullName: Option[String] = None, website: Option[String] = None)
  /** GetResult implicit for fetching InviteRequestsRow objects using plain SQL queries */
  implicit def GetResultInviteRequestsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[InviteRequestsRow] = GR {
    prs ⇒
      import prs._
      InviteRequestsRow.tupled((<<[Int], <<?[String], <<?[java.sql.Timestamp], <<?[String], <<?[String]))
  }
  /** Table description of table invite_requests. Objects of this class serve as prototypes for rows in queries. */
  class InviteRequests(_tableTag: Tag) extends profile.api.Table[InviteRequestsRow](_tableTag, "invite_requests") {
    def * = (id, email, createdAt, fullName, website) <> (InviteRequestsRow.tupled, InviteRequestsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), email, createdAt, fullName, website).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ InviteRequestsRow.tupled((_1.get, _2, _3, _4, _5))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email SqlType(varchar), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column full_name SqlType(varchar), Default(None) */
    val fullName: Rep[Option[String]] = column[Option[String]]("full_name", O.Default(None))
    /** Database column website SqlType(varchar), Default(None) */
    val website: Rep[Option[String]] = column[Option[String]]("website", O.Default(None))
  }
  /** Collection-like TableQuery object for table InviteRequests */
  lazy val InviteRequests = new TableQuery(tag ⇒ new InviteRequests(tag))

  /**
   * Entity class storing rows of table Inviters
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   */
  final case class InvitersRow(id: Int, name: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching InvitersRow objects using plain SQL queries */
  implicit def GetResultInvitersRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[InvitersRow] = GR {
    prs ⇒
      import prs._
      InvitersRow.tupled((<<[Int], <<?[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table inviters. Objects of this class serve as prototypes for rows in queries. */
  class Inviters(_tableTag: Tag) extends profile.api.Table[InvitersRow](_tableTag, "inviters") {
    def * = (id, name, createdAt) <> (InvitersRow.tupled, InvitersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, createdAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ InvitersRow.tupled((_1.get, _2, _3))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table Inviters */
  lazy val Inviters = new TableQuery(tag ⇒ new Inviters(tag))

  /**
   * Entity class storing rows of table Likes
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4)
   *  @param mediaId Database column media_id SqlType(int4)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   */
  final case class LikesRow(id: Int, userId: Int, mediaId: Int, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching LikesRow objects using plain SQL queries */
  implicit def GetResultLikesRow(implicit e0: GR[Int], e1: GR[Option[java.sql.Timestamp]]): GR[LikesRow] = GR {
    prs ⇒
      import prs._
      LikesRow.tupled((<<[Int], <<[Int], <<[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table likes. Objects of this class serve as prototypes for rows in queries. */
  class Likes(_tableTag: Tag) extends profile.api.Table[LikesRow](_tableTag, "likes") {
    def * = (id, userId, mediaId, createdAt, updatedAt) <> (LikesRow.tupled, LikesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), Rep.Some(mediaId), createdAt, updatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ LikesRow.tupled((_1.get, _2.get, _3.get, _4, _5))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column media_id SqlType(int4) */
    val mediaId: Rep[Int] = column[Int]("media_id")
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))

    /** Index over (mediaId) (database name index_likes_on_media_id) */
    val index1 = index("index_likes_on_media_id", mediaId)
    /** Index over (userId) (database name index_likes_on_user_id) */
    val index2 = index("index_likes_on_user_id", userId)
  }
  /** Collection-like TableQuery object for table Likes */
  lazy val Likes = new TableQuery(tag ⇒ new Likes(tag))

  /**
   * Entity class storing rows of table Locations
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param city Database column city SqlType(varchar), Default(None)
   *  @param state Database column state SqlType(varchar), Default(None)
   *  @param country Database column country SqlType(varchar), Default(None)
   *  @param latitude Database column latitude SqlType(numeric), Default(None)
   *  @param longitude Database column longitude SqlType(numeric), Default(None)
   *  @param timeZone Database column time_zone SqlType(varchar), Default(None)
   *  @param tagId Database column tag_id SqlType(int4), Default(None)
   */
  final case class LocationsRow(id: Int, city: Option[String] = None, state: Option[String] = None, country: Option[String] = None, latitude: Option[scala.math.BigDecimal] = None, longitude: Option[scala.math.BigDecimal] = None, timeZone: Option[String] = None, tagId: Option[Int] = None)
  /** GetResult implicit for fetching LocationsRow objects using plain SQL queries */
  implicit def GetResultLocationsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[scala.math.BigDecimal]], e3: GR[Option[Int]]): GR[LocationsRow] = GR {
    prs ⇒
      import prs._
      LocationsRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[scala.math.BigDecimal], <<?[scala.math.BigDecimal], <<?[String], <<?[Int]))
  }
  /** Table description of table locations. Objects of this class serve as prototypes for rows in queries. */
  class Locations(_tableTag: Tag) extends profile.api.Table[LocationsRow](_tableTag, "locations") {
    def * = (id, city, state, country, latitude, longitude, timeZone, tagId) <> (LocationsRow.tupled, LocationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), city, state, country, latitude, longitude, timeZone, tagId).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ LocationsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column city SqlType(varchar), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Default(None))
    /** Database column state SqlType(varchar), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Default(None))
    /** Database column country SqlType(varchar), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Default(None))
    /** Database column latitude SqlType(numeric), Default(None) */
    val latitude: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("latitude", O.Default(None))
    /** Database column longitude SqlType(numeric), Default(None) */
    val longitude: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("longitude", O.Default(None))
    /** Database column time_zone SqlType(varchar), Default(None) */
    val timeZone: Rep[Option[String]] = column[Option[String]]("time_zone", O.Default(None))
    /** Database column tag_id SqlType(int4), Default(None) */
    val tagId: Rep[Option[Int]] = column[Option[Int]]("tag_id", O.Default(None))
  }
  /** Collection-like TableQuery object for table Locations */
  lazy val Locations = new TableQuery(tag ⇒ new Locations(tag))

  /**
   * Entity class storing rows of table ManagedAccounts
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param stripeManagedAccountId Database column stripe_managed_account_id SqlType(varchar), Default(None)
   *  @param secretKey Database column secret_key SqlType(varchar), Default(None)
   *  @param publishableKey Database column publishable_key SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class ManagedAccountsRow(id: Int, userId: Option[Int] = None, stripeManagedAccountId: Option[String] = None, secretKey: Option[String] = None, publishableKey: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching ManagedAccountsRow objects using plain SQL queries */
  implicit def GetResultManagedAccountsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]]): GR[ManagedAccountsRow] = GR {
    prs ⇒
      import prs._
      ManagedAccountsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table managed_accounts. Objects of this class serve as prototypes for rows in queries. */
  class ManagedAccounts(_tableTag: Tag) extends profile.api.Table[ManagedAccountsRow](_tableTag, "managed_accounts") {
    def * = (id, userId, stripeManagedAccountId, secretKey, publishableKey, createdAt, updatedAt, deletedAt) <> (ManagedAccountsRow.tupled, ManagedAccountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), userId, stripeManagedAccountId, secretKey, publishableKey, createdAt, updatedAt, deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ ManagedAccountsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column stripe_managed_account_id SqlType(varchar), Default(None) */
    val stripeManagedAccountId: Rep[Option[String]] = column[Option[String]]("stripe_managed_account_id", O.Default(None))
    /** Database column secret_key SqlType(varchar), Default(None) */
    val secretKey: Rep[Option[String]] = column[Option[String]]("secret_key", O.Default(None))
    /** Database column publishable_key SqlType(varchar), Default(None) */
    val publishableKey: Rep[Option[String]] = column[Option[String]]("publishable_key", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table ManagedAccounts */
  lazy val ManagedAccounts = new TableQuery(tag ⇒ new ManagedAccounts(tag))

  /**
   * Entity class storing rows of table Media
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param uri Database column uri SqlType(varchar)
   *  @param `type` Database column type SqlType(varchar)
   *  @param x Database column x SqlType(int4)
   *  @param y Database column y SqlType(int4)
   *  @param w Database column w SqlType(int4)
   *  @param h Database column h SqlType(int4)
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param description Database column description SqlType(text), Default(None)
   *  @param title Database column title SqlType(varchar), Length(50,true), Default(None)
   *  @param captureDate Database column capture_date SqlType(date), Default(None)
   *  @param totalLikeCount Database column total_like_count SqlType(int4), Default(Some(0))
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   *  @param imageFileName Database column image_file_name SqlType(varchar), Default(None)
   *  @param imageContentType Database column image_content_type SqlType(varchar), Default(None)
   *  @param imageFileSize Database column image_file_size SqlType(int4), Default(None)
   *  @param imageUpdatedAt Database column image_updated_at SqlType(timestamp), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param albumId Database column album_id SqlType(int4), Default(None)
   *  @param featured Database column featured SqlType(int4), Default(None)
   *  @param purpose Database column purpose SqlType(varchar), Default(None)
   */
  final case class MediaRow(id: Int, uri: String, `type`: String, x: Int, y: Int, w: Int, h: Int, userId: Option[Int] = None, description: Option[String] = None, title: Option[String] = None, captureDate: Option[java.sql.Date] = None, totalLikeCount: Option[Int] = Some(0), deletedAt: Option[java.sql.Timestamp] = None, imageFileName: Option[String] = None, imageContentType: Option[String] = None, imageFileSize: Option[Int] = None, imageUpdatedAt: Option[java.sql.Timestamp] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, albumId: Option[Int] = None, featured: Option[Int] = None, purpose: Option[String] = None)
  /** GetResult implicit for fetching MediaRow objects using plain SQL queries */
  implicit def GetResultMediaRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[Option[String]], e4: GR[Option[java.sql.Date]], e5: GR[Option[java.sql.Timestamp]]): GR[MediaRow] = GR {
    prs ⇒
      import prs._
      MediaRow.tupled((<<[Int], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<?[Int], <<?[String], <<?[String], <<?[java.sql.Date], <<?[Int], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[Int], <<?[Int], <<?[String]))
  }
  /**
   * Table description of table media. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type
   */
  class Media(_tableTag: Tag) extends profile.api.Table[MediaRow](_tableTag, "media") {
    def * = (id, uri, `type`, x, y, w, h, userId, description, title, captureDate, totalLikeCount, deletedAt, imageFileName, imageContentType, imageFileSize, imageUpdatedAt, createdAt, updatedAt, albumId, featured, purpose) <> (MediaRow.tupled, MediaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uri), Rep.Some(`type`), Rep.Some(x), Rep.Some(y), Rep.Some(w), Rep.Some(h), userId, description, title, captureDate, totalLikeCount, deletedAt, imageFileName, imageContentType, imageFileSize, imageUpdatedAt, createdAt, updatedAt, albumId, featured, purpose).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ MediaRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uri SqlType(varchar) */
    val uri: Rep[String] = column[String]("uri")
    /**
     * Database column type SqlType(varchar)
     *  NOTE: The name was escaped because it collided with a Scala keyword.
     */
    val `type`: Rep[String] = column[String]("type")
    /** Database column x SqlType(int4) */
    val x: Rep[Int] = column[Int]("x")
    /** Database column y SqlType(int4) */
    val y: Rep[Int] = column[Int]("y")
    /** Database column w SqlType(int4) */
    val w: Rep[Int] = column[Int]("w")
    /** Database column h SqlType(int4) */
    val h: Rep[Int] = column[Int]("h")
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column description SqlType(text), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column title SqlType(varchar), Length(50,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(50, varying = true), O.Default(None))
    /** Database column capture_date SqlType(date), Default(None) */
    val captureDate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("capture_date", O.Default(None))
    /** Database column total_like_count SqlType(int4), Default(Some(0)) */
    val totalLikeCount: Rep[Option[Int]] = column[Option[Int]]("total_like_count", O.Default(Some(0)))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column image_file_name SqlType(varchar), Default(None) */
    val imageFileName: Rep[Option[String]] = column[Option[String]]("image_file_name", O.Default(None))
    /** Database column image_content_type SqlType(varchar), Default(None) */
    val imageContentType: Rep[Option[String]] = column[Option[String]]("image_content_type", O.Default(None))
    /** Database column image_file_size SqlType(int4), Default(None) */
    val imageFileSize: Rep[Option[Int]] = column[Option[Int]]("image_file_size", O.Default(None))
    /** Database column image_updated_at SqlType(timestamp), Default(None) */
    val imageUpdatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("image_updated_at", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column album_id SqlType(int4), Default(None) */
    val albumId: Rep[Option[Int]] = column[Option[Int]]("album_id", O.Default(None))
    /** Database column featured SqlType(int4), Default(None) */
    val featured: Rep[Option[Int]] = column[Option[Int]]("featured", O.Default(None))
    /** Database column purpose SqlType(varchar), Default(None) */
    val purpose: Rep[Option[String]] = column[Option[String]]("purpose", O.Default(None))

    /** Index over (albumId) (database name index_media_on_album_id) */
    val index1 = index("index_media_on_album_id", albumId)
  }
  /** Collection-like TableQuery object for table Media */
  lazy val Media = new TableQuery(tag ⇒ new Media(tag))

  /**
   * Entity class storing rows of table Messages
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param conversationId Database column conversation_id SqlType(int4)
   *  @param recipientId Database column recipient_id SqlType(int4)
   *  @param senderId Database column sender_id SqlType(int4)
   *  @param message Database column message SqlType(text)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   */
  final case class MessagesRow(id: Int, conversationId: Int, recipientId: Int, senderId: Int, message: String, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching MessagesRow objects using plain SQL queries */
  implicit def GetResultMessagesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Timestamp]]): GR[MessagesRow] = GR {
    prs ⇒
      import prs._
      MessagesRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table messages. Objects of this class serve as prototypes for rows in queries. */
  class Messages(_tableTag: Tag) extends profile.api.Table[MessagesRow](_tableTag, "messages") {
    def * = (id, conversationId, recipientId, senderId, message, createdAt, updatedAt) <> (MessagesRow.tupled, MessagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(conversationId), Rep.Some(recipientId), Rep.Some(senderId), Rep.Some(message), createdAt, updatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ MessagesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column conversation_id SqlType(int4) */
    val conversationId: Rep[Int] = column[Int]("conversation_id")
    /** Database column recipient_id SqlType(int4) */
    val recipientId: Rep[Int] = column[Int]("recipient_id")
    /** Database column sender_id SqlType(int4) */
    val senderId: Rep[Int] = column[Int]("sender_id")
    /** Database column message SqlType(text) */
    val message: Rep[String] = column[String]("message")
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))

    /** Index over (recipientId) (database name index_messages_on_recipient_id) */
    val index1 = index("index_messages_on_recipient_id", recipientId)
    /** Index over (senderId) (database name index_messages_on_sender_id) */
    val index2 = index("index_messages_on_sender_id", senderId)
  }
  /** Collection-like TableQuery object for table Messages */
  lazy val Messages = new TableQuery(tag ⇒ new Messages(tag))

  /**
   * Entity class storing rows of table MessageTemplates
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param messageType Database column message_type SqlType(varchar), Default(None)
   *  @param message Database column message SqlType(varchar), Default(None)
   */
  final case class MessageTemplatesRow(id: Int, messageType: Option[String] = None, message: Option[String] = None)
  /** GetResult implicit for fetching MessageTemplatesRow objects using plain SQL queries */
  implicit def GetResultMessageTemplatesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[MessageTemplatesRow] = GR {
    prs ⇒
      import prs._
      MessageTemplatesRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table message_templates. Objects of this class serve as prototypes for rows in queries. */
  class MessageTemplates(_tableTag: Tag) extends profile.api.Table[MessageTemplatesRow](_tableTag, "message_templates") {
    def * = (id, messageType, message) <> (MessageTemplatesRow.tupled, MessageTemplatesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), messageType, message).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ MessageTemplatesRow.tupled((_1.get, _2, _3))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column message_type SqlType(varchar), Default(None) */
    val messageType: Rep[Option[String]] = column[Option[String]]("message_type", O.Default(None))
    /** Database column message SqlType(varchar), Default(None) */
    val message: Rep[Option[String]] = column[Option[String]]("message", O.Default(None))
  }
  /** Collection-like TableQuery object for table MessageTemplates */
  lazy val MessageTemplates = new TableQuery(tag ⇒ new MessageTemplates(tag))

  /**
   * Entity class storing rows of table NotificationCenters
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param newMessage Database column new_message SqlType(bool), Default(Some(true))
   *  @param bookingAndReviewReminder Database column booking_and_review_reminder SqlType(bool), Default(Some(true))
   *  @param bookingStatusUpdate Database column booking_status_update SqlType(bool), Default(Some(true))
   *  @param bookingRequest Database column booking_request SqlType(bool), Default(Some(true))
   *  @param newFollower Database column new_follower SqlType(bool), Default(Some(true))
   *  @param updatesFromPatron Database column updates_from_patron SqlType(bool), Default(Some(true))
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   */
  final case class NotificationCentersRow(id: Int, userId: Option[Int] = None, newMessage: Option[Boolean] = Some(true), bookingAndReviewReminder: Option[Boolean] = Some(true), bookingStatusUpdate: Option[Boolean] = Some(true), bookingRequest: Option[Boolean] = Some(true), newFollower: Option[Boolean] = Some(true), updatesFromPatron: Option[Boolean] = Some(true), createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
  /** GetResult implicit for fetching NotificationCentersRow objects using plain SQL queries */
  implicit def GetResultNotificationCentersRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Boolean]], e3: GR[java.sql.Timestamp]): GR[NotificationCentersRow] = GR {
    prs ⇒
      import prs._
      NotificationCentersRow.tupled((<<[Int], <<?[Int], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table notification_centers. Objects of this class serve as prototypes for rows in queries. */
  class NotificationCenters(_tableTag: Tag) extends profile.api.Table[NotificationCentersRow](_tableTag, "notification_centers") {
    def * = (id, userId, newMessage, bookingAndReviewReminder, bookingStatusUpdate, bookingRequest, newFollower, updatesFromPatron, createdAt, updatedAt) <> (NotificationCentersRow.tupled, NotificationCentersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), userId, newMessage, bookingAndReviewReminder, bookingStatusUpdate, bookingRequest, newFollower, updatesFromPatron, Rep.Some(createdAt), Rep.Some(updatedAt)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ NotificationCentersRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9.get, _10.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column new_message SqlType(bool), Default(Some(true)) */
    val newMessage: Rep[Option[Boolean]] = column[Option[Boolean]]("new_message", O.Default(Some(true)))
    /** Database column booking_and_review_reminder SqlType(bool), Default(Some(true)) */
    val bookingAndReviewReminder: Rep[Option[Boolean]] = column[Option[Boolean]]("booking_and_review_reminder", O.Default(Some(true)))
    /** Database column booking_status_update SqlType(bool), Default(Some(true)) */
    val bookingStatusUpdate: Rep[Option[Boolean]] = column[Option[Boolean]]("booking_status_update", O.Default(Some(true)))
    /** Database column booking_request SqlType(bool), Default(Some(true)) */
    val bookingRequest: Rep[Option[Boolean]] = column[Option[Boolean]]("booking_request", O.Default(Some(true)))
    /** Database column new_follower SqlType(bool), Default(Some(true)) */
    val newFollower: Rep[Option[Boolean]] = column[Option[Boolean]]("new_follower", O.Default(Some(true)))
    /** Database column updates_from_patron SqlType(bool), Default(Some(true)) */
    val updatesFromPatron: Rep[Option[Boolean]] = column[Option[Boolean]]("updates_from_patron", O.Default(Some(true)))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")

    /** Uniqueness Index over (userId) (database name index_notification_centers_on_user_id) */
    val index1 = index("index_notification_centers_on_user_id", userId, unique = true)
  }
  /** Collection-like TableQuery object for table NotificationCenters */
  lazy val NotificationCenters = new TableQuery(tag ⇒ new NotificationCenters(tag))

  /**
   * Entity class storing rows of table Notifications
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param otherUserId Database column other_user_id SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param status Database column status SqlType(int4), Default(None)
   *  @param notificationType Database column notification_type SqlType(int4), Default(None)
   */
  final case class NotificationsRow(id: Int, userId: Option[Int] = None, otherUserId: Option[Int] = None, createdAt: Option[java.sql.Timestamp] = None, status: Option[Int] = None, notificationType: Option[Int] = None)
  /** GetResult implicit for fetching NotificationsRow objects using plain SQL queries */
  implicit def GetResultNotificationsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]]): GR[NotificationsRow] = GR {
    prs ⇒
      import prs._
      NotificationsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp], <<?[Int], <<?[Int]))
  }
  /** Table description of table notifications. Objects of this class serve as prototypes for rows in queries. */
  class Notifications(_tableTag: Tag) extends profile.api.Table[NotificationsRow](_tableTag, "notifications") {
    def * = (id, userId, otherUserId, createdAt, status, notificationType) <> (NotificationsRow.tupled, NotificationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), userId, otherUserId, createdAt, status, notificationType).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ NotificationsRow.tupled((_1.get, _2, _3, _4, _5, _6))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column other_user_id SqlType(int4), Default(None) */
    val otherUserId: Rep[Option[Int]] = column[Option[Int]]("other_user_id", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column status SqlType(int4), Default(None) */
    val status: Rep[Option[Int]] = column[Option[Int]]("status", O.Default(None))
    /** Database column notification_type SqlType(int4), Default(None) */
    val notificationType: Rep[Option[Int]] = column[Option[Int]]("notification_type", O.Default(None))
  }
  /** Collection-like TableQuery object for table Notifications */
  lazy val Notifications = new TableQuery(tag ⇒ new Notifications(tag))

  /**
   * Entity class storing rows of table OauthAccessGrants
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param resourceOwnerId Database column resource_owner_id SqlType(int4)
   *  @param applicationId Database column application_id SqlType(int4)
   *  @param token Database column token SqlType(varchar)
   *  @param expiresIn Database column expires_in SqlType(int4)
   *  @param redirectUri Database column redirect_uri SqlType(text)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param revokedAt Database column revoked_at SqlType(timestamp), Default(None)
   *  @param scopes Database column scopes SqlType(varchar), Default(None)
   */
  final case class OauthAccessGrantsRow(id: Int, resourceOwnerId: Int, applicationId: Int, token: String, expiresIn: Int, redirectUri: String, createdAt: java.sql.Timestamp, revokedAt: Option[java.sql.Timestamp] = None, scopes: Option[String] = None)
  /** GetResult implicit for fetching OauthAccessGrantsRow objects using plain SQL queries */
  implicit def GetResultOauthAccessGrantsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[java.sql.Timestamp]], e4: GR[Option[String]]): GR[OauthAccessGrantsRow] = GR {
    prs ⇒
      import prs._
      OauthAccessGrantsRow.tupled((<<[Int], <<[Int], <<[Int], <<[String], <<[Int], <<[String], <<[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table oauth_access_grants. Objects of this class serve as prototypes for rows in queries. */
  class OauthAccessGrants(_tableTag: Tag) extends profile.api.Table[OauthAccessGrantsRow](_tableTag, "oauth_access_grants") {
    def * = (id, resourceOwnerId, applicationId, token, expiresIn, redirectUri, createdAt, revokedAt, scopes) <> (OauthAccessGrantsRow.tupled, OauthAccessGrantsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(resourceOwnerId), Rep.Some(applicationId), Rep.Some(token), Rep.Some(expiresIn), Rep.Some(redirectUri), Rep.Some(createdAt), revokedAt, scopes).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ OauthAccessGrantsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column resource_owner_id SqlType(int4) */
    val resourceOwnerId: Rep[Int] = column[Int]("resource_owner_id")
    /** Database column application_id SqlType(int4) */
    val applicationId: Rep[Int] = column[Int]("application_id")
    /** Database column token SqlType(varchar) */
    val token: Rep[String] = column[String]("token")
    /** Database column expires_in SqlType(int4) */
    val expiresIn: Rep[Int] = column[Int]("expires_in")
    /** Database column redirect_uri SqlType(text) */
    val redirectUri: Rep[String] = column[String]("redirect_uri")
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column revoked_at SqlType(timestamp), Default(None) */
    val revokedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("revoked_at", O.Default(None))
    /** Database column scopes SqlType(varchar), Default(None) */
    val scopes: Rep[Option[String]] = column[Option[String]]("scopes", O.Default(None))

    /** Uniqueness Index over (token) (database name index_oauth_access_grants_on_token) */
    val index1 = index("index_oauth_access_grants_on_token", token, unique = true)
  }
  /** Collection-like TableQuery object for table OauthAccessGrants */
  lazy val OauthAccessGrants = new TableQuery(tag ⇒ new OauthAccessGrants(tag))

  /**
   * Entity class storing rows of table OauthAccessTokens
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param resourceOwnerId Database column resource_owner_id SqlType(int4), Default(None)
   *  @param applicationId Database column application_id SqlType(int4), Default(None)
   *  @param token Database column token SqlType(varchar)
   *  @param refreshToken Database column refresh_token SqlType(varchar), Default(None)
   *  @param expiresIn Database column expires_in SqlType(int4), Default(None)
   *  @param revokedAt Database column revoked_at SqlType(timestamp), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param scopes Database column scopes SqlType(varchar), Default(None)
   */
  final case class OauthAccessTokensRow(id: Int, resourceOwnerId: Option[Int] = None, applicationId: Option[Int] = None, token: String, refreshToken: Option[String] = None, expiresIn: Option[Int] = None, revokedAt: Option[java.sql.Timestamp] = None, createdAt: java.sql.Timestamp, scopes: Option[String] = None)
  /** GetResult implicit for fetching OauthAccessTokensRow objects using plain SQL queries */
  implicit def GetResultOauthAccessTokensRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[String], e3: GR[Option[String]], e4: GR[Option[java.sql.Timestamp]], e5: GR[java.sql.Timestamp]): GR[OauthAccessTokensRow] = GR {
    prs ⇒
      import prs._
      OauthAccessTokensRow.tupled((<<[Int], <<?[Int], <<?[Int], <<[String], <<?[String], <<?[Int], <<?[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table oauth_access_tokens. Objects of this class serve as prototypes for rows in queries. */
  class OauthAccessTokens(_tableTag: Tag) extends profile.api.Table[OauthAccessTokensRow](_tableTag, "oauth_access_tokens") {
    def * = (id, resourceOwnerId, applicationId, token, refreshToken, expiresIn, revokedAt, createdAt, scopes) <> (OauthAccessTokensRow.tupled, OauthAccessTokensRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), resourceOwnerId, applicationId, Rep.Some(token), refreshToken, expiresIn, revokedAt, Rep.Some(createdAt), scopes).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ OauthAccessTokensRow.tupled((_1.get, _2, _3, _4.get, _5, _6, _7, _8.get, _9))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column resource_owner_id SqlType(int4), Default(None) */
    val resourceOwnerId: Rep[Option[Int]] = column[Option[Int]]("resource_owner_id", O.Default(None))
    /** Database column application_id SqlType(int4), Default(None) */
    val applicationId: Rep[Option[Int]] = column[Option[Int]]("application_id", O.Default(None))
    /** Database column token SqlType(varchar) */
    val token: Rep[String] = column[String]("token")
    /** Database column refresh_token SqlType(varchar), Default(None) */
    val refreshToken: Rep[Option[String]] = column[Option[String]]("refresh_token", O.Default(None))
    /** Database column expires_in SqlType(int4), Default(None) */
    val expiresIn: Rep[Option[Int]] = column[Option[Int]]("expires_in", O.Default(None))
    /** Database column revoked_at SqlType(timestamp), Default(None) */
    val revokedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("revoked_at", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column scopes SqlType(varchar), Default(None) */
    val scopes: Rep[Option[String]] = column[Option[String]]("scopes", O.Default(None))

    /** Uniqueness Index over (refreshToken) (database name index_oauth_access_tokens_on_refresh_token) */
    val index1 = index("index_oauth_access_tokens_on_refresh_token", refreshToken, unique = true)
    /** Index over (resourceOwnerId) (database name index_oauth_access_tokens_on_resource_owner_id) */
    val index2 = index("index_oauth_access_tokens_on_resource_owner_id", resourceOwnerId)
    /** Uniqueness Index over (token) (database name index_oauth_access_tokens_on_token) */
    val index3 = index("index_oauth_access_tokens_on_token", token, unique = true)
  }
  /** Collection-like TableQuery object for table OauthAccessTokens */
  lazy val OauthAccessTokens = new TableQuery(tag ⇒ new OauthAccessTokens(tag))

  /**
   * Entity class storing rows of table OauthApplications
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar)
   *  @param uid Database column uid SqlType(varchar)
   *  @param secret Database column secret SqlType(varchar)
   *  @param redirectUri Database column redirect_uri SqlType(text)
   *  @param scopes Database column scopes SqlType(varchar), Default()
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   */
  final case class OauthApplicationsRow(id: Int, name: String, uid: String, secret: String, redirectUri: String, scopes: String = "", createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching OauthApplicationsRow objects using plain SQL queries */
  implicit def GetResultOauthApplicationsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Timestamp]]): GR[OauthApplicationsRow] = GR {
    prs ⇒
      import prs._
      OauthApplicationsRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table oauth_applications. Objects of this class serve as prototypes for rows in queries. */
  class OauthApplications(_tableTag: Tag) extends profile.api.Table[OauthApplicationsRow](_tableTag, "oauth_applications") {
    def * = (id, name, uid, secret, redirectUri, scopes, createdAt, updatedAt) <> (OauthApplicationsRow.tupled, OauthApplicationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(uid), Rep.Some(secret), Rep.Some(redirectUri), Rep.Some(scopes), createdAt, updatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ OauthApplicationsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column uid SqlType(varchar) */
    val uid: Rep[String] = column[String]("uid")
    /** Database column secret SqlType(varchar) */
    val secret: Rep[String] = column[String]("secret")
    /** Database column redirect_uri SqlType(text) */
    val redirectUri: Rep[String] = column[String]("redirect_uri")
    /** Database column scopes SqlType(varchar), Default() */
    val scopes: Rep[String] = column[String]("scopes", O.Default(""))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))

    /** Uniqueness Index over (uid) (database name index_oauth_applications_on_uid) */
    val index1 = index("index_oauth_applications_on_uid", uid, unique = true)
  }
  /** Collection-like TableQuery object for table OauthApplications */
  lazy val OauthApplications = new TableQuery(tag ⇒ new OauthApplications(tag))

  /**
   * Entity class storing rows of table PatronMembers
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param email Database column email SqlType(varchar)
   */
  final case class PatronMembersRow(id: Int, email: String)
  /** GetResult implicit for fetching PatronMembersRow objects using plain SQL queries */
  implicit def GetResultPatronMembersRow(implicit e0: GR[Int], e1: GR[String]): GR[PatronMembersRow] = GR {
    prs ⇒
      import prs._
      PatronMembersRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table patron_members. Objects of this class serve as prototypes for rows in queries. */
  class PatronMembers(_tableTag: Tag) extends profile.api.Table[PatronMembersRow](_tableTag, "patron_members") {
    def * = (id, email) <> (PatronMembersRow.tupled, PatronMembersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(email)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ PatronMembersRow.tupled((_1.get, _2.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email SqlType(varchar) */
    val email: Rep[String] = column[String]("email")

    /** Uniqueness Index over (email) (database name index_patron_members_on_email) */
    val index1 = index("index_patron_members_on_email", email, unique = true)
  }
  /** Collection-like TableQuery object for table PatronMembers */
  lazy val PatronMembers = new TableQuery(tag ⇒ new PatronMembers(tag))

  /**
   * Entity class storing rows of table Payments
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param bookingId Database column booking_id SqlType(int4), Default(None)
   *  @param creditCardId Database column credit_card_id SqlType(int4), Default(None)
   *  @param chargedAt Database column charged_at SqlType(timestamp), Default(None)
   *  @param state Database column state SqlType(int4), Default(Some(0))
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   *  @param bookingCharge Database column booking_charge SqlType(int4), Default(None)
   *  @param patronFee Database column patron_fee SqlType(int4), Default(None)
   */
  final case class PaymentsRow(id: Int, bookingId: Option[Int] = None, creditCardId: Option[Int] = None, chargedAt: Option[java.sql.Timestamp] = None, state: Option[Int] = Some(0), createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, bookingCharge: Option[Int] = None, patronFee: Option[Int] = None)
  /** GetResult implicit for fetching PaymentsRow objects using plain SQL queries */
  implicit def GetResultPaymentsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]], e3: GR[java.sql.Timestamp]): GR[PaymentsRow] = GR {
    prs ⇒
      import prs._
      PaymentsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[Int], <<?[Int]))
  }
  /** Table description of table payments. Objects of this class serve as prototypes for rows in queries. */
  class Payments(_tableTag: Tag) extends profile.api.Table[PaymentsRow](_tableTag, "payments") {
    def * = (id, bookingId, creditCardId, chargedAt, state, createdAt, updatedAt, bookingCharge, patronFee) <> (PaymentsRow.tupled, PaymentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), bookingId, creditCardId, chargedAt, state, Rep.Some(createdAt), Rep.Some(updatedAt), bookingCharge, patronFee).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ PaymentsRow.tupled((_1.get, _2, _3, _4, _5, _6.get, _7.get, _8, _9))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column booking_id SqlType(int4), Default(None) */
    val bookingId: Rep[Option[Int]] = column[Option[Int]]("booking_id", O.Default(None))
    /** Database column credit_card_id SqlType(int4), Default(None) */
    val creditCardId: Rep[Option[Int]] = column[Option[Int]]("credit_card_id", O.Default(None))
    /** Database column charged_at SqlType(timestamp), Default(None) */
    val chargedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("charged_at", O.Default(None))
    /** Database column state SqlType(int4), Default(Some(0)) */
    val state: Rep[Option[Int]] = column[Option[Int]]("state", O.Default(Some(0)))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column booking_charge SqlType(int4), Default(None) */
    val bookingCharge: Rep[Option[Int]] = column[Option[Int]]("booking_charge", O.Default(None))
    /** Database column patron_fee SqlType(int4), Default(None) */
    val patronFee: Rep[Option[Int]] = column[Option[Int]]("patron_fee", O.Default(None))
  }
  /** Collection-like TableQuery object for table Payments */
  lazy val Payments = new TableQuery(tag ⇒ new Payments(tag))

  /**
   * Entity class storing rows of table Reviews
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param about Database column about SqlType(int4)
   *  @param from Database column from SqlType(varchar), Default(None)
   *  @param `for` Database column for SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   */
  final case class ReviewsRow(id: Int, about: Int, from: Option[String] = None, `for`: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching ReviewsRow objects using plain SQL queries */
  implicit def GetResultReviewsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[ReviewsRow] = GR {
    prs ⇒
      import prs._
      ReviewsRow.tupled((<<[Int], <<[Int], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /**
   * Table description of table reviews. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: for
   */
  class Reviews(_tableTag: Tag) extends profile.api.Table[ReviewsRow](_tableTag, "reviews") {
    def * = (id, about, from, `for`, createdAt, updatedAt) <> (ReviewsRow.tupled, ReviewsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(about), from, `for`, createdAt, updatedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ ReviewsRow.tupled((_1.get, _2.get, _3, _4, _5, _6))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column about SqlType(int4) */
    val about: Rep[Int] = column[Int]("about")
    /** Database column from SqlType(varchar), Default(None) */
    val from: Rep[Option[String]] = column[Option[String]]("from", O.Default(None))
    /**
     * Database column for SqlType(varchar), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword.
     */
    val `for`: Rep[Option[String]] = column[Option[String]]("for", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
  }
  /** Collection-like TableQuery object for table Reviews */
  lazy val Reviews = new TableQuery(tag ⇒ new Reviews(tag))

  /**
   * Entity class storing rows of table SchemaMigrations
   *  @param version Database column version SqlType(varchar)
   */
  final case class SchemaMigrationsRow(version: String)
  /** GetResult implicit for fetching SchemaMigrationsRow objects using plain SQL queries */
  implicit def GetResultSchemaMigrationsRow(implicit e0: GR[String]): GR[SchemaMigrationsRow] = GR {
    prs ⇒
      import prs._
      SchemaMigrationsRow(<<[String])
  }
  /** Table description of table schema_migrations. Objects of this class serve as prototypes for rows in queries. */
  class SchemaMigrations(_tableTag: Tag) extends profile.api.Table[SchemaMigrationsRow](_tableTag, "schema_migrations") {
    def * = version <> (SchemaMigrationsRow, SchemaMigrationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = Rep.Some(version).shaped.<>(r ⇒ r.map(_ ⇒ SchemaMigrationsRow(r.get)), (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column version SqlType(varchar) */
    val version: Rep[String] = column[String]("version")

    /** Uniqueness Index over (version) (database name unique_schema_migrations) */
    val index1 = index("unique_schema_migrations", version, unique = true)
  }
  /** Collection-like TableQuery object for table SchemaMigrations */
  lazy val SchemaMigrations = new TableQuery(tag ⇒ new SchemaMigrations(tag))

  /**
   * Entity class storing rows of table ServiceOptions
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param charge Database column charge SqlType(int4), Default(None)
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   */
  final case class ServiceOptionsRow(id: Int, name: Option[String] = None, charge: Option[Int] = None, userId: Option[Int] = None, deletedAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching ServiceOptionsRow objects using plain SQL queries */
  implicit def GetResultServiceOptionsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]]): GR[ServiceOptionsRow] = GR {
    prs ⇒
      import prs._
      ServiceOptionsRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table service_options. Objects of this class serve as prototypes for rows in queries. */
  class ServiceOptions(_tableTag: Tag) extends profile.api.Table[ServiceOptionsRow](_tableTag, "service_options") {
    def * = (id, name, charge, userId, deletedAt) <> (ServiceOptionsRow.tupled, ServiceOptionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, charge, userId, deletedAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ ServiceOptionsRow.tupled((_1.get, _2, _3, _4, _5))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column charge SqlType(int4), Default(None) */
    val charge: Rep[Option[Int]] = column[Option[Int]]("charge", O.Default(None))
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))

    /** Foreign key referencing Users (database name fk_rails_5e833f52db) */
    lazy val usersFk = foreignKey("fk_rails_5e833f52db", userId, Users)(r ⇒ Rep.Some(r.id), onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ServiceOptions */
  lazy val ServiceOptions = new TableQuery(tag ⇒ new ServiceOptions(tag))

  /**
   * Entity class storing rows of table Services
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param image Database column image SqlType(varchar), Default(None)
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param hourly Database column hourly SqlType(bool), Default(None)
   *  @param rate Database column rate SqlType(int4), Default(None)
   *  @param minBookingTime Database column min_booking_time SqlType(int4), Default(None)
   *  @param description Database column description SqlType(varchar), Default(None)
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(timestamp), Default(None)
   *  @param serviceImageFileName Database column service_image_file_name SqlType(varchar), Default(None)
   *  @param serviceImageContentType Database column service_image_content_type SqlType(varchar), Default(None)
   *  @param serviceImageFileSize Database column service_image_file_size SqlType(int4), Default(None)
   *  @param serviceImageUpdatedAt Database column service_image_updated_at SqlType(timestamp), Default(None)
   *  @param category Database column category SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param updatedAt Database column updated_at SqlType(timestamp), Default(None)
   *  @param featured Database column featured SqlType(int4), Default(None)
   *  @param hidden Database column hidden SqlType(bool), Default(None)
   *  @param serviceLocation Database column service_location SqlType(varchar), Default(None)
   *  @param coverMediaId Database column cover_media_id SqlType(int4), Default(None)
   */
  final case class ServicesRow(id: Int, image: Option[String] = None, name: Option[String] = None, hourly: Option[Boolean] = None, rate: Option[Int] = None, minBookingTime: Option[Int] = None, description: Option[String] = None, userId: Option[Int] = None, deletedAt: Option[java.sql.Timestamp] = None, serviceImageFileName: Option[String] = None, serviceImageContentType: Option[String] = None, serviceImageFileSize: Option[Int] = None, serviceImageUpdatedAt: Option[java.sql.Timestamp] = None, category: Option[Int] = None, createdAt: Option[java.sql.Timestamp] = None, updatedAt: Option[java.sql.Timestamp] = None, featured: Option[Int] = None, hidden: Option[Boolean] = None, serviceLocation: Option[String] = None, coverMediaId: Option[Int] = None)
  /** GetResult implicit for fetching ServicesRow objects using plain SQL queries */
  implicit def GetResultServicesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Boolean]], e3: GR[Option[Int]], e4: GR[Option[java.sql.Timestamp]]): GR[ServicesRow] = GR {
    prs ⇒
      import prs._
      ServicesRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Boolean], <<?[Int], <<?[Int], <<?[String], <<?[Int], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Timestamp], <<?[Int], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[Int], <<?[Boolean], <<?[String], <<?[Int]))
  }
  /** Table description of table services. Objects of this class serve as prototypes for rows in queries. */
  class Services(_tableTag: Tag) extends profile.api.Table[ServicesRow](_tableTag, "services") {
    def * = (id, image, name, hourly, rate, minBookingTime, description, userId, deletedAt, serviceImageFileName, serviceImageContentType, serviceImageFileSize, serviceImageUpdatedAt, category, createdAt, updatedAt, featured, hidden, serviceLocation, coverMediaId) <> (ServicesRow.tupled, ServicesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), image, name, hourly, rate, minBookingTime, description, userId, deletedAt, serviceImageFileName, serviceImageContentType, serviceImageFileSize, serviceImageUpdatedAt, category, createdAt, updatedAt, featured, hidden, serviceLocation, coverMediaId).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ ServicesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column image SqlType(varchar), Default(None) */
    val image: Rep[Option[String]] = column[Option[String]]("image", O.Default(None))
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column hourly SqlType(bool), Default(None) */
    val hourly: Rep[Option[Boolean]] = column[Option[Boolean]]("hourly", O.Default(None))
    /** Database column rate SqlType(int4), Default(None) */
    val rate: Rep[Option[Int]] = column[Option[Int]]("rate", O.Default(None))
    /** Database column min_booking_time SqlType(int4), Default(None) */
    val minBookingTime: Rep[Option[Int]] = column[Option[Int]]("min_booking_time", O.Default(None))
    /** Database column description SqlType(varchar), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column service_image_file_name SqlType(varchar), Default(None) */
    val serviceImageFileName: Rep[Option[String]] = column[Option[String]]("service_image_file_name", O.Default(None))
    /** Database column service_image_content_type SqlType(varchar), Default(None) */
    val serviceImageContentType: Rep[Option[String]] = column[Option[String]]("service_image_content_type", O.Default(None))
    /** Database column service_image_file_size SqlType(int4), Default(None) */
    val serviceImageFileSize: Rep[Option[Int]] = column[Option[Int]]("service_image_file_size", O.Default(None))
    /** Database column service_image_updated_at SqlType(timestamp), Default(None) */
    val serviceImageUpdatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("service_image_updated_at", O.Default(None))
    /** Database column category SqlType(int4), Default(None) */
    val category: Rep[Option[Int]] = column[Option[Int]]("category", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column updated_at SqlType(timestamp), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column featured SqlType(int4), Default(None) */
    val featured: Rep[Option[Int]] = column[Option[Int]]("featured", O.Default(None))
    /** Database column hidden SqlType(bool), Default(None) */
    val hidden: Rep[Option[Boolean]] = column[Option[Boolean]]("hidden", O.Default(None))
    /** Database column service_location SqlType(varchar), Default(None) */
    val serviceLocation: Rep[Option[String]] = column[Option[String]]("service_location", O.Default(None))
    /** Database column cover_media_id SqlType(int4), Default(None) */
    val coverMediaId: Rep[Option[Int]] = column[Option[Int]]("cover_media_id", O.Default(None))

    /** Foreign key referencing Users (database name fk_rails_51a813203f) */
    lazy val usersFk = foreignKey("fk_rails_51a813203f", userId, Users)(r ⇒ Rep.Some(r.id), onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Services */
  lazy val Services = new TableQuery(tag ⇒ new Services(tag))

  /**
   * Entity class storing rows of table SocialAccounts
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param provider Database column provider SqlType(int2)
   *  @param token Database column token SqlType(varchar)
   *  @param userId Database column user_id SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp)
   *  @param updatedAt Database column updated_at SqlType(timestamp)
   */
  final case class SocialAccountsRow(id: Int, provider: Short, token: String, userId: Option[Int] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
  /** GetResult implicit for fetching SocialAccountsRow objects using plain SQL queries */
  implicit def GetResultSocialAccountsRow(implicit e0: GR[Int], e1: GR[Short], e2: GR[String], e3: GR[Option[Int]], e4: GR[java.sql.Timestamp]): GR[SocialAccountsRow] = GR {
    prs ⇒
      import prs._
      SocialAccountsRow.tupled((<<[Int], <<[Short], <<[String], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table social_accounts. Objects of this class serve as prototypes for rows in queries. */
  class SocialAccounts(_tableTag: Tag) extends profile.api.Table[SocialAccountsRow](_tableTag, "social_accounts") {
    def * = (id, provider, token, userId, createdAt, updatedAt) <> (SocialAccountsRow.tupled, SocialAccountsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(provider), Rep.Some(token), userId, Rep.Some(createdAt), Rep.Some(updatedAt)).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ SocialAccountsRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column provider SqlType(int2) */
    val provider: Rep[Short] = column[Short]("provider")
    /** Database column token SqlType(varchar) */
    val token: Rep[String] = column[String]("token")
    /** Database column user_id SqlType(int4), Default(None) */
    val userId: Rep[Option[Int]] = column[Option[Int]]("user_id", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")

    /** Foreign key referencing Users (database name fk_rails_7b2f868331) */
    lazy val usersFk = foreignKey("fk_rails_7b2f868331", userId, Users)(r ⇒ Rep.Some(r.id), onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)

    /** Uniqueness Index over (provider,token) (database name index_social_accounts_on_provider_and_token) */
    val index1 = index("index_social_accounts_on_provider_and_token", (provider, token), unique = true)
  }
  /** Collection-like TableQuery object for table SocialAccounts */
  lazy val SocialAccounts = new TableQuery(tag ⇒ new SocialAccounts(tag))

  /**
   * Entity class storing rows of table TagMaps
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param taggedType Database column tagged_type SqlType(varchar), Default(None)
   *  @param taggedId Database column tagged_id SqlType(int4), Default(None)
   *  @param tagId Database column tag_id SqlType(int4), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   */
  final case class TagMapsRow(id: Int, taggedType: Option[String] = None, taggedId: Option[Int] = None, tagId: Option[Int] = None, createdAt: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching TagMapsRow objects using plain SQL queries */
  implicit def GetResultTagMapsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]]): GR[TagMapsRow] = GR {
    prs ⇒
      import prs._
      TagMapsRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table tag_maps. Objects of this class serve as prototypes for rows in queries. */
  class TagMaps(_tableTag: Tag) extends profile.api.Table[TagMapsRow](_tableTag, "tag_maps") {
    def * = (id, taggedType, taggedId, tagId, createdAt) <> (TagMapsRow.tupled, TagMapsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), taggedType, taggedId, tagId, createdAt).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ TagMapsRow.tupled((_1.get, _2, _3, _4, _5))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column tagged_type SqlType(varchar), Default(None) */
    val taggedType: Rep[Option[String]] = column[Option[String]]("tagged_type", O.Default(None))
    /** Database column tagged_id SqlType(int4), Default(None) */
    val taggedId: Rep[Option[Int]] = column[Option[Int]]("tagged_id", O.Default(None))
    /** Database column tag_id SqlType(int4), Default(None) */
    val tagId: Rep[Option[Int]] = column[Option[Int]]("tag_id", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))

    /** Foreign key referencing Tags (database name fk_rails_5f66989e5f) */
    lazy val tagsFk = foreignKey("fk_rails_5f66989e5f", tagId, Tags)(r ⇒ Rep.Some(r.id), onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TagMaps */
  lazy val TagMaps = new TableQuery(tag ⇒ new TagMaps(tag))

  /**
   * Entity class storing rows of table Tags
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param tagType Database column tag_type SqlType(int4), Default(None)
   */
  final case class TagsRow(id: Int, name: Option[String] = None, tagType: Option[Int] = None)
  /** GetResult implicit for fetching TagsRow objects using plain SQL queries */
  implicit def GetResultTagsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[TagsRow] = GR {
    prs ⇒
      import prs._
      TagsRow.tupled((<<[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table tags. Objects of this class serve as prototypes for rows in queries. */
  class Tags(_tableTag: Tag) extends profile.api.Table[TagsRow](_tableTag, "tags") {
    def * = (id, name, tagType) <> (TagsRow.tupled, TagsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, tagType).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ TagsRow.tupled((_1.get, _2, _3))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column tag_type SqlType(int4), Default(None) */
    val tagType: Rep[Option[Int]] = column[Option[Int]]("tag_type", O.Default(None))

    /** Uniqueness Index over (name) (database name index_tags_on_name) */
    val index1 = index("index_tags_on_name", name, unique = true)
  }
  /** Collection-like TableQuery object for table Tags */
  lazy val Tags = new TableQuery(tag ⇒ new Tags(tag))

  /**
   * Entity class storing rows of table Transfers
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param paymentId Database column payment_id SqlType(int4), Default(None)
   *  @param managedAccountId Database column managed_account_id SqlType(int4), Default(None)
   *  @param stripeChargeId Database column stripe_charge_id SqlType(varchar), Default(None)
   *  @param createdAt Database column created_at SqlType(timestamp), Default(None)
   *  @param totalCharge Database column total_charge SqlType(int4), Default(None)
   *  @param patronFee Database column patron_fee SqlType(int4), Default(None)
   *  @param totalTransferAmount Database column total_transfer_amount SqlType(int4), Default(None)
   *  @param creativeFee Database column creative_fee SqlType(int4), Default(None)
   */
  final case class TransfersRow(id: Int, paymentId: Option[Int] = None, managedAccountId: Option[Int] = None, stripeChargeId: Option[String] = None, createdAt: Option[java.sql.Timestamp] = None, totalCharge: Option[Int] = None, patronFee: Option[Int] = None, totalTransferAmount: Option[Int] = None, creativeFee: Option[Int] = None)
  /** GetResult implicit for fetching TransfersRow objects using plain SQL queries */
  implicit def GetResultTransfersRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]]): GR[TransfersRow] = GR {
    prs ⇒
      import prs._
      TransfersRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[String], <<?[java.sql.Timestamp], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table transfers. Objects of this class serve as prototypes for rows in queries. */
  class Transfers(_tableTag: Tag) extends profile.api.Table[TransfersRow](_tableTag, "transfers") {
    def * = (id, paymentId, managedAccountId, stripeChargeId, createdAt, totalCharge, patronFee, totalTransferAmount, creativeFee) <> (TransfersRow.tupled, TransfersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), paymentId, managedAccountId, stripeChargeId, createdAt, totalCharge, patronFee, totalTransferAmount, creativeFee).shaped.<>({ r ⇒ import r._; _1.map(_ ⇒ TransfersRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9))) }, (_: Any) ⇒ throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column payment_id SqlType(int4), Default(None) */
    val paymentId: Rep[Option[Int]] = column[Option[Int]]("payment_id", O.Default(None))
    /** Database column managed_account_id SqlType(int4), Default(None) */
    val managedAccountId: Rep[Option[Int]] = column[Option[Int]]("managed_account_id", O.Default(None))
    /** Database column stripe_charge_id SqlType(varchar), Default(None) */
    val stripeChargeId: Rep[Option[String]] = column[Option[String]]("stripe_charge_id", O.Default(None))
    /** Database column created_at SqlType(timestamp), Default(None) */
    val createdAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created_at", O.Default(None))
    /** Database column total_charge SqlType(int4), Default(None) */
    val totalCharge: Rep[Option[Int]] = column[Option[Int]]("total_charge", O.Default(None))
    /** Database column patron_fee SqlType(int4), Default(None) */
    val patronFee: Rep[Option[Int]] = column[Option[Int]]("patron_fee", O.Default(None))
    /** Database column total_transfer_amount SqlType(int4), Default(None) */
    val totalTransferAmount: Rep[Option[Int]] = column[Option[Int]]("total_transfer_amount", O.Default(None))
    /** Database column creative_fee SqlType(int4), Default(None) */
    val creativeFee: Rep[Option[Int]] = column[Option[Int]]("creative_fee", O.Default(None))
  }
  /** Collection-like TableQuery object for table Transfers */
  lazy val Transfers = new TableQuery(tag ⇒ new Transfers(tag))

  /** Row type of table Users */
  type UsersRow = HCons[Int, HCons[String, HCons[String, HCons[Option[String], HCons[Option[java.sql.Timestamp], HCons[Option[java.sql.Timestamp], HCons[Int, HCons[Option[java.sql.Timestamp], HCons[Option[java.sql.Timestamp], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[java.sql.Timestamp, HCons[java.sql.Timestamp, HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[java.sql.Timestamp], HCons[Option[java.sql.Timestamp], HCons[Option[Int], HCons[Option[java.sql.Timestamp], HCons[Option[String], HCons[Option[Boolean], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Int], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[java.sql.Timestamp], HCons[Option[String], HCons[Option[String], HCons[Option[Int], HCons[Option[java.sql.Timestamp], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Int], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Int], HCons[Option[java.sql.Timestamp], HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for UsersRow providing default values if available in the database schema. */
  def UsersRow(id: Int, email: String = "", passwordDigest: String = "", resetPasswordToken: Option[String] = None, resetPasswordSentAt: Option[java.sql.Timestamp] = None, rememberCreatedAt: Option[java.sql.Timestamp] = None, signInCount: Int = 0, currentSignInAt: Option[java.sql.Timestamp] = None, lastSignInAt: Option[java.sql.Timestamp] = None, currentSignInIp: Option[String] = None, lastSignInIp: Option[String] = None, gender: Option[String] = None, addressLine1: Option[String] = None, addressLine2: Option[String] = None, city: Option[String] = None, zipcode: Option[String] = None, professionalHeadline: Option[String] = None, phoneNumber: Option[String] = None, provider: Option[String] = None, createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp, fullName: Option[String] = None, `type`: Option[String] = None, confirmationToken: Option[String] = None, confirmationTokenSentAt: Option[java.sql.Timestamp] = None, confirmedAt: Option[java.sql.Timestamp] = None, totalUnreadCount: Option[Int] = Some(0), dateOfBirth: Option[java.sql.Timestamp] = None, state: Option[String] = None, passwordSet: Option[Boolean] = Some(false), bio: Option[String] = Some(""), headline: Option[String] = None, creativeTypes: Option[String] = None, unreadNotifications: Option[Int] = Some(0), userName: Option[String] = None, profilePicUrl: Option[String] = None, timeZone: Option[String] = None, deletedAt: Option[java.sql.Timestamp] = None, profileImageFileName: Option[String] = None, profileImageContentType: Option[String] = None, profileImageFileSize: Option[Int] = None, profileImageUpdatedAt: Option[java.sql.Timestamp] = None, googleCalendarCredentials: Option[String] = None, currentCity: Option[String] = None, currentState: Option[String] = None, featured: Option[Int] = None, invitedEmails: Option[String] = None, invitePassword: Option[String] = None, animatedGifFileName: Option[String] = None, animatedGifContentType: Option[String] = None, animatedGifFileSize: Option[Int] = None, animatedGifUpdatedAt: Option[java.sql.Timestamp] = None): UsersRow = {
    id :: email :: passwordDigest :: resetPasswordToken :: resetPasswordSentAt :: rememberCreatedAt :: signInCount :: currentSignInAt :: lastSignInAt :: currentSignInIp :: lastSignInIp :: gender :: addressLine1 :: addressLine2 :: city :: zipcode :: professionalHeadline :: phoneNumber :: provider :: createdAt :: updatedAt :: fullName :: `type` :: confirmationToken :: confirmationTokenSentAt :: confirmedAt :: totalUnreadCount :: dateOfBirth :: state :: passwordSet :: bio :: headline :: creativeTypes :: unreadNotifications :: userName :: profilePicUrl :: timeZone :: deletedAt :: profileImageFileName :: profileImageContentType :: profileImageFileSize :: profileImageUpdatedAt :: googleCalendarCredentials :: currentCity :: currentState :: featured :: invitedEmails :: invitePassword :: animatedGifFileName :: animatedGifContentType :: animatedGifFileSize :: animatedGifUpdatedAt :: HNil
  }
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]], e4: GR[java.sql.Timestamp], e5: GR[Option[Int]], e6: GR[Option[Boolean]]): GR[UsersRow] = GR {
    prs ⇒
      import prs._
      <<[Int] :: <<[String] :: <<[String] :: <<?[String] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<[Int] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<[java.sql.Timestamp] :: <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[Int] :: <<?[java.sql.Timestamp] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[java.sql.Timestamp] :: HNil
  }
  /**
   * Table description of table users. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type
   */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, "users") {
    def * = id :: email :: passwordDigest :: resetPasswordToken :: resetPasswordSentAt :: rememberCreatedAt :: signInCount :: currentSignInAt :: lastSignInAt :: currentSignInIp :: lastSignInIp :: gender :: addressLine1 :: addressLine2 :: city :: zipcode :: professionalHeadline :: phoneNumber :: provider :: createdAt :: updatedAt :: fullName :: `type` :: confirmationToken :: confirmationTokenSentAt :: confirmedAt :: totalUnreadCount :: dateOfBirth :: state :: passwordSet :: bio :: headline :: creativeTypes :: unreadNotifications :: userName :: profilePicUrl :: timeZone :: deletedAt :: profileImageFileName :: profileImageContentType :: profileImageFileSize :: profileImageUpdatedAt :: googleCalendarCredentials :: currentCity :: currentState :: featured :: invitedEmails :: invitePassword :: animatedGifFileName :: animatedGifContentType :: animatedGifFileSize :: animatedGifUpdatedAt :: HNil

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email SqlType(varchar), Default() */
    val email: Rep[String] = column[String]("email", O.Default(""))
    /** Database column password_digest SqlType(varchar), Default() */
    val passwordDigest: Rep[String] = column[String]("password_digest", O.Default(""))
    /** Database column reset_password_token SqlType(varchar), Default(None) */
    val resetPasswordToken: Rep[Option[String]] = column[Option[String]]("reset_password_token", O.Default(None))
    /** Database column reset_password_sent_at SqlType(timestamp), Default(None) */
    val resetPasswordSentAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("reset_password_sent_at", O.Default(None))
    /** Database column remember_created_at SqlType(timestamp), Default(None) */
    val rememberCreatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("remember_created_at", O.Default(None))
    /** Database column sign_in_count SqlType(int4), Default(0) */
    val signInCount: Rep[Int] = column[Int]("sign_in_count", O.Default(0))
    /** Database column current_sign_in_at SqlType(timestamp), Default(None) */
    val currentSignInAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("current_sign_in_at", O.Default(None))
    /** Database column last_sign_in_at SqlType(timestamp), Default(None) */
    val lastSignInAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_sign_in_at", O.Default(None))
    /** Database column current_sign_in_ip SqlType(inet), Length(2147483647,false), Default(None) */
    val currentSignInIp: Rep[Option[String]] = column[Option[String]]("current_sign_in_ip", O.Length(2147483647, varying = false), O.Default(None))
    /** Database column last_sign_in_ip SqlType(inet), Length(2147483647,false), Default(None) */
    val lastSignInIp: Rep[Option[String]] = column[Option[String]]("last_sign_in_ip", O.Length(2147483647, varying = false), O.Default(None))
    /** Database column gender SqlType(varchar), Default(None) */
    val gender: Rep[Option[String]] = column[Option[String]]("gender", O.Default(None))
    /** Database column address_line_1 SqlType(varchar), Default(None) */
    val addressLine1: Rep[Option[String]] = column[Option[String]]("address_line_1", O.Default(None))
    /** Database column address_line_2 SqlType(varchar), Default(None) */
    val addressLine2: Rep[Option[String]] = column[Option[String]]("address_line_2", O.Default(None))
    /** Database column city SqlType(varchar), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("city", O.Default(None))
    /** Database column zipcode SqlType(varchar), Default(None) */
    val zipcode: Rep[Option[String]] = column[Option[String]]("zipcode", O.Default(None))
    /** Database column professional_headline SqlType(varchar), Default(None) */
    val professionalHeadline: Rep[Option[String]] = column[Option[String]]("professional_headline", O.Default(None))
    /** Database column phone_number SqlType(varchar), Default(None) */
    val phoneNumber: Rep[Option[String]] = column[Option[String]]("phone_number", O.Default(None))
    /** Database column provider SqlType(varchar), Default(None) */
    val provider: Rep[Option[String]] = column[Option[String]]("provider", O.Default(None))
    /** Database column created_at SqlType(timestamp) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_at SqlType(timestamp) */
    val updatedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_at")
    /** Database column full_name SqlType(varchar), Default(None) */
    val fullName: Rep[Option[String]] = column[Option[String]]("full_name", O.Default(None))
    /**
     * Database column type SqlType(varchar), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword.
     */
    val `type`: Rep[Option[String]] = column[Option[String]]("type", O.Default(None))
    /** Database column confirmation_token SqlType(varchar), Default(None) */
    val confirmationToken: Rep[Option[String]] = column[Option[String]]("confirmation_token", O.Default(None))
    /** Database column confirmation_token_sent_at SqlType(timestamp), Default(None) */
    val confirmationTokenSentAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("confirmation_token_sent_at", O.Default(None))
    /** Database column confirmed_at SqlType(timestamp), Default(None) */
    val confirmedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("confirmed_at", O.Default(None))
    /** Database column total_unread_count SqlType(int4), Default(Some(0)) */
    val totalUnreadCount: Rep[Option[Int]] = column[Option[Int]]("total_unread_count", O.Default(Some(0)))
    /** Database column date_of_birth SqlType(timestamp), Default(None) */
    val dateOfBirth: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date_of_birth", O.Default(None))
    /** Database column state SqlType(varchar), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Default(None))
    /** Database column password_set SqlType(bool), Default(Some(false)) */
    val passwordSet: Rep[Option[Boolean]] = column[Option[Boolean]]("password_set", O.Default(Some(false)))
    /** Database column bio SqlType(text), Default(Some()) */
    val bio: Rep[Option[String]] = column[Option[String]]("bio", O.Default(Some("")))
    /** Database column headline SqlType(varchar), Length(50,true), Default(None) */
    val headline: Rep[Option[String]] = column[Option[String]]("headline", O.Length(50, varying = true), O.Default(None))
    /** Database column creative_types SqlType(_varchar), Length(2147483647,false), Default(None) */
    val creativeTypes: Rep[Option[String]] = column[Option[String]]("creative_types", O.Length(2147483647, varying = false), O.Default(None))
    /** Database column unread_notifications SqlType(int4), Default(Some(0)) */
    val unreadNotifications: Rep[Option[Int]] = column[Option[Int]]("unread_notifications", O.Default(Some(0)))
    /** Database column user_name SqlType(varchar), Default(None) */
    val userName: Rep[Option[String]] = column[Option[String]]("user_name", O.Default(None))
    /** Database column profile_pic_url SqlType(varchar), Default(None) */
    val profilePicUrl: Rep[Option[String]] = column[Option[String]]("profile_pic_url", O.Default(None))
    /** Database column time_zone SqlType(varchar), Default(None) */
    val timeZone: Rep[Option[String]] = column[Option[String]]("time_zone", O.Default(None))
    /** Database column deleted_at SqlType(timestamp), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column profile_image_file_name SqlType(varchar), Default(None) */
    val profileImageFileName: Rep[Option[String]] = column[Option[String]]("profile_image_file_name", O.Default(None))
    /** Database column profile_image_content_type SqlType(varchar), Default(None) */
    val profileImageContentType: Rep[Option[String]] = column[Option[String]]("profile_image_content_type", O.Default(None))
    /** Database column profile_image_file_size SqlType(int4), Default(None) */
    val profileImageFileSize: Rep[Option[Int]] = column[Option[Int]]("profile_image_file_size", O.Default(None))
    /** Database column profile_image_updated_at SqlType(timestamp), Default(None) */
    val profileImageUpdatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("profile_image_updated_at", O.Default(None))
    /** Database column google_calendar_credentials SqlType(varchar), Default(None) */
    val googleCalendarCredentials: Rep[Option[String]] = column[Option[String]]("google_calendar_credentials", O.Default(None))
    /** Database column current_city SqlType(varchar), Default(None) */
    val currentCity: Rep[Option[String]] = column[Option[String]]("current_city", O.Default(None))
    /** Database column current_state SqlType(varchar), Default(None) */
    val currentState: Rep[Option[String]] = column[Option[String]]("current_state", O.Default(None))
    /** Database column featured SqlType(int4), Default(None) */
    val featured: Rep[Option[Int]] = column[Option[Int]]("featured", O.Default(None))
    /** Database column invited_emails SqlType(varchar), Default(None) */
    val invitedEmails: Rep[Option[String]] = column[Option[String]]("invited_emails", O.Default(None))
    /** Database column invite_password SqlType(varchar), Default(None) */
    val invitePassword: Rep[Option[String]] = column[Option[String]]("invite_password", O.Default(None))
    /** Database column animated_gif_file_name SqlType(varchar), Default(None) */
    val animatedGifFileName: Rep[Option[String]] = column[Option[String]]("animated_gif_file_name", O.Default(None))
    /** Database column animated_gif_content_type SqlType(varchar), Default(None) */
    val animatedGifContentType: Rep[Option[String]] = column[Option[String]]("animated_gif_content_type", O.Default(None))
    /** Database column animated_gif_file_size SqlType(int4), Default(None) */
    val animatedGifFileSize: Rep[Option[Int]] = column[Option[Int]]("animated_gif_file_size", O.Default(None))
    /** Database column animated_gif_updated_at SqlType(timestamp), Default(None) */
    val animatedGifUpdatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("animated_gif_updated_at", O.Default(None))

    /** Uniqueness Index over (email) (database name index_users_on_email) */
    val index1 = index("index_users_on_email", email :: HNil, unique = true)
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag ⇒ new Users(tag))
}
