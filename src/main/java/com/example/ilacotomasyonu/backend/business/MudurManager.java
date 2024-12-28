package com.example.ilacotomasyonu.backend.business;

import com.example.ilacotomasyonu.backend.dataAccess.MudurData;
import com.example.ilacotomasyonu.backend.entities.Mudur;
import com.example.ilacotomasyonu.backend.exceptions.UserException;

import java.util.List;
import java.util.regex.Pattern;

public class MudurManager implements MudurService{

    MudurData mudurData = MudurData.getInstance();

    @Override
    public void addMudur(Mudur mudur) throws UserException{
        if(mudur.getNameSurname().isEmpty()||mudur.getUserName().isEmpty()||mudur.getEmail().isEmpty()||mudur.getPassword().isEmpty()||mudur.getTitle().isEmpty())
            throw new UserException("Gerekli alanlar boş olamaz!");
        if(mudur.getPassword().length()<6){
            throw new UserException("Şifre 6 karakterden kısa olamaz!");
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailRegex);
        if(!p.matcher(mudur.getEmail()).matches()){
            throw new UserException("Geçerli email adresi giriniz!");
        }
        mudurData.add(mudur);
    }

    @Override
    public void updateMudur(Mudur mudur) {
        mudurData.update(mudur);
    }

    @Override
    public void deleteMudur(Mudur mudur) {
        mudurData.delete(mudur);
    }

    @Override
    public List<Mudur> getAllMudurs() {
        return mudurData.getMudurList();
    }
}
