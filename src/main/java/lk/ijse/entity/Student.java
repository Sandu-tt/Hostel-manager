package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lk.ijse.dto.StudentDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @Column(nullable = false)
    private String stID;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public Student(String stID, String name, String address, String contact, LocalDate dob, String gender) {
        this.stID = stID;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }


    public StudentDTO toStudentDTO() {
        return new StudentDTO(this.stID, this.name, this.address, this.contact, this.dob, this.gender);

    }
}
