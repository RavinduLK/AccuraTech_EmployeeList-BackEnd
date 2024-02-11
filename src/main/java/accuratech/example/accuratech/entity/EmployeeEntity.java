package accuratech.example.accuratech.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {

    //Creation of Employee Entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String summary;
    private String dob;
    private String dsDivision;
}
