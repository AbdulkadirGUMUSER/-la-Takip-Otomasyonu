package com.example.ilacotomasyonu.backend.entities;

public abstract class Personel extends Entity{

    public int id;
    public String nameSurname;
    public String userName;
    public String password;
    public String title;
    public String email;

    public Personel(String nameSurname, String userName, String password, String title, String email) {
        this.nameSurname = nameSurname;
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String  password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
