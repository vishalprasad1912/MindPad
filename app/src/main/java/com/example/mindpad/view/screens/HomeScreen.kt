package com.example.mindpad.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mindpad.R
import com.example.mindpad.model.db.local.Note
import com.example.mindpad.viewmodel.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: NoteViewModel, modifier: Modifier = Modifier) {
    val notes by viewModel.notes.collectAsState()

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
        Column(
            modifier = modifier
                .padding(innerPadding)
//                .fillMaxSize(),
        ) {
            if (notes.isEmpty()) {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Column {
                        Image(
                            painter = painterResource(R.drawable.image_home_screen_empty_notes),
                            contentDescription = stringResource(R.string.empty_notes)
                        )
                        Spacer(Modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.empty_notes_string),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
            else {
                LazyColumn(
                    modifier = modifier.fillMaxSize()
                ) {
                    items(notes) { note ->
                        NoteItem(note = note,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp, start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, modifier: Modifier) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                note.title, style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1, overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(2.dp))
            Text(
                note.description, style = MaterialTheme.typography.headlineSmall,
                maxLines = 3, overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
//    HomeScreen()
}