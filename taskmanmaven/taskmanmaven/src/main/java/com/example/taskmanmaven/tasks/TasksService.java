package com.example.taskmanmaven.tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasksService {

    List<TaskEntity> getAllTasks();
    TaskEntity getTaskById(int id);
    void addTask(TaskEntity task);
    void updateTask(TaskEntity task);
    void deleteTask(int id);
}
