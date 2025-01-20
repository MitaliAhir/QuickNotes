package com.example.quicknotes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicknotes.Note
import com.example.quicknotes.scaffold.TopBar

@Composable
fun NoteScreen(note: Note?, save: (Note) -> Unit, cancel: () -> Unit) {
    var title by remember { mutableStateOf(note?.title ?: "")}
    var content by remember { mutableStateOf(note?.content ?:"")}

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = if(note != null) "Edit Note" else "Create Note") },

        ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
            TextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 16.dp)
            )

            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Button(
                    onClick = { cancel() },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    enabled = true,
                ) {
                    Text(text = "Cancel")
                }
                Button(
                    onClick = { save(Note(note?.id ?: -1, title, content)) },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    enabled = content.isNotBlank(),
                ) {
                    Text(text = "Done")
                }
            }
        }
    }
}
@Preview
@Composable
private fun NoteScreenPreview() {
    val notes = remember { mutableStateListOf<Note>() }
    var noteIdCounter by remember { mutableStateOf(0) }

    NoteScreen(
        save = { note -> notes.add(note.copy(id = noteIdCounter++)) },
        cancel = {},
        note = null
    )
}
