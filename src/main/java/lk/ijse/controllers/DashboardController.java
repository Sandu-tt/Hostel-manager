package lk.ijse.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import lk.ijse.util.Navigation;
import lk.ijse.util.Routes;

import java.io.IOException;

public class DashboardController {
    public AnchorPane secondaryPain;
    public Line lineReservation;
    public Line lineStudents;
    public Line lineRooms;
    public Line lineHome;
    public Label lblReservation;
    public Label lblStudents;
    public Label lblRooms;
    public Label lblHome;
    public Label lblHistory;
    public Line lineHistory;
    public Label lblUnPaid;
    public Line lineUnpaid;
    public JFXButton btnClose;
    public Label lblUserName;
    public AnchorPane AnchorPaneContext;


    public void initialize() {
        lineHome.setOpacity(1);
        lineRooms.setOpacity(0);
        lineStudents.setOpacity(0);
        lineReservation.setOpacity(0);
        lineHistory.setOpacity(0);
        lineUnpaid.setOpacity(0);

        lblUserName.setText(LoginSessions.user.getUsername());
    }

    public void homeOnAction() {
        lineHome.setOpacity(1);
        lineRooms.setOpacity(0);
        lineStudents.setOpacity(0);
        lineReservation.setOpacity(0);
        lineHistory.setOpacity(0);
        lineUnpaid.setOpacity(0);
        try {
            Navigation.setPane(Routes.DASHBOARD, secondaryPain);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Error while loading");
        }
    }

    public void roomsOnAction() {
        lineHome.setOpacity(0);
        lineRooms.setOpacity(1);
        lineStudents.setOpacity(0);
        lineReservation.setOpacity(0);
        lineHistory.setOpacity(0);
        lineUnpaid.setOpacity(0);
        try {
            Navigation.setPane(Routes.ROOMS, secondaryPain);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while loading");
        }
    }

    public void studentsOnAction() {
        lineHome.setOpacity(0);
        lineRooms.setOpacity(0);
        lineStudents.setOpacity(1);
        lineReservation.setOpacity(0);
        lineHistory.setOpacity(0);
        lineUnpaid.setOpacity(0);
        try {
            Navigation.setPane(Routes.STUDENTS, secondaryPain);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Error while loading");
        }
    }

    public void reservationOnAction() {
        lineHome.setOpacity(0);
        lineRooms.setOpacity(0);
        lineStudents.setOpacity(0);
        lineReservation.setOpacity(1);
        lineHistory.setOpacity(0);
        lineUnpaid.setOpacity(0);
        try {
            Navigation.setPane(Routes.RESERVATIONS, secondaryPain);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Error while loading");
        }
    }

    public void closeOnAction() throws IOException {
        Stage stage = (Stage) AnchorPaneContext.getScene().getWindow();
        stage.setTitle("Login Page");
        stage.setScene(new Scene(FXMLLoader.load(Navigation.class.getResource("/view/Login.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }

    public void historyOnAction(MouseEvent mouseEvent) {
        lineHome.setOpacity(0);
        lineRooms.setOpacity(0);
        lineStudents.setOpacity(0);
        lineReservation.setOpacity(0);
        lineHistory.setOpacity(1);
        lineUnpaid.setOpacity(0);
        try {
            Navigation.setPane(Routes.HISTORY, secondaryPain);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while loading");
        }
    }

    public void unPaidSts(MouseEvent mouseEvent) {
        lineHome.setOpacity(0);
        lineRooms.setOpacity(0);
        lineStudents.setOpacity(0);
        lineReservation.setOpacity(0);
        lineHistory.setOpacity(0);
        lineUnpaid.setOpacity(1);
        try {
            Navigation.setPane(Routes.UNPAID, secondaryPain);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while loading");
        }
    }


    public void settingsOnAction() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(new Scene(FXMLLoader.load(Navigation.class.getResource("/view/Settings.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
}