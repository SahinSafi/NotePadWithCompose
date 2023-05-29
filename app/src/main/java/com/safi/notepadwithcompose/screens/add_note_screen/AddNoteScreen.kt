package com.safi.notepadwithcompose.screens.add_note_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.safi.notepadwithcompose.common_ui.CommonToolBar
import com.safi.notepadwithcompose.room_db.entity.NoteEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(onClickBackButton: () -> Unit, viewModel: AddNoteViewModel = hiltViewModel()) {
    var titleValue by remember { mutableStateOf("") }
    var noteValue by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            CommonToolBar(title = "Add Note", onClickBackButton = { onClickBackButton.invoke() })

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                value = titleValue,
                onValueChange = { titleValue = it },
                label = { Text(text = "Title") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                value = noteValue,
                onValueChange = {
                    noteValue = it
                },
                label = { Text(text = "Notes") },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start)
            )
        }

        Button(modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.BottomCenter),onClick = {
            viewModel.action(AddNoteUiAction.AddNote(NoteEntity(title = titleValue, note = noteValue)))
            onClickBackButton.invoke()
        }) {
            Text(text = "Apply")
        }
    }

}