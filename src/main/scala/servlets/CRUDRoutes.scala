package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.json._
import com.gastove.topshelf.models.{BaseEntity, DAO}
import com.gastove.topshelf.conf.database.DatabaseSessionSupport
import org.json4s.{DefaultFormats, Formats}
import grizzled.slf4j.Logging

// abstract class CRUDRoutes[K <: BaseEntity, T <: DAO[K]](theDAO: T) extends TopshelfStack
abstract class CRUDRoutes[+T <: BaseEntity](ControllerDAO: DAO[T]) extends TopshelfStack
    with DatabaseSessionSupport
    with JacksonJsonSupport
    with Logging {

  protected implicit val jsonFormats: Formats = DefaultFormats
  // lazy val ControllerDAO = theDAO

  before() {
    contentType = formats("json")
  }

  get("/") {
    ControllerDAO.getAll()
  }

  get("/:id") {}

  delete("/:id") {}

  post("/id") {}

}
