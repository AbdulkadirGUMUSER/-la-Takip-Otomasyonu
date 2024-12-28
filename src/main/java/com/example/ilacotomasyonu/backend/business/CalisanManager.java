package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.dataAccess.CalisanData;
import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.exceptions.UserException;

import java.util.List;
import java.util.regex.Pattern;

public class CalisanManager implements CalisanService{

    CalisanData calisanData = CalisanData.getInstance();

    @Override
    public void addCalisan(Calisan calisan) throws UserException {
        if(calisan.getNameSurname().isEmpty()||calisan.getUserName().isEmpty()||calisan.getEmail().isEmpty()||calisan.getPassword().isEmpty()||calisan.getTitle().isEmpty())
            throw new UserException("Gerekli alanlar boş olamaz!");
        if(calisan.getPassword().length()<6){
            throw new UserException("Şifre 6 karakterden kısa olamaz!");
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailRegex);
        if(!p.matcher(calisan.getEmail()).matches()){
            throw new UserException("Geçerli email adresi giriniz!");
        }
        calisanData.add(calisan);
    }

    @Override
    public void updateCalisan(Calisan calisan) {
        calisanData.update(calisan);
    }

    @Override
    public void deleteCalisan(Calisan calisan) {
        calisanData.delete(calisan);
    }

    @Override
    public List<Calisan> getAllCalisan() {
        return calisanData.getCalisanList();
    }

    @Override
    public Calisan getCalisanById(int id) {
        return calisanData.getCalisanById(id);
    }


}
