package com.gastove.topshelf.models

import org.squeryl.KeyedEntity

case class Spirit(
  val name: String,
  val spirit_type: String,
  val quantity: Int,
  val producer: Option[String]
) extends KeyedEntity[Long] {
  def this() = this("", "", 1, Some(""))
  val id: Long = 0
}
