package com.journaler.api.controller

import com.journaler.api.data.Todo
import com.journaler.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
@EnableAutoConfiguration
class TodoController {
    @Autowired
    private lateinit var service: TodoService
    /**
    * Loading tasks
    */
    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTodos() : List<Todo>  = service.getTodos()

    /**
     * Adding task
     * This method receives data, e.x. context of the task in JSON
     */
    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertTodo(@RequestBody todo: Todo): Todo = service.insertTodo(todo)

    /**
     * Deleting task with given ID
     * The path contains a variable which will receive task ID
     */
    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(@PathVariable(name = "id") id: String
    ): Boolean = service.deleteTodo(id)

    /**
     * Changing task
     * This method receives data, e.x. context of the task in JSON
     * and returns changed task
     */
    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(@RequestBody todo: Todo): Boolean = service.updateTodo(todo)
}