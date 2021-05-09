package com.example.traveller.dataBases;

public class User {

    String  uname;
    String fname;
    String email;
    String pass;
    String pno;

    public User() {
    }

    public User(String uname, String fname, String email, String pass, String pno) {
        this.uname = uname;
        this.fname = fname;
        this.email = email;
        this.pass = pass;
        this.pno = pno;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }



    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
