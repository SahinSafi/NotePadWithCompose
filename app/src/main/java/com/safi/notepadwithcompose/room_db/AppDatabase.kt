package com.safi.notepadwithcompose.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.safi.notepadwithcompose.room_db.dao.NoteDao
import com.safi.notepadwithcompose.room_db.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao():NoteDao
}