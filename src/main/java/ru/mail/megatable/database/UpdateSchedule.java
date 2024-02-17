package ru.mail.megatable.database;

import ru.mail.megatable.constans.ScheduleConst;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSchedule {

    public void updateOneSchedule(Date date, String time, String doctorId, Date newDate, String newTime, String newDoctorId, String newEvent) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + ScheduleConst.TABLE_NAME + " SET " + ScheduleConst.DATE_IVENT + " =?," +
                ScheduleConst.TIME_IVENT + " =?," +
                ScheduleConst.EVENT + " =?," +
                ScheduleConst.DOCTOR_ID + " =? WHERE " +
                ScheduleConst.DOCTOR_ID + "=? AND " +
                ScheduleConst.TIME_IVENT + "=? AND " +
                ScheduleConst.DATE_IVENT + "=?";
        DbHendler dbHendler = new DbHendler();
        PreparedStatement preparedStatement = dbHendler.getDbConnection().prepareStatement(update);
        preparedStatement.setDate(1, newDate);
        preparedStatement.setString(2, newTime);
        preparedStatement.setString(3, newEvent);
        preparedStatement.setInt(4, Integer.parseInt(newDoctorId));
        preparedStatement.setInt(5, Integer.parseInt(doctorId));
        preparedStatement.setString(6, time);
        preparedStatement.setDate(7, date);
        preparedStatement.executeUpdate();
    }
}
