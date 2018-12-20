package com.example.thomasperrin.pokerhh.data.database

import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import com.example.thomasperrin.pokerhh.data.model.History

@Database(entities = [History::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllTables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    abstract fun historyDao(): HistoryDao


}