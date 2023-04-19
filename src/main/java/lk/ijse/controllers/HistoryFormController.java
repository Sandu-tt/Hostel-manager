package lk.ijse.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.tm.HistoryTM;

import java.io.IOException;
import java.util.List;

public class HistoryFormController {

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    public TextField txtReservation;
    public TextField txtStID;
    public JFXButton btnUpdate;
    public TextField txtRoomID;
    public TextField txtPaid;
    public TextField txtToPaid;
    public TableView<HistoryTM> tblCart;
    public TableColumn colKeyMoney;
    public TableColumn colStID;
    public TableColumn colRoomTypeID;
    public TableColumn colPayingAmount;
    public TableColumn colDateFrom;
    public TableColumn colDateTo;
    public TextField txtPayNow;
    public TableColumn colResID;
    public TableColumn colStatus;
    private ReservationDTO reservation;

    public void initialize() {
        tblCart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tblCart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        tblCart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblCart.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("payingAmount"));
        tblCart.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        tblCart.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("toDate"));
        tblCart.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("status"));
        tblCart.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("btn"));


        loadHistory();

        tblCart.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnUpdate.setDisable(false);

            if (newValue != null) {
                clear();
                if (newValue.getStatus().equals("paid")) {
                    new Alert(Alert.AlertType.INFORMATION, "This student already paid the key-money").show();
                    return;
                }
                System.out.println(newValue.getId());
                reservation = reservationBO.get(newValue.getId());
                RoomDTO roomDTO = roomBO.get(reservation.getRoom().getId());

                txtPaid.setText(String.valueOf(reservation.getPaid()));
                txtReservation.setText(reservation.getId());
                txtStID.setText(reservation.getStudent().getId());
                txtRoomID.setText(reservation.getRoom().getId());
                txtPaid.setText(String.valueOf(reservation.getPaid()));
                txtToPaid.setText(String.valueOf(roomDTO.getKeyMoney() - reservation.getPaid()));

            }
        });
    }

    private void loadHistory() {
        tblCart.getItems().clear();

        List<ReservationDTO> all = reservationBO.getAll();
        if (all != null) {
            for (ReservationDTO res : all) {
                JFXButton action = new JFXButton("View Data");
                action.setStyle("-fx-background-color: #2ecc71;");
                RoomDTO roomDTO = roomBO.get(res.getRoom().getId());
                HistoryTM tblItem = new HistoryTM(
                        res.getId(),
                        res.getFromDate(),
                        res.getToDate(),
                        res.getStudent().getId(),
                        res.getRoom().getId(),
                        roomDTO.getKeyMoney(),
                        res.getPaid(),
                        res.getStatus(),
                        action
                );
                action.setOnAction(event -> {
                    try {
                        action.setDisable(true);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ReservationData.fxml"));
                        Parent parent = loader.load();
                        ReservationDataController controller = loader.getController();
                        controller.setData(res);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                tblCart.getItems().add(tblItem);
            }
        }

    }

    public void updateOnAction() {
        reservation.setPaid(reservation.getPaid() + Double.parseDouble(txtPayNow.getText()));
        if (reservation.getPaid() >= roomBO.get(reservation.getRoom().getId()).getKeyMoney())
            reservation.setStatus("paid");

        boolean update = reservationBO.update(reservation);
        if (update) {
            loadHistory();
            clear();
            new Alert(Alert.AlertType.CONFIRMATION, "Done Update").show();
        }
    }

    private void clear() {
        txtPaid.clear();
        txtToPaid.clear();
        txtReservation.clear();
        txtRoomID.clear();
        txtStID.clear();
        txtPayNow.clear();
    }
}
