package lk.ijse.dto;

import lk.ijse.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO extends SuperDTO implements Serializable {
    private String id;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

    public Student toStudent() {
        return new Student(this.id, this.name, this.address, this.contact, this.dob, this.gender);
    }
}
