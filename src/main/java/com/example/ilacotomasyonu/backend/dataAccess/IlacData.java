package com.example.ilacotomasyonu.backend.dataAccess;

import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.entities.Entity;
import com.example.ilacotomasyonu.backend.entities.Ilac;

import java.util.ArrayList;
import java.util.List;

public class IlacData{

    private static IlacData instance;

    public static IlacData getInstance(){
        if (instance == null) {
            instance = new IlacData();
        }
        return instance;
    }
    private int lastId=4;

    List<Ilac> ilacList=new ArrayList<Ilac>();

    public IlacData(){
        ilacList.add(new Ilac(1,"Parol",10,10));
        ilacList.add(new Ilac(2,"aferin",5,15));
        ilacList.add(new Ilac(3,"dexford",7,20));
    }

    public void add(Ilac entity){
        entity.setId(lastId);
        ilacList.add(entity);

        lastId++;
    }
    public void delete(Ilac entity){
        ilacList.remove(entity);
    }
    public void update(Ilac entity){
        Ilac ilacFromList=getById(entity.getId());

        ilacFromList.setName(entity.getName());
        ilacFromList.setSayisi(entity.getSayisi());
        ilacFromList.setFiyat(entity.getFiyat());
    }

    public Ilac getById(int id){
        for (Ilac entity : ilacList) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    public List<Ilac> getIlacList(){
        return ilacList;
    }
}
