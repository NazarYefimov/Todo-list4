package com.example.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    NoteControllerTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setUp() {
        // Можливо, тут потрібно додаткові підготовки перед тестами
    }

    @Test
    void listAllNotes() {
        // ... (решта вашого тестового коду)
    }

    @Test
    void addNote() {
        // ... (решта вашого тестового коду)
    }

}