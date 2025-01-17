package com.example.quicknotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import com.example.quicknotes.Note
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quicknotes.screens.HomeScreen
import com.example.quicknotes.screens.NoteScreen

@Composable
fun AppNavHost(notes: SnapshotStateList<Note>, noteIDCounter: MutableIntState) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                notes,
                onNoteClicked = { note -> navController.navigate("edit_note/${note.id}" )},
                onCreateNoteClicked = { navController.navigate("create_note") })
        }
        composable("create_note") {
            NoteScreen(
                save = { note ->
                    notes.add(note.copy(noteIDCounter.intValue++))
                    navController.popBackStack()
                },
                cancel = { navController.popBackStack() },
                note = null
            )
        }
        composable("edit_note/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")?.toInt() ?: -1
            val note = notes.find { it.id == noteId }
            if (note != null) {
                NoteScreen(
                    note = note,
                    save = { updatedNote ->
                        note.title = updatedNote.title
                        note.content = updatedNote.content
                        navController.popBackStack()
                    },
                    cancel = { navController.popBackStack() }
                )
            }
        }
    }
}
