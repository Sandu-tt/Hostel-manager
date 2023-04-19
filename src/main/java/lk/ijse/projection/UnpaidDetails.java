package lk.ijse.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnpaidDetails {
    private String stID;
    private String name;
    private String contact;
    private String resID;
    private double toPaid;
}
