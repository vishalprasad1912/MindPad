package com.example.mindpad.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mindpad.model.db.local.Note
import com.example.mindpad.model.db.local.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteViewModel : ViewModel() {

    private val repository = NoteRepository()

    // Private mutable state flow that can be updated within the ViewModel
    private val _notes = MutableStateFlow<List<Note>>(emptyList())

    // Public immutable state flow that the UI can observe
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    init {
        // Load the notes when the ViewModel is created
        loadNotes()
    }

    private fun loadNotes() {
        _notes.value = repository.getNotes()
    }
}