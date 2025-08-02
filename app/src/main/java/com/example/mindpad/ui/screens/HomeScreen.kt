package com.example.mindpad.ui.screens

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindpad.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var isNotePresent by remember { mutableStateOf(false) }
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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
//                .background(color = Color.Blue)
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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





@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}