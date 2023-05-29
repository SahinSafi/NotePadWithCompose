package com.safi.notepadwithcompose.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safi.notepadwithcompose.repository.RoomRepository
import com.safi.notepadwithcompose.room_db.entity.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RoomRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState<Any>>(HomeUiState.RoomResponse(listOf()))
    val uiState: StateFlow<HomeUiState<Any>> get() = _uiState

    val action : (HomeUiAction) -> Unit

    init {
        action = {
            when(it) {
                is HomeUiAction.GetAllNotes -> getAllNotes()
            }
        }
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            repository.getAllNotes().collect{
                _uiState.value = HomeUiState.RoomResponse(it)
            }
        }
    }
}

sealed class HomeUiState<out R>{
    data class RoomResponse(val data : List<NoteEntity>): HomeUiState<RoomResponse>()
}

sealed class HomeUiAction{
    object GetAllNotes : HomeUiAction()
}