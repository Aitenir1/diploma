package kg.tenir.diploma.runner;

import kg.tenir.diploma.service.props.MinioProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DiplomaApplicationRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Your startup logic here
        MinioProperties minioProperties = new MinioProperties();
//        System.out.println(greatest);
        System.out.println("My application has started!");
    }
}
