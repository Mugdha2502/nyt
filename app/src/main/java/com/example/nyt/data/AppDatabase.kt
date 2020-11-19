package com.example.nyt.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Search::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDAO(): SearchDAO
}
