/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SaiBack
 */
public class Account {
    private int id;
    private String user;
    private String pass;
    private String token;
    private String lastPin;
    private String nextTime;

    public Account(int id, String user, String pass, String token, String lastPin, String nextTime) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.token = token;
        this.lastPin = lastPin;
        this.nextTime = nextTime;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastPin() {
        return lastPin;
    }

    public void setLastPin(String lastPin) {
        this.lastPin = lastPin;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
