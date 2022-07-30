package com.example.taskmanmaven.notes;

import com.example.taskmanmaven.tasks.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {
    List<NoteEntity> getNotesForTask(TaskEntity task);
    void addNoteToTask(TaskEntity task, NoteEntity note);
    void deleteNote(Long id);
}
