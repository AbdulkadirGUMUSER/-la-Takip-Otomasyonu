package com.example.ilacotomasyonu.backend.entities;

public class Ilac extends Entity {
    private int id;
    private String name;
    private int sayisi;
    private double fiyat;

    public Ilac(int id,String name, int sayisi, double fiyat) {
        this.id = id;
        this.name = name;
        this.sayisi = sayisi;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSayisi() {
        return sayisi;
    }

    public void setSayisi(int sayisi) {
        this.sayisi = sayisi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString(){
        return getName();
    }
}
