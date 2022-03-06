package com.database

import java.io.File
import java.sql.Connection
import java.sql.DriverManager

class DatabaseConnection {

    private val databasePath = "../database/src/main/resources"
    private val databaseFileName = "acc.db"

    lateinit var connection: Connection
        private set

    init {
        connectDatabase()
    }

    private fun connectDatabase() {
        try {
            val file = File(databasePath)
            if (!file.exists()) {
                file.mkdir()
            }
            connection = DriverManager.getConnection("jdbc:sqlite:$databasePath/$databaseFileName")
        } catch (e: Exception) {
            println(e)
        } finally {
            connection.close()
        }
    }
}