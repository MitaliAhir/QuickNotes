package com.example.quicknotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicknotes.ui.theme.QuickNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickNotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuickNote(Modifier.padding(innerPadding))
                }
            }
        }
    }


}
@Composable
fun QuickNote(modifier: Modifier){

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuickNotesTheme {

    }
}