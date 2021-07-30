package com.example.db_laundary.model;

public class contact {
    private int s_id;
    private String name;
    private String pass;
    private int tshirt;
    private int shirt;
    private int trouser;
    private int woollen;
    private String time;

    public contact(String name, String pass) {
        this.s_id = s_id;
        this.name = name;
        this.pass = pass;
    }

    public contact(int s_id, String name, String pass) {
        this.s_id = s_id;
        this.name = name;
        this.pass = pass;
    }

    public contact() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTshirt() {
        return tshirt;
    }

    public void setTshirt(int tshirt) {
        this.tshirt = tshirt;
    }

    public int getShirt() {
        return shirt;
    }

    public void setShirt(int shirt) {
        this.shirt = shirt;
    }

    public int getTrouser() {
        return trouser;
    }

    public void setTrouser(int trouser) {
        this.trouser = trouser;
    }

    public int getWoollen() {
        return woollen;
    }

    public void setWoollen(int woollen) {
        this.woollen = woollen;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
