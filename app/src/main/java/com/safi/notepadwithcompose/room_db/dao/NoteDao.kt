package com.safi.notepadwithcompose.room_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.safi.notepadwithcompose.room_db.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNote()

    @Query("SELECT * FROM notes ORDER by id DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("DELETE FROM notes WHERE id =:id")
    suspend fun deleteSingleNote(id:Int)
}