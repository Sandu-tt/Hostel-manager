package lk.ijse.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigation {

    public static void navigation(Routes routes, AnchorPane pane) throws IOException {
        if (Objects.requireNonNull(routes) == Routes.DASHBOARD) {
            initUI("Dashboard", pane);
        } else {
            initUI("Login", pane);
        }
    }

    private static void initUI(String location, AnchorPane pane) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setTitle("Home");
        stage.setScene(new Scene(FXMLLoader.load(Navigation.class.getResource("/view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    public static void setPane(Routes routes, AnchorPane secondaryPain) throws IOException {
        switch (routes) {
            case ROOMS:
                panelUpdate("Rooms", secondaryPain);
                break;
            case DASHBOARD:
                panelUpdate("LandingPane", secondaryPain);
                break;
            case STUDENTS:
                panelUpdate("Students", secondaryPain);
                break;
            case RESERVATIONS:
                panelUpdate("Reservation", secondaryPain);
                break;
            case HISTORY:
                panelUpdate("History", secondaryPain);
                break;
            case UNPAID:
                panelUpdate("UnPaid", secondaryPain);
                break;

        }

    }

    private static void panelUpdate(String location, AnchorPane pane) throws IOException {
        System.out.println(location);
        pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/view/" + location + ".fxml")));
    }
}
