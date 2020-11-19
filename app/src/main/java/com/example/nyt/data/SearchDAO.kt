package com.example.nyt.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
abstract class SearchDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(data: Search)

    @Insert
    abstract fun insertAll(vararg data: Search)

    @Delete
    abstract fun delete(data: Search)

}
