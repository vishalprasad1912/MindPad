package com.example.mindpad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindpad.view.screens.HomeScreen
import com.example.mindpad.view.theme.MindPadTheme
import com.example.mindpad.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MindPadTheme {
                Surface {
                    val noteViewModel: NoteViewModel = viewModel()
                    HomeScreen(viewModel = noteViewModel)
                }
            }
        }
    }
}