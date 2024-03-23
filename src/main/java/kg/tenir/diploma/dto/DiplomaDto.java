package kg.tenir.diploma.dto;

import java.util.Date;

public class DiplomaDto {
    private long id;
    private String title;
    private long student_id;
    private long instructor_id;
    private Date year_of_publication;
    private String filePath;
    private String content;

    public DiplomaDto(long id, String title, long student_id, long instructor_id, Date year_of_publication, String filePath, String content) {
        this.id = id;
        this.title = title;
        this.student_id = student_id;
        this.instructor_id = instructor_id;
        this.year_of_publication = year_of_publication;
        this.filePath = filePath;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public Date getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(Date year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
