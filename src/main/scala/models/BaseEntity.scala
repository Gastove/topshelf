package com.gastove.topshelf.models

import org.squeryl.KeyedEntity
import System.currentTimeMillis
import java.sql.Timestamp
import org.squeryl.PrimitiveTypeMode._
import org.squeryl._
import grizzled.slf4j.Logging

class BaseEntity extends KeyedEntity[Long] {
  val id: Long = 0
  val created_on: Timestamp = new Timestamp(currentTimeMillis)
  val updated_on: Timestamp = new Timestamp(currentTimeMillis)
}

trait ModelMethods extends Logging {
  def getAll[T](q: Table[T]) = {
    from(q)( mod => select(mod)).toList
  }

  def getByID[T <: BaseEntity](q: Table[T], id: String) = {
    from(q)( mod => where(mod.id === id.toInt) select(mod)).toList
  }

}
