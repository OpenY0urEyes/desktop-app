package ru.mail.megatable.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.mail.megatable.database.AddPatient;
import ru.mail.megatable.database.DbHendler;
import ru.mail.megatable.database.ExistsPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

public class AddPatientController {

    private Scene backScene;

    private Stage stage;

    public void setBackScene(Scene backScene) {
        this.backScene = backScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Label day;
    @FXML
    private Label time;
    @FXML
    private Label doctorName;

    @FXML
    private Label warning;

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField middlename;
    @FXML
    private TextField passport;
    @FXML
    private TextField numberPhone;
    @FXML
    private TextField adress;
    @FXML
    private TextField sex;
    @FXML
    private TextField polic;
    @FXML
    private TextField email;
    @FXML
    private DatePicker birthday;


    @FXML
    public void onClickAddPatient() throws SQLException, ClassNotFoundException {
        String firstname_text = firstname.getText().trim();
        String lastname_text = lastname.getText().trim();
        String middlename_text = middlename.getText().trim();
        String passport_text = passport.getText().trim();
        String numberPhone_text = numberPhone.getText().trim();
        String adress_text = adress.getText().trim();
        String sex_text = sex.getText().trim();
        String polic_text = polic.getText().trim();
        String email_text = email.getText().trim();
        LocalDate birthday_text = birthday.getValue();
        AddPatient addPatient = new AddPatient();
        ExistsPatient existsPatient = new ExistsPatient();
        ResultSet resultSet = existsPatient.existsPatient(firstname_text, lastname_text, middlename_text, numberPhone_text, email_text, numberPhone_text, passport_text);
        int counter = 0;
        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        try {
            if (counter >= 1){
                warning.setText("Введеные данные уже существуют");
            }
            else {
                addPatient.addPatient(firstname_text,lastname_text,middlename_text,numberPhone_text,email_text,numberPhone_text,passport_text,sex_text,birthday_text,adress_text);
            }
        }
        catch (RuntimeException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }

    }


    @FXML
    public void backScene() throws SQLException, ClassNotFoundException {
        stage.setScene(backScene);
    }
}
