package com.example.texteditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogout;

    @FXML
    void onLogout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        Stage logoutStage = (Stage) btnLogout.getScene().getWindow();

        logoutStage.close();

        stage.show();
    }

    @FXML
    void getUsername(KeyEvent event) {

    }

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        if (txtPassword.getText().equals("1234") && txtUsername.getText().equals("admin") ){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainApp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Gidey 1.001");
            stage.setScene(scene);
            stage.setResizable(false);
            Stage loginStage = (Stage) btnLogin.getScene().getWindow();

            loginStage.close();

            stage.show();
        }else{
            //Do nothing
        }
    }

}
