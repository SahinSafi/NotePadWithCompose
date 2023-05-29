package com.safi.notepadwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.safi.notepadwithcompose.screens.add_note_screen.AddNoteScreen
import com.safi.notepadwithcompose.screens.home_screen.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreens.homeScreen()) {
        composable(NavScreens.homeScreen()) {
            HomeScreen(onClickAddIcon = {navController.navigate(NavScreens.addNoteScreen())})
        }

        composable(route = NavScreens.addNoteScreen()) {
            AddNoteScreen(onClickBackButton = {
                navController.popBackStack()
            })
        }
    }
}