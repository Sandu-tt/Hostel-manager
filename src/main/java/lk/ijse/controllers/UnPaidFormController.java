package lk.ijse.controllers;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.projection.UnpaidDetails;
import lk.ijse.tm.UnPaidTM;

import java.util.List;

public class UnPaidFormController {
    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    public TableView<UnPaidTM> tblCart;
    public TableColumn<UnPaidTM, String> colStID;
    public TableColumn<UnPaidTM, String> colStName;
    public TableColumn<UnPaidTM, String> colResID;
    public TableColumn<UnPaidTM, String> colBalance;

    public void initialize() {
        tblCart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("stID"));
        tblCart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("stName"));
        tblCart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("resID"));
        tblCart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("toPaid"));

        List<UnpaidDetails> unpaidDetails = reservationBO.getUnpaidDetails();
        for (UnpaidDetails details : unpaidDetails) {
            tblCart.getItems().add(new UnPaidTM(details.getStID(), details.getName(), details.getResID(), String.valueOf(details.getToPaid())));
        }

    }
}
