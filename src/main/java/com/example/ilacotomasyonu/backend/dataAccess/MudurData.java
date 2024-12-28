package com.example.ilacotomasyonu.backend.dataAccess;

import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.entities.Mudur;

import java.util.ArrayList;
import java.util.List;

public class MudurData {

    private static MudurData instance;

    public static MudurData getInstance(){
        if (instance == null) {
            instance = new MudurData();
        }
        return instance;
    }

    List<Mudur> mudurList=new ArrayList<Mudur>();

    private int lastId=1;

    public MudurData() {
        add(new Mudur("Admin","admin","admin","admin","admin@admin.com"));
    }

    public void add(Mudur entity){
        entity.setId(lastId);
        mudurList.add(entity);
        lastId++;
    }
    public void delete(Mudur entity){
        mudurList.remove(entity);
    }
    public void update(Mudur entity){

    }

    public Mudur getMudurById(int id){
        for(Mudur mudur:mudurList){
            if(mudur.getId()==id){
                return mudur;
            }

        }
        return null;
    }

    public List<Mudur> getMudurList(){
        return mudurList;
    }
}
