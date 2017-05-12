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
public class LinkPin {
    private int id;
    private String link;
    private String img;
    private String note;
    private byte checkPin;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getCheckPin() {
        return checkPin;
    }

    public void setCheckPin(byte checkPin) {
        this.checkPin = checkPin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LinkPin(String link, String img) {
        this.link = link;
        this.img = img;
    }

    public LinkPin(int id, String link, String img, String note, byte checkPin, int userId) {
        this.id = id;
        this.link = link;
        this.img = img;
        this.note = note;
        this.checkPin = checkPin;
        this.userId = userId;
    }
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public String toString() {
        return "LinkPin{" + "link=" + link + ", img=" + img + '}';
    }
    
}
