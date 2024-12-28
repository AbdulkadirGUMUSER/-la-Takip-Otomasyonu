package com.example.ilacotomasyonu.backend.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recete extends Entity {
    private String doktorAdi;
    private String hastaAdi;
    private List<Ilac> ilacList=new ArrayList<>();

    public Recete(String doktorAdi, String hastaAdi,Ilac[] ilacList) {
        this.doktorAdi = doktorAdi;
        this.hastaAdi = hastaAdi;
        setIlacList(ilacList);
    }

    public String getDoktorAdi() {
        return doktorAdi;
    }

    public void setDoktorAdi(String doktorAdi) {
        this.doktorAdi = doktorAdi;
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        this.hastaAdi = hastaAdi;
    }

    public List<Ilac> getIlacList() {
        return ilacList;
    }

    public void setIlacList(Ilac[] ilacList) {
        this.ilacList.addAll(Arrays.asList(ilacList));
    }
}
