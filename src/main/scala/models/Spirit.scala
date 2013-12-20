package com.gastove.topshelf.models

import org.squeryl.annotations.Column

case class Spirit(
  val name: String,
  @Column("spirit_type") val spiritType: String,
  val quantity: Int,
  val producer: Option[String]
) extends BaseEntity {
  def this() = this("", "", 1, Some(""))
}
