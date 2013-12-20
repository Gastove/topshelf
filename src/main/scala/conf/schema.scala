package com.gastove.topshelf.conf.schema

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import com.gastove.topshelf.models.{Spirit, Liquer}

object TheShelf extends Schema {

  val spirits = table[Spirit]("spirits")
  val liquers = table[Liquer]("liquers")

  on(spirits) (s => declare(
    s.id is(indexed("spirit_id")),
    s.name is(indexed)
  ))

  on(liquers) (l => declare(
    l.id is(indexed("liquer_id")),
    l.name is(indexed)
  ))

}
