package com.gastove.topshelf.models

import org.squeryl.KeyedEntity

case class Liquer(
  val name: String,
  val quantity: Int,
  val family: Option[String],
  val tags: Option[String]
) extends BaseEntity {
  def this() = this("", 1, Some(""), Some(""))
}
