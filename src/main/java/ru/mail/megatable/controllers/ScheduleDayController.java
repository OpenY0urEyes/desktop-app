package ru.mail.megatable.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ru.mail.megatable.database.DbHendler;
import ru.mail.megatable.database.ScheduleByDate;
import ru.mail.megatable.models.ScheduleData;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;


public class ScheduleDayController {

    private Scene backScene;

    private Stage stage;

    public void setBackScene(Scene backScene) {
        this.backScene = backScene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private TableView<ScheduleData> tableView;


    @FXML
    private TextField day;
    @FXML
    private TextField month;
    @FXML
    private TextField year;

    @FXML
    public void viewSchedule() throws SQLException, ClassNotFoundException {
        ScheduleByDate schedule = new ScheduleByDate();
        ObservableList<ScheduleData> scheduleData = schedule.getAllScheduleByDate(Date.valueOf(year.getText()+"-"+month.getText()+"-"+day.getText()));
        tableView.setItems(scheduleData);
    }

    @FXML
    public void backScene() throws SQLException, ClassNotFoundException {
        stage.setScene(backScene);
    }
}
