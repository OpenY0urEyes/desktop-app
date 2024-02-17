package ru.mail.megatable.database;

import ru.mail.megatable.constans.PatientConst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistsPatient {

    public ResultSet existsPatient(String firstname,
                                   String lastname,
                                   String middlename,
                                   String numberPhone,
                                   String email,
                                   String numberPolic,
                                   String passport
    ) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler = new DbHendler();
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + PatientConst.TABLE_NAME + " WHERE " +
                PatientConst.FIRSTNAME + "=? OR " +
                PatientConst.LASTNAME + "=? OR " +
                PatientConst.MIDDLENAME + "=? OR " +
                PatientConst.NUMBER_PHONE + "=? OR " +
                PatientConst.EMAIL + "=? OR " +
                PatientConst.NUMBER_POLIC + "=? OR " +
                PatientConst.PASSPORT + "=?";

        PreparedStatement preparedStatement = dbHendler.getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, middlename);
        preparedStatement.setString(4, numberPhone);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, numberPolic);
        preparedStatement.setString(7, passport);
        return resultSet = preparedStatement.executeQuery();
    }
}
