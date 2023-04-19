package lk.ijse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomTM implements Comparable<RoomTM> {
    private String id;
    private String type;
    private double keyMoney;
    private int qty;

    @Override
    public int compareTo(RoomTM o) {
        return id.compareTo(o.getId());
    }
}
