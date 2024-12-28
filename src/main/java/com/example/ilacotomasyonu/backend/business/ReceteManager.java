package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.dataAccess.ReceteData;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.entities.Recete;
import com.example.ilacotomasyonu.backend.exceptions.ReceteException;

import java.util.List;

public class ReceteManager implements ReceteService{

    ReceteData receteData = ReceteData.getInstance();

    @Override
    public void addRecete(Recete recete) throws ReceteException{
        for(Ilac ilac: recete.getIlacList()){
            if(ilac.getSayisi()<=0){
                throw new ReceteException("İlaç sayısı 0 dan büyük olmalı!");
            }
        }
        if(recete.getDoktorAdi().isEmpty()||recete.getHastaAdi().isEmpty()){
            throw new ReceteException("Doktor adı ve hasta adı boş olamaz!");
        }
        if(recete.getIlacList().isEmpty()){
            throw new ReceteException("En az bir ilaç eklenmeli!");
        }
        receteData.add(recete);
    }

    @Override
    public void updateRecete(Recete recete) {
        receteData.update(recete);
    }

    @Override
    public void deleteRecete(Recete recete) {
        receteData.delete(recete);
    }

    @Override
    public List<Recete> getAllRecete() {
        return receteData.getReceteList();
    }
}
