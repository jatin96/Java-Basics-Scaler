package com.example.simpleservermaven.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Task {
    int id;
    private String name;
    private boolean completed;
    private Date dueBy;
}
