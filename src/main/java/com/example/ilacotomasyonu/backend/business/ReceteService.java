package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.entities.Recete;
import com.example.ilacotomasyonu.backend.exceptions.ReceteException;

import java.util.List;

public interface ReceteService {
    void addRecete(Recete recete) throws ReceteException;
    void updateRecete(Recete recete);
    void deleteRecete(Recete recete);
    List<Recete> getAllRecete();
}
