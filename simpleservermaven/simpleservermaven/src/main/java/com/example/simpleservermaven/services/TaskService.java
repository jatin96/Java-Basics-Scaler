package com.example.simpleservermaven.services;

import com.example.simpleservermaven.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Integer id);
    Task createTask(Task task);
    Task updateTask(int id, Task task);
    void deleteTask(int id);

    class TaskNotFoundException extends RuntimeException {
        public TaskNotFoundException(int id) {
            super("Could not find task" + id);
        }
    }

}
