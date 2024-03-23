package kg.tenir.diploma.repository;

import jakarta.persistence.Id;
import kg.tenir.diploma.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Id> {
    Student findById(Long id);

}
