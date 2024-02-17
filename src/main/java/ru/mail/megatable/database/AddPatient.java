package ru.mail.megatable.database;

import ru.mail.megatable.constans.PatientConst;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddPatient {
    public void addPatient(String firstname,
                           String lastname,
                           String middlename,
                           String numberPhone,
                           String email,
                           String numberPolic,
                           String passport,
                           String sex,
                           LocalDate birthday,
                           String adres
    ) throws SQLException, ClassNotFoundException {
        DbHendler dbHendler = new DbHendler();
        String select = "INSERT INTO " + PatientConst.TABLE_NAME + "(" + PatientConst.FIRSTNAME
                + ", " + PatientConst.LASTNAME
                + ", " + PatientConst.MIDDLENAME
                + ", " + PatientConst.NUMBER_PHONE
                + ", " + PatientConst.EMAIL
                + ", " + PatientConst.NUMBER_POLIC
                + ", " + PatientConst.PASSPORT
                + ", " + PatientConst.SEX
                + ", " + PatientConst.BIRTHDAY
                + ", " + PatientConst.ADRESS + ") VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbHendler.getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, middlename);
            preparedStatement.setString(4, numberPhone);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, numberPolic);
            preparedStatement.setString(7, passport);
            preparedStatement.setString(8, sex);
            preparedStatement.setDate(9, Date.valueOf(birthday));
            preparedStatement.setString(10, adres);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Ошибка");
        }
        catch (RuntimeException e){
            System.out.println("Ошибка");
        }

    }
}
