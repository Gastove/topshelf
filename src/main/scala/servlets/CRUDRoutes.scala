package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.json._
import com.gastove.topshelf.models.{BaseEntity, DAO}
import com.gastove.topshelf.conf.database.DatabaseSessionSupport
import org.json4s.{DefaultFormats, Formats}
import grizzled.slf4j.Logging

abstract class CRUDRoutes[+T <: BaseEntity](ControllerDAO: DAO[T]) extends TopshelfStack
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
  }

  // Add new
  post("/") {
    ControllerDAO.create(parsedBody.extract)
  }

  // Update by ID
  put("/:id") {
    ControllerDAO.update(params("id"), parsedBody.extract)
  }

}
