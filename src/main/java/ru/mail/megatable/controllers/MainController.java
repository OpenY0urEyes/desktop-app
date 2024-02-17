package ru.mail.megatable.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.mail.megatable.HelloApplication;

import java.io.IOException;

public class MainController {
    private Stage stage;

    @FXML
    private Button changeSchedule;

    public Button getChangeSchedule() {
        return changeSchedule;
    }

    public void setChangeSchedule(Button changeSchedule) {
        this.changeSchedule = changeSchedule;
    }

    private Scene mainScene;

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void schduleDay() throws IOException {
        FXMLLoader fmxlLoaderScheduleDay = new FXMLLoader(HelloApplication.class.getResource("schedule-day.fxml"));
        Scene schedule = new Scene(fmxlLoaderScheduleDay.load(), 405, 370);
        ScheduleDayController scheduleDayController = fmxlLoaderScheduleDay.getController();
        scheduleDayController.setBackScene(mainScene);
        scheduleDayController.setStage(stage);
        stage.setScene(schedule);
    }

    public void addPatient() throws IOException {
        FXMLLoader fmxlLoaderAddPatient = new FXMLLoader(HelloApplication.class.getResource("main-scene-after-login.fxml"));
        Scene schedule = new Scene(fmxlLoaderAddPatient.load(), 405, 370);
        AddPatientController addPatient = fmxlLoaderAddPatient.getController();
        addPatient.setBackScene(mainScene);
        addPatient.setStage(stage);
        stage.setScene(schedule);
    }

    public void changeSchedule() throws IOException {
        FXMLLoader fmxlLoaderChangeSchedule = new FXMLLoader(HelloApplication.class.getResource("change-schedule.fxml"));
        Scene changeSchedule = new Scene(fmxlLoaderChangeSchedule.load(), 405, 370);
        ChangeScheduleController changeScheduleController = fmxlLoaderChangeSchedule.getController();
        changeScheduleController.setBackScene(mainScene);
        changeScheduleController.setStage(stage);
        stage.setScene(changeSchedule);
    }
}
