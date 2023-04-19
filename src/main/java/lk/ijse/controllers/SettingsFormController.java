package lk.ijse.controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDTO;

public class SettingsFormController {

    public TextField txtUsername;
    public PasswordField txtCurrentPass;
    public PasswordField txtNewPass;
    public JFXToggleButton toggleNewPass;
    public JFXToggleButton toggleCurrentPass;
    UserBO user = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
    private UserDTO userDTO;
    private String password = "";

    public void initialize() {
        userDTO = LoginSessions.user;
        txtUsername.setText(userDTO.getUsername());
        password = userDTO.getPassword();
    }

    public void saveOnAction() {
        if (txtCurrentPass.getText().equals(password)) {
            userDTO.setPassword(txtNewPass.getText().isEmpty() ? password : txtNewPass.getText());
            userDTO.setUsername(txtUsername.getText().isEmpty() ? userDTO.getUsername() : txtUsername.getText());
            user.update(userDTO);
            new Alert(Alert.AlertType.INFORMATION, "Done!").show();


        } else {
            new Alert(Alert.AlertType.ERROR, "Incorrect password").show();
        }
    }

    public void toggleNew() {
        if (toggleNewPass.isSelected()) {
            txtNewPass.setPromptText(txtNewPass.getText());
            txtNewPass.setText("");
            txtNewPass.setDisable(true);
        } else {
            txtNewPass.setText(txtNewPass.getPromptText());
            txtNewPass.setPromptText("Password");
            txtNewPass.setDisable(false);
        }
    }

    public void toggleCurrent() {
        if (toggleCurrentPass.isSelected()) {
            txtCurrentPass.setPromptText(txtCurrentPass.getText());
            txtCurrentPass.setText("");
            txtCurrentPass.setDisable(true);
        } else {
            txtCurrentPass.setText(txtNewPass.getPromptText());
            txtCurrentPass.setPromptText("Password");
            txtCurrentPass.setDisable(false);
        }
    }
}
