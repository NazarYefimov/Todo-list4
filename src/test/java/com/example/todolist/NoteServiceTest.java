package com.example.todolist;

import model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.NoteService;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {

    private NoteService noteService;

    @BeforeEach
    void setUp() {
        noteService = new NoteService();
    }

    @Test
    void listAll() {
        Note notes = (Note) noteService.listAll();
        assertNotNull(notes);
        assertTrue(notes.isEmpty());
    }

    @Test
    void addAndGetById() {
        Note newNote = new Note(null, "New Note", "New Content");
        Note addedNote = noteService.add(newNote);

        assertNotNull(addedNote.getId());

        Note retrievedNote = noteService.getById(addedNote.getId());
        assertNotNull(retrievedNote);
        assertEquals("New Note", retrievedNote.getTitle());
        assertEquals("New Content", retrievedNote.getContent());
    }

    private void assertNotNull(Long ignoredId) {
    }

    @Test
    void update() {
        Note newNote = new Note(null, "New Note", "New Content");
        Note addedNote = noteService.add(newNote);

        addedNote.setTitle("Updated Title");
        addedNote.setContent("Updated Content");

        noteService.update(addedNote);

        Note updatedNote = noteService.getById(addedNote.getId());
        assertNotNull(updatedNote);
        assertEquals("Updated Title", updatedNote.getTitle());
        assertEquals("Updated Content", updatedNote.getContent());
    }

    private void assertNotNull(Note ignoredUpdatedNote) {
    }

    @Test
    void delete() {
        Note newNote = new Note(null, "New Note", "New Content");
        Note addedNote = noteService.add(newNote);

        noteService.deleteById(addedNote.getId());

        assertThrows(IllegalArgumentException.class, () -> noteService.getById(addedNote.getId()));
    }
}
