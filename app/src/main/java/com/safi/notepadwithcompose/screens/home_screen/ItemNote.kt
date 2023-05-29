package com.safi.notepadwithcompose.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safi.notepadwithcompose.room_db.entity.NoteEntity

@Composable
fun ItemNote(item : NoteEntity) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .padding(top = 8.dp, bottom = 8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = item.title, fontSize = 14.sp)
            Text(text = item.note, fontSize = 12.sp)
        }
    }
}