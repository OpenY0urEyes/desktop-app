package ru.mail.megatable.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.mail.megatable.constans.ScheduleConst;
import ru.mail.megatable.models.ScheduleData;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleByDate {

    public ObservableList<ScheduleData> getAllScheduleByDate(Date date) throws SQLException, ClassNotFoundException {
        ObservableList<ScheduleData> scheduleList = FXCollections.observableArrayList();
        DbHendler dbHendler = new DbHendler();

        String select = "SELECT * FROM " + ScheduleConst.TABLE_NAME + " WHERE " + ScheduleConst.DATE_IVENT +  " = ?";
        PreparedStatement preparedStatement =  dbHendler.getDbConnection().prepareStatement(select);
        preparedStatement.setDate(1, date);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int scheduleId = resultSet.getInt("schedule_id");
            String dateEvent = resultSet.getString("date_event");
            String timeEvent = resultSet.getString("time_event");
            int doctorId = resultSet.getInt("doctor_id");
            String event = resultSet.getString("event");
            scheduleList.add(new ScheduleData(scheduleId, dateEvent, timeEvent, doctorId, event));
        }

        for (ScheduleData scheduleData : scheduleList) {
            System.out.println(scheduleData);
        }

        return scheduleList;
    }
}
