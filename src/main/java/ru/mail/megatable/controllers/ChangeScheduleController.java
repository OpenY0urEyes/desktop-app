package ru.mail.megatable.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.mail.megatable.database.DbHendler;
import ru.mail.megatable.database.UpdateSchedule;

import java.sql.Date;
import java.sql.SQLException;

public class ChangeScheduleController {

    @FXML
    private TextField oldDay;
    @FXML
    private TextField oldMonth;
    @FXML
    private TextField oldYear;
    @FXML
    private TextField oldDoctorId;
    @FXML
    private TextField oldTime;
    @FXML
    private TextField newDay;
    @FXML
    private TextField newMonth;
    @FXML
    private TextField newYear;
    @FXML
    private TextField newDoctorId;
    @FXML
    private TextField newTime;
    @FXML
    private TextField newEvent;

    private Scene backScene;

    private Stage stage;

    public void setBackScene(Scene backScene) {
        this.backScene = backScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    public void changeSchedule() throws SQLException, ClassNotFoundException {
        if (newDay.getText().isEmpty()){
            newDay.setText(oldDay.getText());
        }
        if (newMonth.getText().isEmpty()){
            newMonth.setText(oldMonth.getText());
        }
        if (newYear.getText().isEmpty()){
            newYear.setText(oldYear.getText());
        }
        if (newTime.getText().isEmpty()){
            newTime.setText(oldTime.getText());
        }
        if (newDoctorId.getText().isEmpty()){
            newDoctorId.setText(oldDoctorId.getText());
        }
        Date oldDate = Date.valueOf(
                oldYear.getText() + "-" + oldMonth.getText() + "-" + oldDay.getText()
        );

        Date newDate = Date.valueOf(
                newYear.getText() + "-" + newMonth.getText() + "-" + newDay.getText()
        );
        UpdateSchedule updateSchedule = new UpdateSchedule();
        updateSchedule.updateOneSchedule(oldDate,
                oldTime.getText(),
                oldDoctorId.getText(),
                newDate,
                newTime.getText(),
                newDoctorId.getText(),
                newEvent.getText());
    }
    @FXML
    public void backScene() throws SQLException, ClassNotFoundException {
        stage.setScene(backScene);
    }
}
