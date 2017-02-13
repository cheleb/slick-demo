package slickdemo.model
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
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Address.schema ++ Person.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Address
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param street1 Database column street1 SqlType(text)
   *  @param street2 Database column street2 SqlType(text), Default(None)
   *  @param street3 Database column street3 SqlType(text), Default(None)
   *  @param zip Database column zip SqlType(text)
   *  @param city Database column city SqlType(text)
   *  @param country Database column country SqlType(text)
   *  @param state Database column state SqlType(text), Default(None) */
  case class AddressRow(id: java.util.UUID, street1: String, street2: Option[String] = None, street3: Option[String] = None, zip: String, city: String, country: String, state: Option[String] = None)
  /** GetResult implicit for fetching AddressRow objects using plain SQL queries */
  implicit def GetResultAddressRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Option[String]]): GR[AddressRow] = GR{
    prs => import prs._
    AddressRow.tupled((<<[java.util.UUID], <<[String], <<?[String], <<?[String], <<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table address. Objects of this class serve as prototypes for rows in queries. */
  class Address(_tableTag: Tag) extends profile.api.Table[AddressRow](_tableTag, "address") {
    def * = (id, street1, street2, street3, zip, city, country, state) <> (AddressRow.tupled, AddressRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(street1), street2, street3, Rep.Some(zip), Rep.Some(city), Rep.Some(country), state).shaped.<>({r=>import r._; _1.map(_=> AddressRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6.get, _7.get, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column street1 SqlType(text) */
    val street1: Rep[String] = column[String]("street1")
    /** Database column street2 SqlType(text), Default(None) */
    val street2: Rep[Option[String]] = column[Option[String]]("street2", O.Default(None))
    /** Database column street3 SqlType(text), Default(None) */
    val street3: Rep[Option[String]] = column[Option[String]]("street3", O.Default(None))
    /** Database column zip SqlType(text) */
    val zip: Rep[String] = column[String]("zip")
    /** Database column city SqlType(text) */
    val city: Rep[String] = column[String]("city")
    /** Database column country SqlType(text) */
    val country: Rep[String] = column[String]("country")
    /** Database column state SqlType(text), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Default(None))
  }
  /** Collection-like TableQuery object for table Address */
  lazy val Address = new TableQuery(tag => new Address(tag))

  /** Entity class storing rows of table Person
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param title Database column title SqlType(text)
   *  @param lastname Database column lastname SqlType(text)
   *  @param firstname Database column firstname SqlType(text)
   *  @param birthDate Database column birth_date SqlType(date), Default(None)
   *  @param addressId Database column address_id SqlType(uuid), Default(None) */
  case class PersonRow(id: java.util.UUID, title: String, lastname: String, firstname: String, birthDate: Option[java.sql.Date] = None, addressId: Option[java.util.UUID] = None)
  /** GetResult implicit for fetching PersonRow objects using plain SQL queries */
  implicit def GetResultPersonRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Option[java.sql.Date]], e3: GR[Option[java.util.UUID]]): GR[PersonRow] = GR{
    prs => import prs._
    PersonRow.tupled((<<[java.util.UUID], <<[String], <<[String], <<[String], <<?[java.sql.Date], <<?[java.util.UUID]))
  }
  /** Table description of table person. Objects of this class serve as prototypes for rows in queries. */
  class Person(_tableTag: Tag) extends profile.api.Table[PersonRow](_tableTag, "person") {
    def * = (id, title, lastname, firstname, birthDate, addressId) <> (PersonRow.tupled, PersonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(title), Rep.Some(lastname), Rep.Some(firstname), birthDate, addressId).shaped.<>({r=>import r._; _1.map(_=> PersonRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column title SqlType(text) */
    val title: Rep[String] = column[String]("title")
    /** Database column lastname SqlType(text) */
    val lastname: Rep[String] = column[String]("lastname")
    /** Database column firstname SqlType(text) */
    val firstname: Rep[String] = column[String]("firstname")
    /** Database column birth_date SqlType(date), Default(None) */
    val birthDate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("birth_date", O.Default(None))
    /** Database column address_id SqlType(uuid), Default(None) */
    val addressId: Rep[Option[java.util.UUID]] = column[Option[java.util.UUID]]("address_id", O.Default(None))

    /** Foreign key referencing Address (database name person_address_id_fkey) */
    lazy val addressFk = foreignKey("person_address_id_fkey", addressId, Address)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Person */
  lazy val Person = new TableQuery(tag => new Person(tag))
}
