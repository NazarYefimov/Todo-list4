package repository;

import org.springframework.data.jpa.repository.JpaRepository;
public interface NoteRepository<Note> extends JpaRepository<Note, Long> {
}
