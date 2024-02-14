package ru.mail.megatable.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Setter;
import ru.mail.megatable.HelloApplication;
import ru.mail.megatable.database.DbHendler;
import ru.mail.megatable.models.Doctor;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField firstnameInput;
    @FXML
    private TextField lastnameInput;
    @FXML
    private PasswordField passwordInput;



    @Setter
    private Stage stage;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        String firstnameText = firstnameInput.getText().trim();
        String lastnameText = lastnameInput.getText().trim();
        String passwordText = passwordInput.getText().trim();
        if (firstnameText.isEmpty() || passwordText.isEmpty() || lastnameText.isEmpty()){
            welcomeText.setText("Данные пустые");
        }
        else {
            logInAccount(firstnameText, lastnameText, passwordText);
        }
    }

    public void logInAccount(String firstname, String lastname, String password) throws IOException {
        Doctor doctor = new Doctor();
        DbHendler dbHendler = new DbHendler();
        doctor.setFirstname(firstname);
        doctor.setLastname(lastname);
        doctor.setPassword(password);
        Doctor foundDoctor = dbHendler.getDoctor(doctor);

        if (foundDoctor != null){
            FXMLLoader fxmlLoaderSecond = new FXMLLoader(HelloApplication.class.getResource("main-scene-after-login.fxml"));
            Scene scene = new Scene(fxmlLoaderSecond.load(), 405, 370);
            stage.setMinHeight(600);
            stage.setMinWidth(900);
            stage.setScene(scene);
        }

    }
}