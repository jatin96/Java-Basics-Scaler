package com.example.simpleservermaven.services;

import com.example.simpleservermaven.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceTestImpl implements TaskService {

    private List<Task> taskList;

    public TaskServiceTestImpl() {
        taskList = new ArrayList<>();
        taskList.add(new Task(1, "test sample task", false, new Date()));
        taskList.add(new Task(2, "test sample task", false, new Date()));
        taskList.add(new Task(3, "test sample task", false, new Date()));

    }
    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public Task getTaskById(Integer id) {
        return null;
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(int id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(int id) {
        return;
    }
}
