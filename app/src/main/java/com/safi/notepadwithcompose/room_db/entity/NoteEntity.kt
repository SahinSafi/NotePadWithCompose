package com.safi.notepadwithcompose.room_db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val title : String = "",
    val note : String = "",
)
