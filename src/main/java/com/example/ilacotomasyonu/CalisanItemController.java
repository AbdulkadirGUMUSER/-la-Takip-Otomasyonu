package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.CalisanManager;
import com.example.ilacotomasyonu.backend.business.CalisanService;
import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class CalisanItemController {

    @FXML
    private Label adLbl;

    private Calisan calisan;

    public void setCalisan(Calisan calisan){
        this.calisan=calisan;
    }

    private CalisanService calisanService;

    public CalisanItemController(){
        calisanService=new CalisanManager();
    }

    @FXML
    protected void onHesabiSilClick(ActionEvent actionEvent) throws IOException {
        System.out.println(calisan.getId());
        calisanService.deleteCalisan(calisanService.getCalisanById(calisan.getId()));
        SwitchSceneService.getInstance().switchToCalisanlar(actionEvent);
    }

    public void onDisplay(){
        adLbl.setText(calisan.getNameSurname());
    }
}
