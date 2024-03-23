package kg.tenir.diploma.service.impl;

import io.minio.MinioClient;
import kg.tenir.diploma.dto.DiplomaDto;
import kg.tenir.diploma.entity.Diploma;
import kg.tenir.diploma.entity.Student;
import kg.tenir.diploma.repository.DiplomaRepository;
import kg.tenir.diploma.repository.StudentRepository;
import kg.tenir.diploma.service.DiplomaService;
import kg.tenir.diploma.service.props.MinioProperties;
import kg.tenir.diploma.utils.WordDocumentParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiplomaServiceImpl implements DiplomaService {
    private final DiplomaRepository diplomaRepository;
    private final StudentRepository studentRepository;
//    private final MinioClient minioClient;
//    private final MinioProperties minioProperties;
    private final String DIRECTORY_PATH = "/Users/aitenirzhamakeev/Desktop/theses/";

    @Override
    public List<DiplomaDto> getDiplomas() {
        return diplomaRepository.getDiplomaList();
    }

    @Override
    public Diploma findById(long id) {
        Optional<Diploma> diploma = diplomaRepository.findById(id);

        return diploma.orElse(null);
    }

    @Override
    public List<Diploma> findByKeyWord(String keyword) {
        return diplomaRepository.findByKeyWord(keyword);
    }

    @Override
    public void addDiploma(String title, Long student_id, Date year_of_publication, MultipartFile file) throws Exception {
        Student student = studentRepository.findById(student_id);

        String originalFileName = file.getOriginalFilename();

        assert originalFileName != null;
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String year = df.format(year_of_publication);

        String newFileName = "%s_%d_%s_%s".formatted(
                year,
                student_id,
                student.getF_name(),
                student.getL_name()
        );

        File newFile = new File(DIRECTORY_PATH + newFileName + extension);
        file.transferTo(newFile);

        String content = WordDocumentParser.parse(newFile);

        Diploma diploma = new Diploma();

        diploma.setTitle(title);
        diploma.setStudent(student);
        diploma.setYear_of_publication(year_of_publication);
        diploma.setFilePath(newFile.getPath());
        diploma.setContent(content);

        diplomaRepository.save(diploma);

    }
}
