package com.example.mindpad.model.db.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "notes")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
)

/**
 * Repository that provides insert, update, delete, and retrieve of [Note] from a given data source.
 */
interface NotesRepository {
    /**
     * Retrieve all the notes from the the given data source.
     */
    fun getAllNotesStream(): Flow<List<Note>>

    /**
     * Retrieve an note from the given data source that matches with the [id].
     */
    fun getNoteStream(id: Int): Flow<Note?>

    /**
     * Insert note in the data source
     */
    suspend fun insertNote(note: Note)

    /**
     * Delete note from the data source
     */
    suspend fun deleteNote(note: Note)

    /**
     * Update note in the data source
     */
    suspend fun updateNote(note: Note)
}