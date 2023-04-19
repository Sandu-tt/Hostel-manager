package lk.ijse.controllers;

import javafx.scene.control.TextField;
import lk.ijse.dto.ReservationDTO;

public class ReservationDataController {
    public TextField txtResiD;
    public TextField txtStAddress;
    public TextField txtStName;
    public TextField txtStContact;
    public TextField txtStGender;
    public TextField txtRoomID;
    public TextField txtRoomType;
    public TextField txtKeyMoney;
    public TextField txtPaid;
    public TextField txtToPaid;
    public TextField txtStatus;

    public void setData(ReservationDTO data) {
        txtResiD.setText(data.getId());
        txtStAddress.setText(data.getStudent().getAddress());
        txtStName.setText(data.getStudent().getName());
        txtStContact.setText(data.getStudent().getContact());
        txtStGender.setText(data.getStudent().getGender());
        txtRoomID.setText(data.getRoom().getId());
        txtRoomType.setText(data.getRoom().getType());
        txtKeyMoney.setText(String.valueOf(data.getRoom().getKeyMoney()));
        txtPaid.setText(String.valueOf(data.getPaid()));
        txtToPaid.setText(String.valueOf(data.getRoom().getKeyMoney() - data.getPaid()));
        txtStatus.setText(data.getStatus());

    }
}
