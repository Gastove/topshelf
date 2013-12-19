package com.gastove.topshelf.conf.database

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.squeryl.adapters.PostgreSqlAdapter
import org.squeryl.{Session, SessionFactory}

trait InitializeDatabase {

  val dbUser = "gastove"
  val dbPassword = ""
  val dbConnection = "jdbc:postgresql://localhost/topshelf"

  var cpds = new ComboPooledDataSource

  def configureDB() {
    cpds.setDriverClass("org.postgresql.Driver")
    cpds.setJdbcUrl(dbConnection)
    cpds.setUser(dbUser)
    cpds.setPassword(dbPassword)

    cpds.setMinPoolSize(1)
    cpds.setAcquireIncrement(1)
    cpds.setMaxPoolSize(50)

    SessionFactory.concreteFactory = Some( () => connection )

    def connection() = {
      Session.create(cpds.getConnection, new PostgreSqlAdapter)
    }
  }

  def closeDBConnection() {
    cpds.close()
  }
}
