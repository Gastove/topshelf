package com.gastove.topshelf

import org.scalatra._
import org.scalatra.json._
// import scalate.ScalateSupport
import com.gastove.topshelf.conf.schema.TheShelf
import com.gastove.topshelf.conf.database.DatabaseSessionSupport
import com.gastove.topshelf.models._
import org.json4s.{DefaultFormats, Formats}


class TopShelfServlet extends TopshelfStack
    with DatabaseSessionSupport with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }
  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

  get("/db-init/") {
      TheShelf.create
  }

  get("/load-test-data/") {
    TheShelf.spirits.insert(List(
      Spirit("Booker's", "whiskey", 1, None),
      Spirit("Hendricks", "gin", 2, Some("Hendricks")),
      Spirit("Appleton Estate", "rum", 1, None)
    ))

    TheShelf.liquers.insert(List(
      Liquer("Strega", 1, None, Option("Herbal, Sweet")),
      Liquer("Cinzano", 1, Option("Vermouth"), Option("off-sweet, cheap"))
    ))
  }

}
