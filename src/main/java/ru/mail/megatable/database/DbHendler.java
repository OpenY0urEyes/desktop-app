package ru.mail.megatable.database;

import ru.mail.megatable.configs.DbConfig;
import ru.mail.megatable.consts.DoctorConst;
import ru.mail.megatable.consts.PatientConst;
import ru.mail.megatable.consts.ScheduleConst;
import ru.mail.megatable.models.Doctor;

import java.sql.*;
import java.time.LocalDate;

public class DbHendler extends DbConfig {

    Connection connection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String stringConnect = "jdbc:postgresql://" +dbHost+ ":" + dbPort + "/"+ dbName;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(stringConnect, dbUser, dbPass);
        return connection;
    }


    public Doctor getDoctor(Doctor doctor) {
        Doctor foundDoctor = null;
        String select = "SELECT * FROM " + DoctorConst.TABLE_NAME + " WHERE " + DoctorConst.FIRSTNAME + "=? AND " + DoctorConst.LASTNAME + "=? AND " + DoctorConst.PASSWORD + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, doctor.getFirstname());
            preparedStatement.setString(2, doctor.getLastname());
            preparedStatement.setString(3, doctor.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String firstname = resultSet.getString(DoctorConst.FIRSTNAME);
                String lastname = resultSet.getString(DoctorConst.LASTNAME);
                int specialId = resultSet.getInt(DoctorConst.SPECIAL_ID);
                int naprId = resultSet.getInt(DoctorConst.NAPR_ID);
                String roles = resultSet.getString(DoctorConst.ROLES);
                foundDoctor = new Doctor();
                foundDoctor.setFirstname(firstname);
                foundDoctor.setLastname(lastname);
                foundDoctor.setSpecialId(specialId);
                foundDoctor.setNaprId(naprId);
                foundDoctor.setRoles(roles);

                System.out.println("Found Doctor:");
                System.out.println("Firstname: " + foundDoctor.getFirstname());
                System.out.println("Lastname: " + foundDoctor.getLastname());
                System.out.println("specialId: " + foundDoctor.getSpecialId());
                System.out.println("naprId: " + foundDoctor.getNaprId());
                System.out.println("roles: " + foundDoctor.getRoles());
            }
            return foundDoctor;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getAllSchedule() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + ScheduleConst.TABLE_NAME;
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

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
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
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

    public ResultSet existsPatient(String firstname,
                                   String lastname,
                                   String middlename,
                                   String numberPhone,
                                   String email,
                                   String numberPolic,
                                   String passport
    ) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + PatientConst.TABLE_NAME + " WHERE " +
                PatientConst.FIRSTNAME + "=? OR " +
                PatientConst.LASTNAME + "=? OR " +
                PatientConst.MIDDLENAME + "=? OR " +
                PatientConst.NUMBER_PHONE + "=? OR " +
                PatientConst.EMAIL + "=? OR " +
                PatientConst.NUMBER_POLIC + "=? OR " +
                PatientConst.PASSPORT + "=?";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
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
