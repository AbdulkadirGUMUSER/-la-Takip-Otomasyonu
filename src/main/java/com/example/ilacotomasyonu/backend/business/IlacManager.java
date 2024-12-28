package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.dataAccess.IlacData;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.exceptions.IlacException;

import java.util.List;

public class IlacManager implements IlacService{

    IlacData ilacData=IlacData.getInstance();

    @Override
    public void addIlac(Ilac ilac) {
        ilacData.add(ilac);
    }

    @Override
    public void updateIlac(Ilac ilac) throws IlacException{
        if(ilac.getSayisi()<0){
            throw new IlacException("Geçersiz ilaç sayısı!");
        }
        ilacData.update(ilac);
    }

    @Override
    public void deleteIlac(Ilac ilac) {
        ilacData.delete(ilac);
    }

    @Override
    public Ilac getById(int id) {
        return ilacData.getById(id);
    }

    @Override
    public List<Ilac> getAllIlac() {
        return ilacData.getIlacList();
    }
}
