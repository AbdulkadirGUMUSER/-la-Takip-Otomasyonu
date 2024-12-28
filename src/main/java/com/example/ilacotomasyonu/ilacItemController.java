package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.entities.Ilac;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ilacItemController {

    @FXML
    private Label ilacAdiLbl;
    @FXML
    private Label adetLbl;

    private Ilac ilac;

    public void setIlac(Ilac ilac){
        this.ilac=ilac;
    }

    public void onDisplay(){
        ilacAdiLbl.setText(ilac.getName());
        adetLbl.setText(String.valueOf(ilac.getSayisi()));
    }
}
