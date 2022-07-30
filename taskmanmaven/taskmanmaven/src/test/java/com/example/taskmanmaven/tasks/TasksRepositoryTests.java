package com.example.taskmanmaven.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class TasksRepositoryTests {
    @Autowired TasksRepository tasksRepository;

    @Test
    void canCreateNewTaskTest() {
        tasksRepository.save(new TaskEntity("this is a sample task"));
    }

    @Test
    void canSaveAndRetrieveTask() {
        tasksRepository.save(new TaskEntity("this is another task"));
        TaskEntity task = tasksRepository.findById(2L).get();
        assert task.getName().equals("this is another task");
    }
}
