package com.example.ilacotomasyonu.backend.dataAccess;

import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.services.SwitchSceneService;

import java.util.ArrayList;
import java.util.List;

public class CalisanData{

    private static CalisanData instance;

    public static CalisanData getInstance(){
        if (instance == null) {
            instance = new CalisanData();
        }
        return instance;
    }

    List<Calisan> calisanList=new ArrayList<Calisan>();

    public CalisanData(){
        add(new Calisan("calisan","calisan","calisan","calisan","calisan@calisan.com"));
    }

    private int lastId=1;

    public void add(Calisan entity){
        entity.setId(lastId);
        calisanList.add(entity);
        lastId++;
    }
    public void delete(Calisan entity){
        calisanList.remove(entity);
    }
    public void update(Calisan entity){
    }

    public List<Calisan> getCalisanList(){
        return calisanList;
    }

    public Calisan getCalisanById(int id){
        for(Calisan calisan:calisanList){
            if(calisan.getId()==id){
                return calisan;
            }
        }
        return null;
    }
}
