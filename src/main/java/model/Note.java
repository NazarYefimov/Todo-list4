package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String content;

    // Оголошення змінної empty
    private boolean empty;

    public Note(Object ignoredId, String ignoredNewNote, String ignoredNewContent) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Використання змінної empty в методі isEmpty()
    public boolean isEmpty() {
        return empty;
    }
}