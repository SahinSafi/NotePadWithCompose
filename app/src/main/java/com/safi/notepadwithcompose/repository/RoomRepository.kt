package com.safi.notepadwithcompose.repository

import com.safi.notepadwithcompose.room_db.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface RoomRepository {

    suspend fun insertNote(noteEntity: NoteEntity)

    fun getAllNotes(): Flow<List<NoteEntity>>

}