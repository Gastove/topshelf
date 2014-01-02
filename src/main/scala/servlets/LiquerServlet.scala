package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.ActionResult._
import com.gastove.topshelf.models._
import org.squeryl.PrimitiveTypeMode._

class LiquersServlet extends CRUDRoutes[Liquer](LiquerDAO) {

  // TODO: Abstract this!
  // Update method
  put("/:id") {
    val newInfo = parsedBody.extract[Liquer]
    update(LiquerDAO.table)(r =>
      where(r.id === params("id").toInt)
        set(
          r.name := newInfo.name,
          r.quantity := newInfo.quantity,
          r.family := newInfo.family,
          r.tags := newInfo.tags
        )
    ) match {
      case 1 => Ok()
      case 0 => NotFound(reason = "No liquer found for ID: " + params("id"))
    }
  }

  get("/insert-test-data") {
    LiquerDAO.table.insert(List(
      Liquer("Strega", 1, None, Some("herbal")),
      Liquer("Cinzano", 1, Some("Vermouth"), Some("sweet, red")),
      Liquer("Amaro Sibilla", 2, Some("Amari"), Some("bitter"))
    ))

  }

}
