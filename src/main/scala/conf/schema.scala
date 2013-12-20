package com.gastove.topshelf.conf.schema

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.annotations.Column
import java.util.Date
import java.sql.Timestamp

class Spirit(
  val id: Long,
  val name: String,
  val spirit_type: String,
  val quantity: Int,
  val producer: Option[String]
) {
  def this() = this(0, "", "", 1, Some(""))
}

class Liquer(
  val id: Long,
  val name: String,
  val quantity: Int
  val tags: Option[String]
) {
  def this() = this(0, "", 1, Some(""))
}

object TheShelf extends Schema {

  val spirits = table[Spirit]
  val liquers = table[Liquer]

}
