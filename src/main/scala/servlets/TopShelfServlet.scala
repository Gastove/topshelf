package com.gastove.topshelf.servlets

import org.scalatra._
import org.scalatra.json._
import com.gastove.topshelf.conf.schema.TheShelf
import com.gastove.topshelf.conf.database.DatabaseSessionSupport
import com.gastove.topshelf.models._
import org.json4s.{DefaultFormats, Formats}
import org.squeryl.PrimitiveTypeMode._
import grizzled.slf4j.Logging

class TopShelfServlet extends TopshelfStack
    with DatabaseSessionSupport with JacksonJsonSupport
    with Logging {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Is this thing on?
      </body>
    </html>
  }

  get("/db-init/") {
      TheShelf.create
  }

  get("/load-test-data/") {
    TheShelf.liquers.insert(List(
      Liquer("Strega", 1, None, Option("Herbal, Sweet")),
      Liquer("Cinzano", 1, Option("Vermouth"), Option("off-sweet, cheap"))
    ))
  }



}
