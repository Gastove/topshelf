package com.gastove.topshelf.conf.schema

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.annotations.Column
// import java.util.Date
// import java.sql.Timestamp
import org.squeryl.KeyedEntity
import com.gastove.topshelf.models.{Spirit, Liquer}


object TheShelf extends Schema {

  val spirits = table[Spirit]("spirits")
  val liquers = table[Liquer]("liquers")

}
