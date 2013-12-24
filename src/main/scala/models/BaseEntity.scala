package com.gastove.topshelf.models

import org.squeryl.KeyedEntity
import System.currentTimeMillis
import java.sql.Timestamp
import org.squeryl.PrimitiveTypeMode._
import org.squeryl._
import grizzled.slf4j.Logging
import com.gastove.topshelf.conf.schema.TheShelf
import scala.reflect.runtime.universe.TypeTag
import scala.reflect.ClassTag

abstract class BaseEntity[T] extends KeyedEntity[Long] {
  val id: Long = 0
  val created_on: Timestamp = new Timestamp(currentTimeMillis)
  val updated_on: Timestamp = new Timestamp(currentTimeMillis)
}

abstract class DAO[T <: KeyedEntity[Long]](theTable: Table[T])
  (implicit tt: TypeTag[T], ct: ClassTag[T]) {

  def table = theTable

  def getAll[T <: KeyedEntity[Long]]() = {
    from(table)( mod => select(mod)).map{row => ct.runtimeClass(row)}.toList
  }
  def getByID(id: String) = {
    from(table)( mod => where(mod.id === id.toInt) select(mod)).toList
  }
}
