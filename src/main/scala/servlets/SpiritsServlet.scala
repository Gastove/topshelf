package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.ActionResult._
import com.gastove.topshelf.models._
import org.squeryl.PrimitiveTypeMode._

class SpiritsServlet extends CRUDRoutes[Spirit](SpiritDAO) {

  // Looks like at the moment, each Servlet will need to define its own
  // update route. That's cool.
  put("/:id") {
    val newInfo = parsedBody.extract[Spirit]
    update(SpiritDAO.table)(r =>
      where(r.id === params("id").toInt)
        set(
          r.name := newInfo.name,
          r.quantity := newInfo.quantity,
          r.producer := newInfo.producer,
          r.spiritType := newInfo.spiritType
        )
    ) match {
      case 1 => Ok()
      case 0 => NotFound(reason = "No spirit found for ID: " + params("id"))
    }
  }

  // Test Data
  get("/insert-test-data") {
    SpiritDAO.table.insert(List(
      Spirit("Booker's", "whiskey", 1, None),
      Spirit("Hendricks", "gin", 2, Some("Hendricks")),
      Spirit("Appleton Estate", "rum", 1, None)
    ))
  }

}
