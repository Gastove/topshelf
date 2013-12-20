package com.gastove.topshelf.models

import org.squeryl.KeyedEntity
import System.currentTimeMillis
import java.sql.Timestamp

class BaseEntity extends KeyedEntity[Long] {
  val id: Long = 0
  val created_on: Timestamp = new Timestamp(currentTimeMillis)
  val updated_on: Timestamp = new Timestamp(currentTimeMillis)
}
