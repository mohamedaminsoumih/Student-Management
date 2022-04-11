package ma.enset.studentmanagement;

import ma.enset.studentmanagement.entities.Student;
import ma.enset.studentmanagement.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student(null, "Soumih", "Amin", new Date(), "amine@gmail.com", Student.Gender.Gender1, false));
            studentRepository.save(new Student(null, "Ouabdi", "Ikram", new Date(), "ikram@gmail.com", Student.Gender.Gender2, true));
            studentRepository.save(new Student(null, "Lebouiz", "Yassine", new Date(), "yassine@gmail.com", Student.Gender.Gender1, false));
            studentRepository.save(new Student(null, "Elmourabite", "Hajar", new Date(), "hajar@gmail.com", Student.Gender.Gender2, true));
            studentRepository.save(new Student(null, "Elomari", "Moustapha", new Date(), "moustapha@gmail.com", Student.Gender.Gender1, false));
            studentRepository.save(new Student(null, "Farhat", "Imane", new Date(), "imane@gmail.com", Student.Gender.Gender2, true));
            studentRepository.save(new Student(null, "Abraich", "Ayoub", new Date(), "ayoub@gmail.com", Student.Gender.Gender1, false));
            studentRepository.save(new Student(null, "Essafi", "Leila", new Date(), "leila@gmail.com", Student.Gender.Gender2, true));
            studentRepository.save(new Student(null, "Naciri", "Soufiane", new Date(), "soufiane@gmail.com", Student.Gender.Gender1, false));
            studentRepository.save(new Student(null, "Faradi", "Houda", new Date(), "houda@gmail.com", Student.Gender.Gender2, true));


            studentRepository.findAll().forEach(student -> System.out.println(student.getLastName()));
        };

    }

}
