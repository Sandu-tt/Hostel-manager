package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lk.ijse.dto.ReservationDTO;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Reservation {
    @Id
    @Column(nullable = false)
    private String id;
    private LocalDate fromDate;
    private LocalDate toDate;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stID", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "roomID", nullable = false)
    private Room room;
    private String status;
    private double paid;
    private double toPaid;


    public ReservationDTO toReservationDTO() {
        System.out.println("dsdsd");
        System.out.println(this.id);
        return new ReservationDTO(this.id, this.fromDate, this.toDate, this.student.toStudentDTO(), this.room.toRoomDTO(), this.status, this.paid, this.toPaid);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getToPaid() {
        return toPaid;
    }

    public void setToPaid(double toPaid) {
        this.toPaid = toPaid;
    }
}
