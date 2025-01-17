package kg.tenir.diploma.service;

import kg.tenir.diploma.dto.DiplomaDto;
import kg.tenir.diploma.entity.Diploma;
import kg.tenir.diploma.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public interface DiplomaService {
    static void addNewStudent(Student student) {
        System.out.println("Hello! New student being added!");
        System.out.println(student);
    }

    List<DiplomaDto> getDiplomas();

    void addDiploma(String title, Long student, Date year_of_publication, MultipartFile file) throws Exception;

    Diploma findById(long id);

    List<Diploma> findByKeyWord(String keyword);
}
