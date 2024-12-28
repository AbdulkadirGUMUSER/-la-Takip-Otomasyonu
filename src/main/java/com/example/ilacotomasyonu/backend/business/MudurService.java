package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.entities.Mudur;
import com.example.ilacotomasyonu.backend.exceptions.UserException;

import java.util.List;

public interface MudurService {
    void addMudur(Mudur mudur) throws UserException;
    void updateMudur(Mudur mudur);
    void deleteMudur(Mudur mudur);
    List<Mudur> getAllMudurs();

}
