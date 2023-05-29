package com.safi.notepadwithcompose.repository

import com.safi.notepadwithcompose.room_db.dao.NoteDao
import com.safi.notepadwithcompose.room_db.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepoImpl @Inject constructor(
    private val noteDao: NoteDao
) : RoomRepository {
    override suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insertNote(noteEntity)
    }

    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }
}