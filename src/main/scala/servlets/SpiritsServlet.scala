package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.json._
import com.gastove.topshelf.conf.schema.TheShelf
import com.gastove.topshelf.conf.database.DatabaseSessionSupport
import com.gastove.topshelf.models._
import org.json4s.{DefaultFormats, Formats}
import org.squeryl.PrimitiveTypeMode._
import grizzled.slf4j.Logging

class SpiritsServlet extends TopshelfStack
    with DatabaseSessionSupport with JacksonJsonSupport
    with Logging with ModelMethods {

  protected implicit val jsonFormats: Formats = DefaultFormats
  val spiritsTable = TheShelf.spirits

  before() {
    contentType = formats("json")
  }

  get("/all") {
    getAll(spiritsTable)
  }

  get("/all/:id") {
    getByID(spiritsTable, params("id"))
  }

  get("/insert-test-data") {
    spiritsTable.insert(List(
      Spirit("Booker's", "whiskey", 1, None),
      Spirit("Hendricks", "gin", 2, Some("Hendricks")),
      Spirit("Appleton Estate", "rum", 1, None)
    ))
  }

}
