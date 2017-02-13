package slickdemo

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.PostgresProfile.api._
import slickdemo.model.Tables

object DemoDB extends App {
  val db = Database.forConfig("slickdemo")

  println("Adresses:")

  db.run(Tables.Address.result).map(_.foreach{
    case row => println(row)
  })

}
