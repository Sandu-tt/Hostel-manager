package lk.ijse.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistoryTM {
    private String id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String studentID;
    private String roomTypeId;
    private double keyMoney;
    private double payingAmount;
    private String status;
    private JFXButton btn;
}
