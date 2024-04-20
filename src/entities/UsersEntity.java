/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author manik
 */
public class UsersEntity {
    private String username = "";
    private String hashedPassword = "";

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

    public UsersEntity() {
    }

    public UsersEntity(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

}
