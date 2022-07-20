package com.example.simpleservermaven.dto;

import com.example.simpleservermaven.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskResponse {
    private int taskCount;
    private List<Task> task;
}
