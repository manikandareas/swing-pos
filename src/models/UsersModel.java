/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.UsersEntity;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author manik
 */
public class UsersModel {
    /**
     * @param username an unique username for find user in database
     * @param password for compare password within database for make sure valid
     * user get the session
     * @return Session type of Users
     */
    public static UsersEntity getSession(String username, String password) {
        Connection conn = DatabaseManager.getConnection();
        UsersEntity session = new UsersEntity();
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
            return new UsersEntity();
        } else {
            return session;
        }
    }

    public static void removeSession(UsersEntity session) {
        session.setHashedPassword("");
        session.setUsername("");

    }
}
