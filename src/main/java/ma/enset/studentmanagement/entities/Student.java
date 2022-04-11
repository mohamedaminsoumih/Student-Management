package ma.enset.studentmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String email;
    private Gender gender;
    private boolean isInGoodStanding;

    public enum Gender {

        Gender1("MALE"),
        Gender2("FEMALE");
        private final String title;


        Gender(String g) {
            title = g;
        }

        public String toString() {
            return this.title;
        }
    }

}
