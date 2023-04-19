package lk.ijse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnPaidTM {
    private String stID;
    private String stName;
    private String resID;
    private String toPaid;

}
