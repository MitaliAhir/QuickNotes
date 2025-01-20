package com.example.quicknotes.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun FabButton(onClick: () -> Unit){
    FloatingActionButton(
        onClick = onClick
    )
    {
        Icon(Icons.Default.Create, "Create Note button")
    }

}