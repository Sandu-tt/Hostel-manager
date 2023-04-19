package lk.ijse.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.tm.RoomTM;
import lk.ijse.util.Regex;
import lk.ijse.util.TextFields;

import java.util.List;

public class RoomFormController {

    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    public TextField txtID;
    public TextField txtType;
    public TextField txtKeyMoney;
    public TextField txtQty;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TableColumn<RoomTM, String> colID;
    public TableColumn<RoomTM, String> colType;
    public TableColumn<RoomTM, Double> colKeyMoney;
    public TableColumn<RoomTM, Integer> colQTY;
    public TableView<RoomTM> tblRooms;


    public void initialize() {
        tblRooms.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblRooms.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        tblRooms.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblRooms.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        setRoomsTable();
        txtID.setText("RM-");
        txtID.requestFocus();

        tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(false);
            btnAdd.setDisable(true);
            btnUpdate.setDisable(false);

            if (newValue != null) {
                txtID.setText(newValue.getId());
                txtID.setEditable(false);
                txtType.setText(newValue.getType());
                txtKeyMoney.setText(String.valueOf(newValue.getKeyMoney()));
                txtQty.setText(String.valueOf(newValue.getQty()));

                txtID.setDisable(false);
                txtType.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtQty.setDisable(false);
            }
        });
    }

    public void setRoomsTable() {
        tblRooms.getItems().clear();
        List<RoomDTO> allRooms = roomBO.getAll();
        if (allRooms != null) {
            for (RoomDTO room : allRooms) {
                tblRooms.getItems().add(new RoomTM(room.getId(), room.getType(), room.getKeyMoney(), room.getQty()));
            }
        }
    }

    public void saveRoomOnAction() {
        if (isAllFieldsComplete()) {
            if (roomBO.isExists(txtID.getText())) {
                new Alert(Alert.AlertType.WARNING, "Already Saved Room").show();
                return;
            }
            boolean saved = roomBO.save(new RoomDTO(
                    txtID.getText(),
                    txtType.getText(),
                    Double.parseDouble(txtKeyMoney.getText()),
                    Integer.parseInt(txtQty.getText())
            ));
            if (saved) {
                setRoomsTable();
                clear();
                new Alert(Alert.AlertType.CONFIRMATION, "Done Saving").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Error Saving").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please Check All Fields").show();
        }
    }

    public void updateOnAction() {
        if (isAllFieldsComplete()) {
            boolean saved = roomBO.update(new RoomDTO(
                    txtID.getText(),
                    txtType.getText(),
                    Double.parseDouble(txtKeyMoney.getText()),
                    Integer.parseInt(txtQty.getText())
            ));
            if (saved) {
                setRoomsTable();
                clear();
                new Alert(Alert.AlertType.CONFIRMATION, "Done Saving").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Error Saving").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please Check All Fields").show();

        }
    }

    public void deleteOnAction() {
        if (isAllFieldsComplete()) {
            boolean saved = roomBO.delete(new RoomDTO(
                    txtID.getText(),
                    txtType.getText(),
                    Double.parseDouble(txtKeyMoney.getText()),
                    Integer.parseInt(txtQty.getText())
            ));
            if (saved) {
                setRoomsTable();
                clear();
                new Alert(Alert.AlertType.CONFIRMATION, "Done Deleting").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Error Saving").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please Check All Fields").show();

        }

    }

    private boolean isAllFieldsComplete() {
        return Regex.isTextFieldValid(TextFields.ROOM_ID, txtID.getText())
                && Regex.isTextFieldValid(TextFields.STRING, txtType.getText())
                && Regex.isTextFieldValid(TextFields.DOUBLE, txtKeyMoney.getText())
                && Regex.isTextFieldValid(TextFields.INTEGER, txtQty.getText());
    }

    public void clear() {
        txtQty.clear();
        txtID.clear();
        txtType.clear();
        txtKeyMoney.clear();
        txtID.setText("RM-");
        btnAdd.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    public void keyPress() {
        System.out.println(txtID.getText());
        boolean b = Regex.setTextColor(TextFields.ROOM_ID, txtID);
        btnAdd.setDisable(!b);
    }

    public void typePressed() {
        System.out.println(txtID.getText());
        boolean b = Regex.setTextColor(TextFields.STRING, txtID);
        btnAdd.setDisable(!b);
    }

    public void moneyPressed() {
        System.out.println(txtID.getText());
        boolean b = Regex.setTextColor(TextFields.DOUBLE, txtKeyMoney);
        btnAdd.setDisable(!b);
    }

    public void qtyPressed() {
        System.out.println(txtID.getText());
        boolean b = Regex.setTextColor(TextFields.INTEGER, txtQty);
        btnAdd.setDisable(!b);
    }
}
