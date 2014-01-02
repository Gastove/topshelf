package com.gastove.topshelf.models

import com.gastove.topshelf.conf.schema.TheShelf

case class Liquer(
  val name: String,
  val quantity: Int,
  val family: Option[String],
  val tags: Option[String]
) extends BaseEntity

object LiquerDAO extends DAO[Liquer](TheShelf.liquers)
