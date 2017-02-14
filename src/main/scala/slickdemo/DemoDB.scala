package slickdemo

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.PostgresProfile.api._
import slickdemo.model.Tables._

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


object DemoDB extends App {
  val db = Database.forConfig("slickdemo")

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
