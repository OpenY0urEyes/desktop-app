package ru.mail.megatable.database;

import ru.mail.megatable.configs.DbConfig;

import java.sql.*;

public class DbHendler extends DbConfig {

    Connection connection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String stringConnect = "jdbc:postgresql://" +dbHost+ ":" + dbPort + "/"+ dbName;
        connection = DriverManager.getConnection(stringConnect, dbUser, dbPass);
        return connection;
    }

}
