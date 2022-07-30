package com.example.taskmanmaven.notes;

import com.example.taskmanmaven.tasks.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    @Autowired
    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<NoteEntity> getNotesForTask(TaskEntity task) {
        return notesRepository.findAllByTaskId(task.getId());
    }

    @Override
    public void addNoteToTask(TaskEntity task, NoteEntity note) {
        note.setTask(task);
        notesRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        notesRepository.deleteById(id);
    }
}
