package com.example.quicknotes.screens

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.quicknotes.Note
import com.example.quicknotes.scaffold.FabButton
import com.example.quicknotes.scaffold.TopBar

@Composable
fun HomeScreen(notes: List<Note>, onNoteClicked: (Note) -> Unit, onCreateNoteClicked: () -> Unit) {
    Scaffold(
        topBar = {TopBar("QuickNotes")},
        floatingActionButton = {
            FabButton { onCreateNoteClicked() }
        }
    ) { innerPadding ->
        if (notes.isEmpty()) {
            Text(
                text = "No notes yet. Start by adding a new note.",
                modifier = Modifier.fillMaxSize().wrapContentHeight().wrapContentWidth(),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
        } else {
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(notes) { note ->
                    Card(
                        modifier = Modifier.padding(8.dp)
                            .clickable { onNoteClicked(note) }.width(300.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = note.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = note.content,
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }
    }
}