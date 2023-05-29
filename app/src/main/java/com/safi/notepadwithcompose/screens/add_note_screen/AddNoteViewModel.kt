package com.safi.notepadwithcompose.screens.add_note_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safi.notepadwithcompose.repository.RoomRepository
import com.safi.notepadwithcompose.room_db.entity.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val roomRepository: RoomRepository
) : ViewModel() {

    val action : (AddNoteUiAction) -> Unit

    init {
        action = {
            when(it) {
                is AddNoteUiAction.AddNote -> insertNote(it.noteEntity)
            }
        }
    }

    private fun insertNote(noteEntity: NoteEntity){
        viewModelScope.launch {
            roomRepository.insertNote(noteEntity)
        }
    }

}

sealed class AddNoteUiAction {
    data class AddNote(val noteEntity: NoteEntity) : AddNoteUiAction()
}