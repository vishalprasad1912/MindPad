package com.example.mindpad.model.db.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    //The argument onConflict tells the Room what to do in case of a conflict.
    //The OnConflictStrategy.IGNORE strategy ignores a new item.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE title = :title")
    fun getNoteByTitle(title: String) : Flow<Note>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int) : Flow<Note>

    @Query("SELECT * FROM notes ORDER BY title ASC")
    fun getAllNotes() : Flow<List<Note>>
}