/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author manik
 */
public class Users {
    private String username;
    private String hashedPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }


    public Users(String username, String password) {
        this.username = username;
        this.hashedPassword = password;
    }


    public Users() {
        this.username = "";
        this.hashedPassword = "";
    }

    /**
     * @param username an unique username for find user in database
     * @param password for compare password within database for make sure valid
     * user get the session
     * @return Session type of Users
     */
    public static Users getSession(String username, String password) {
        Connection conn = DatabaseManager.getConnection();
        Users session = new Users();
        try {

            String sql = String.format("SELECT * FROM users WHERE name = '%s'", username);

            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                session.setUsername(rs.getString("name"));
                session.setHashedPassword(rs.getString("hashed_password"));
            }

        } catch (Exception e) {
            return null;
        }
        DatabaseManager.closeConnection(conn);
        if (!session.getHashedPassword().equals(password)) {
            return new Users();
        } else {
            return session;
        }
    }

    public static void removeSession(Users session) {
        session.setHashedPassword("");
        session.setUsername("");

    }
}
