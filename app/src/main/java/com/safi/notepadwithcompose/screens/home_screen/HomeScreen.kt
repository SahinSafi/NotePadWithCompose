package com.safi.notepadwithcompose.screens.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.safi.notepadwithcompose.R
import com.safi.notepadwithcompose.common_ui.CommonToolBar

@Composable
fun HomeScreen(onClickAddIcon:()-> Unit, viewModel: HomeViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        val uiState by viewModel.uiState.collectAsState()
        LaunchedEffect(key1 = true, block = {
            viewModel.action(HomeUiAction.GetAllNotes)
        })

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            CommonToolBar(title = "Home")
            LazyColumn {
                items((uiState as HomeUiState.RoomResponse).data) { noteEntity ->
                    ItemNote(item = noteEntity)
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            onClick = { onClickAddIcon.invoke() }) {
            Icon(painter = painterResource(id = R.drawable.ic_add_24), contentDescription = "")
        }
    }
}