package ru.mail.megatable.database;

import ru.mail.megatable.constans.DoctorConst;
import ru.mail.megatable.models.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth{

    public Doctor getDoctor(Doctor doctor) {
        Doctor foundDoctor = null;
        String select = "SELECT * FROM " + DoctorConst.TABLE_NAME + " WHERE " + DoctorConst.FIRSTNAME + "=? AND " +
                DoctorConst.LASTNAME + "=? AND " +
                DoctorConst.PASSWORD + "=?";
        try {
            DbHendler dbHendler = new DbHendler();
            PreparedStatement preparedStatement = dbHendler.getDbConnection().prepareStatement(select);
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

}
