package kg.tenir.diploma.repository;

import jakarta.persistence.Id;
import kg.tenir.diploma.dto.DiplomaDto;
import kg.tenir.diploma.entity.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Id> {
    @Query(value = "SELECT * FROM diploma WHERE content_with_idx @@ to_tsquery('english', ?1)", nativeQuery = true)
    List<Diploma> findByKeyWord(String keyword);

    Optional<Diploma> findById(long id);

    @Query("SELECT new kg.tenir.diploma.dto.DiplomaDto(d.id, d.title, s.id, i.id, d.year_of_publication, d.filePath, d.content) FROM Diploma d JOIN d.student s JOIN d.instructor i")
    List<DiplomaDto> getDiplomaList();
}
