package com.example.taskmanmaven.notes;

import com.example.taskmanmaven.tasks.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findAllByTaskId(Long taskId);
}
