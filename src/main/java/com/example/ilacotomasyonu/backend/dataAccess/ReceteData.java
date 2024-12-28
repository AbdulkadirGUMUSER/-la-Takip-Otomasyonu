package com.example.ilacotomasyonu.backend.dataAccess;

import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.entities.Mudur;
import com.example.ilacotomasyonu.backend.entities.Recete;

import java.util.ArrayList;
import java.util.List;

public class ReceteData {

    private static ReceteData instance;

    public static ReceteData getInstance(){
        if (instance == null) {
            instance = new ReceteData();
        }
        return instance;
    }

    List<Recete> receteList=new ArrayList<Recete>();

    public ReceteData(){
        Ilac[] ilacList1={new Ilac(1,"Parol",1,10),new Ilac(3,"dexford",7,20)};
        receteList.add(new Recete("DokorAdi1","HastaAdi1",ilacList1));

        Ilac[] ilacList2={new Ilac(1,"Parol",3,10),new Ilac(2,"aferin",1,15)};
        receteList.add(new Recete("DokorAdi2","HastaAdi2",ilacList2));

        Ilac[] ilacList3={new Ilac(1,"Parol",1,10),new Ilac(3,"dexford",7,20)};
        receteList.add(new Recete("DokorAdi1","HastaAdi1",ilacList3));

        Ilac[] ilacList4={new Ilac(1,"Parol",3,10),new Ilac(2,"aferin",1,15)};
        receteList.add(new Recete("DokorAdi2","HastaAdi2",ilacList4));
    }

    public void add(Recete entity){
        receteList.add(entity);
    }
    public void delete(Recete entity){
        receteList.remove(entity);
    }
    public void update(Recete entity){

    }

    public List<Recete> getReceteList(){
        return receteList;
    }
}
