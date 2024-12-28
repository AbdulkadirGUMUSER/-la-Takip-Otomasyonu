package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.exceptions.IlacException;

import java.util.List;

public interface IlacService {
    void addIlac(Ilac ilac);
    void updateIlac(Ilac ilac) throws IlacException;
    void deleteIlac(Ilac ilac);
    Ilac getById(int id);
    List<Ilac> getAllIlac();

}
