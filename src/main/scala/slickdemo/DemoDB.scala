package slickdemo

import java.sql.Date
import java.util.UUID

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.PostgresProfile.api._
import slickdemo.model.Tables
import slickdemo.model.Tables._

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


object DemoDB extends App {

  val db = Database.forConfig("slickdemo")

  val schema = db.run(Tables.schema.create)

  Await.ready(schema, 2 seconds)

  Await.ready(db.run(Address += AddressRow(
    id=UUID.fromString("ecdc1828-b662-4ade-9719-e96ab91f75db"),
    street1 = "29, rue Adam de Craponne",
    zip = "34000",
    city = "Montpellier",
    country = "France"
  )), 2 seconds)

  Await.ready(db.run(Person+= PersonRow(
    id=UUID.fromString("6f68f015-7d19-4180-ba12-607e7af8509"),
    title = "Mme",
    lastname = "Meresse",
    firstname = "Agnès",
    birthDate = Some(new Date(1974,1,15)),
    addressId = Some(UUID.fromString("ecdc1828-b662-4ade-9719-e96ab91f75db"))
  )), 2 seconds)

  println("All Adresses:")

  val done1 = db.run(Address.result).map(_.foreach {
    case row => println(row)
  })

  Await.ready(done1, 2 seconds)

  val query = for {
    addresses <- Address
    person <- Person if addresses.id === person.addressId
  } yield (addresses, person.lastname)

  println("Adresses with inhabitants:")

  val done2 = db.stream(query.result).foreach {
    address =>
      println(address)
  }

  Await.ready(done2, 2 seconds)



}
