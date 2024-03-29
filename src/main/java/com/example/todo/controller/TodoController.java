/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.todo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoH2Service;

@RestController
public class TodoController {
    @Autowired
    public TodoH2Service todoService;

    @DeleteMapping("/todos/{id}")

    public void deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getById(@PathVariable("id") int id) {
        return todoService.getById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }
}