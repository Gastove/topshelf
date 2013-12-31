package com.gastove.topshelf.models

import org.squeryl.KeyedEntity
import System.currentTimeMillis
import java.sql.Timestamp
import org.squeryl.PrimitiveTypeMode._
import org.squeryl._
import scala.reflect.runtime.{ universe => ru }
import scala.reflect.ClassTag

abstract class BaseEntity extends KeyedEntity[Long] {
  val id: Long = 0
  val created_on: Timestamp = new Timestamp(currentTimeMillis)
  val updated_on: Timestamp = new Timestamp(currentTimeMillis)
}

abstract class DAO[T <: BaseEntity](theTable: Table[T])
  (implicit tt: ru.TypeTag[T], ct: ClassTag[T]) {

  def table = theTable

  def check() = {
    val m = ru.runtimeMirror(getClass.getClassLoader)
    val reflectedClass = ru.typeOf[T].typeSymbol.asClass
    val ctor = tt.tpe.declaration(ru.nme.CONSTRUCTOR).asMethod
    val cm = m.reflectClass(reflectedClass)
    val ctorm = cm.reflectConstructor(ctor)
    ctorm("Booker's", "whiskey", 1, None)
  }

  def getAll[T <: KeyedEntity[Long]]() = {
    from(table)( mod => select(mod)).toList
  }
  def getByID(id: String) = {
    from(table)( mod => where(mod.id === id.toInt) select(mod)).toList
  }

  def deleteByID(id: String) = {
    table.deleteWhere(row => row.id === id.toInt)
  }

  def create(obj: T) = {
    table.insert(obj)
  }

  def update(id: String, obj: T) = {
    table.update(obj)
  }
}
