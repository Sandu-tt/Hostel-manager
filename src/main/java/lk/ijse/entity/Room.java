package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lk.ijse.dto.RoomDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Room {
    @Id
    @Column(nullable = false)
    private String roomID;
    private String type;
    private double keyMoney;
    private int qty;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservationList = new ArrayList<>();

    public Room(String id, String type, double keyMoney, int qty) {
        this.roomID = id;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }


    public RoomDTO toRoomDTO() {
        return new RoomDTO(this.roomID, this.type, this.keyMoney, this.qty);
    }
}
