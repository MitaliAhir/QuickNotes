package com.example.quicknotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicknotes.navigation.AppNavHost
import com.example.quicknotes.screens.HomeScreen
import com.example.quicknotes.ui.theme.QuickNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickNotesTheme {
              QuickNoteApp()
            }
        }
    }

}
@Composable
fun QuickNoteApp(){
    val notes = remember { mutableStateListOf<Note>() }
    var noteIdCounter = remember { mutableIntStateOf(notes.size) }

    AppNavHost(notes, noteIdCounter)
}


@Preview(showBackground = true)
@Composable
fun QuickNotesPreview() {
    QuickNotesTheme {
        QuickNoteApp()
    }
}