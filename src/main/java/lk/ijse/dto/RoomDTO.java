package lk.ijse.dto;

import lk.ijse.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO extends SuperDTO {
    private String id;
    private String type;
    private double keyMoney;
    private int qty;

    public Room toRoom() {
        return new Room(this.id, this.type, this.keyMoney, this.qty);
    }
}
