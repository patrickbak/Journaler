package com.journaler.api.controller

import com.journaler.api.data.Note
import com.journaler.api.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {
    //TODO ERROR WHILE TRYING TO INSERT NEW NOTE (ID PROPERTY IS NULL?)
    @Autowired
    private lateinit var service: NoteService
    /**
     * Loading notes
     */
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes() = service.getNotes()

    /**
     * Adding note
     * This method receives data, e.x. context of the note in JSON
     */
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody note: Note) = service.insertNote(note)

    /**
     * Deleting note
     * The path contains a variable which will receive note ID
     */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(@PathVariable(name = "id") id: String
    ): Boolean = service.deleteNote(id)

    /**
     * Changing note
     * This method receives data, e.x. context of the note in JSON
     * and returns changed note
     */
    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(@RequestBody note: Note): Boolean = service.updateNote(note)
}