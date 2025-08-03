package com.example.mindpad

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindpad.view.screens.home.HomeScreen
import com.example.mindpad.viewmodel.NoteEntryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MindPadApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold,
//                        not working properly
//                        textAlign = Alignment.BottomStart
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            // TODO:
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_home_screen_grid),
                            contentDescription = stringResource(R.string.notes_grid)
                        )
                    }
                }
            )
        },

        bottomBar = {

        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // TODO:
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home_screen_floating_action_button),
                    contentDescription = stringResource(R.string.create_note),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

    ) { innerPadding ->
        val noteViewModel: NoteEntryViewModel = viewModel()
        HomeScreen(
            modifier = Modifier.padding(innerPadding),
            viewModel = noteViewModel,
        )
    }
}