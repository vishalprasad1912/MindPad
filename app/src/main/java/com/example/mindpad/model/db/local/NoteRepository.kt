package com.example.mindpad.model.db.local

data class Note (val title: String, val description: String)

class NoteRepository {
    fun getNotes() : List<Note> {
        return listOf(
            Note("First note", "This is the first note"),
            Note("Second note", "This is the second note"),
            Note("Third note", "This is the third note")
        )
    }
}