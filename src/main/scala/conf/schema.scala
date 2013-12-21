package com.gastove.topshelf.conf.schema

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import com.gastove.topshelf.models.{Spirit, Liquer}

object TheShelf extends Schema {

  val spirits = table[Spirit]("spirits")
  val liquers = table[Liquer]("liquers")

  on(spirits) (s => declare(
    s.id is(autoIncremented, named("spirit_id")),
    s.name is(indexed)
  ))

  on(liquers) (l => declare(
    l.id is(named("liquer_id"), autoIncremented),
    l.name is(indexed)
  ))

}
