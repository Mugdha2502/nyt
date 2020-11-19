package com.example.nyt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_query")
class Search(
    @PrimaryKey
    val query: String,
    val dateSearchedOn: Long
)
