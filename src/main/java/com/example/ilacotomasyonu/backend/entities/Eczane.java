package com.example.ilacotomasyonu.backend.entities;

import java.util.List;

public class Eczane {
    private String name;
    private List<Personel> personelList;

    public Eczane(String name, List<Personel> personelList) {
        this.name = name;
        this.personelList = personelList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Personel> getPersonalList() {
        return personelList;
    }

    public void setPersonalList(List<Personel> personelList) {
        this.personelList = personelList;
    }
}
