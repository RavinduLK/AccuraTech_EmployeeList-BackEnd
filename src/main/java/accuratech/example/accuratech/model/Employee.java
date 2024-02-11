package accuratech.example.accuratech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    //creation of model
    private long id;
    private String firstName;
    private String lastName;
    private String summary;
    private String dob;
    private String dsDivision;
}
