package com.journaler.api.service

import com.journaler.api.data.Todo
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService {

    fun getTodos() : List<Todo> = listOf(
                Todo(
                        UUID.randomUUID().toString(),
                        "First task",
                        "This is the context of first task.",
                        System.currentTimeMillis()
                ),
                Todo(
                        UUID.randomUUID().toString(),
                        "Second task",
                        "This is the context of second task.",
                        System.currentTimeMillis()
                )
        )

    fun insertTodo(todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    fun deleteTodo(id: String): Boolean = false

    fun updateTodo(todo: Todo): Boolean = true
}