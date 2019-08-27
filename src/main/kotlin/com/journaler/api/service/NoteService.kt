package com.journaler.api.service

import com.journaler.api.data.Note
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {

    fun getNotes(): List<Note> = listOf(
                    Note(
                            UUID.randomUUID().toString(),
                            "First note",
                            "This is the context of first note."
                    ),
                    Note(
                            UUID.randomUUID().toString(),
                            "Second note",
                            "This is the context of second note."
                    )
            )
    fun insertNote(note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }
    fun deleteNote(id: String): Boolean = false
    fun updateNote(note: Note): Boolean = true
}