package com.gastove.topshelf.models

import org.squeryl.annotations.Column
import com.gastove.topshelf.conf.schema.TheShelf

case class Spirit(
  val name: String,
  @Column("spirit_type") val spiritType: String,
  val quantity: Int,
  val producer: Option[String]
) extends BaseEntity

object SpiritDAO extends DAO[Spirit](TheShelf.spirits)
