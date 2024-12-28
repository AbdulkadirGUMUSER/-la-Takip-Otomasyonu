package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.exceptions.UserException;

import java.util.List;

public interface CalisanService {
    void addCalisan(Calisan calisan) throws UserException;
    void updateCalisan(Calisan calisan);
    void deleteCalisan(Calisan calisan);
    List<Calisan> getAllCalisan();
    Calisan getCalisanById(int id);
}
