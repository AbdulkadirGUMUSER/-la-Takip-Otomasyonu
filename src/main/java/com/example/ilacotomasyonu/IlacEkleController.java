package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.IlacManager;
import com.example.ilacotomasyonu.backend.business.IlacService;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.exceptions.IlacException;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class IlacEkleController {

    @FXML
    private ComboBox<Ilac> ilacCbx;

    @FXML
    private TextField ilacSayisiTF;

    @FXML
    private Label mesajLabel2;


    Alert alert=new Alert(Alert.AlertType.NONE);

    private IlacService ilacService;

    public IlacEkleController() {
        ilacService=new IlacManager();
    }

    @FXML
    public void initialize() {
        ilacCbx.getItems().addAll(ilacService.getAllIlac());
    }

    @FXML
    protected void onSiparisVerClick() {
        Ilac ilac = ilacCbx.getValue();

        if (ilac == null) {
            mesajLabel2.setText("Lütfen bir ilaç seçin.");
            return;
        }

        int ilacSayisi = 0;
        try {
            ilacSayisi = Integer.parseInt(ilacSayisiTF.getText());
        } catch (NumberFormatException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Geçersiz değer!");
            alert.showAndWait();
            return;
        }
        if(ilacSayisi<=0){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Geçersiz değer!");
            alert.showAndWait();
            return;
        }

        double ucret = 0;
        ucret=ilac.getFiyat()*ilacSayisi;

        ilac.setSayisi(ilacSayisi+ilac.getSayisi());

        try {
            ilacService.updateIlac(ilac);
        } catch (IlacException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Geçersiz ilaç sayısı");
            alert.showAndWait();
            return;

        }

        mesajLabel2.setText("Siparişiniz alınmıştır. Ücreti: " + ucret + "TL.");
    }

    @FXML
    protected void onGeriClick(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToAnaSayfa(actionEvent);
    }
}
