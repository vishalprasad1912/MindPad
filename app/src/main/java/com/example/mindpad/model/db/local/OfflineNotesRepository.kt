package com.example.mindpad.model.db.local

import kotlinx.coroutines.flow.Flow

class OfflineNotesRepository(private val noteDAO: NoteDAO) : NotesRepository {

    override fun getAllNotesStream(): Flow<List<Note>> {
        return noteDAO.getAllNotes()
    }

    override fun getNoteStream(id: Int): Flow<Note?> {
        return noteDAO.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return noteDAO.insert(note)
    }

    override suspend fun deleteNote(note: Note) {
        return noteDAO.delete(note)
    }

    override suspend fun updateNote(note: Note) {
        return noteDAO.update(note)
    }
}