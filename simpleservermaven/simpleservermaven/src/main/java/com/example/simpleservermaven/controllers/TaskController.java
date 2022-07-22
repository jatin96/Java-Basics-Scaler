package com.example.simpleservermaven.controllers;

import com.example.simpleservermaven.dto.ErrorResponse;
import com.example.simpleservermaven.dto.SuccessResponse;
import com.example.simpleservermaven.dto.TaskResponse;
import com.example.simpleservermaven.dto.TaskResponse;
import com.example.simpleservermaven.models.Task;
import com.example.simpleservermaven.services.TaskService;
import com.sun.net.httpserver.Authenticator;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired private TaskService taskService;
    @GetMapping("")
    public ResponseEntity<TaskResponse> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(new TaskResponse(tasks.size(), tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteTaskById(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(new SuccessResponse("Task no = " + id + " deleted"), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public String createTask(@RequestBody String task) {
        return "TODO: Create task = " + task;
    }

    @PatchMapping("/{id}")
    public String updateTask(@PathVariable("id") String id, @RequestBody String task) {
        return "TODO: Update task no = " + id + " with task = " + task;
    }

    @ExceptionHandler(TaskService.TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }



}
