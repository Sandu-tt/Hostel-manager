package lk.ijse.controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.util.Navigation;
import lk.ijse.util.Routes;

import java.io.IOException;
import java.util.List;

public class LoginController {
    public AnchorPane AnchorPaneContext;
    public TextField txtEmail;
    public PasswordField txtPassword;
    public Label passwordStatus;
    public JFXToggleButton passwordShow;

    public void loginOnAction(ActionEvent event) {
        UserBO user = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
        List<UserDTO> all = user.getAll();

        for (UserDTO dto : all) {
            if (txtEmail.getText().equals(dto.getUsername()) && txtPassword.getText().equals(dto.getPassword())) {

                LoginSessions.user = dto;
                try {
                    Navigation.navigation(Routes.DASHBOARD, AnchorPaneContext);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                passwordStatus.setText("Incorrect Username or Password");
            }
        }
    }

    public void login(ActionEvent action) {
        loginOnAction(action);
    }

    public void togglePassword() {
        if (passwordShow.isSelected()) {
            txtPassword.setPromptText(txtPassword.getText());
            txtPassword.setText("");
            txtPassword.setDisable(true);
            passwordShow.setText("Hide Password");
        } else {
            txtPassword.setText(txtPassword.getPromptText());
            txtPassword.setPromptText("Password");
            passwordShow.setText("Show Password");
            txtPassword.setDisable(false);
        }
    }
}
