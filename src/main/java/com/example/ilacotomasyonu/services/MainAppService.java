package com.example.ilacotomasyonu.services;

import com.example.ilacotomasyonu.backend.entities.Personel;

public class MainAppService {

    private static MainAppService instance;

    public static MainAppService getInstance() {
        if (instance == null) {
            instance = new MainAppService();
        }
        return instance;
    }

    private Personel personel;

    public Personel getPersonal() {
        return personel;
    }
    public void setPersonal(Personel personel) {
        this.personel = personel;
    }

}
