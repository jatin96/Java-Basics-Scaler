package com.example.simpleservermaven.services;

import com.example.simpleservermaven.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById();
    Task createTask(Task task);
    Task updateTask(int id, Task task);
    void deleteTask(int id);

}
