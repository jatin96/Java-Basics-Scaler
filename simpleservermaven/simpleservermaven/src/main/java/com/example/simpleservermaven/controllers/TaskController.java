package com.example.simpleservermaven.controllers;

import com.example.simpleservermaven.dto.TaskResponse;
import com.example.simpleservermaven.dto.TaskResponse;
import com.example.simpleservermaven.models.Task;
import com.example.simpleservermaven.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired private TaskService taskService;
    @GetMapping("")
    public TaskResponse getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new TaskResponse(tasks.size(), tasks);
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable("id") String id) {
        return "TODO: task no = " + id;
    }
}
