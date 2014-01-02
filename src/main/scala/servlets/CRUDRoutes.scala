package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.json._
import org.scalatra.ActionResult._
import com.gastove.topshelf.models.{BaseEntity, DAO}
import com.gastove.topshelf.conf.database.DatabaseSessionSupport
import org.json4s.{DefaultFormats, Formats}
import grizzled.slf4j.Logging
import scala.reflect.runtime.{ universe => ru }
import scala.reflect.ClassTag

abstract class CRUDRoutes[+T <: BaseEntity](ControllerDAO: DAO[T])
  (implicit tt: ru.TypeTag[T], ct: ClassTag[T])
    extends TopshelfStack
    with MethodOverride
    with DatabaseSessionSupport
    with JacksonJsonSupport
    with Logging {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  // Get all
  get("/") {
    ControllerDAO.getAll()
  }

  // Get by ID
  get("/:id") {
    ControllerDAO.getByID(params("id"))
  }

  // Delete by ID
  delete("/:id") {
    ControllerDAO.deleteByID(params("id"))
    NoContent()
  }

  // Add new
  post("/") {
    info("Received incoming parsed body:")
    info(parsedBody)
    ControllerDAO.create(parsedBody.extract[T])
  }

  // Update by ID -- Can't get the damn thing working.
  // For now, implement in each controller.

  // put("/:id") {
  //   ControllerDAO.update(params("id"), parsedBody.extract[T])
  // }

}
