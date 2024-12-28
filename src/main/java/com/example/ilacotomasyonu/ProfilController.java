package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.entities.Personel;
import com.example.ilacotomasyonu.services.MainAppService;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class ProfilController {

    @FXML
    private Label isimSoyisimLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label unvanLabel;
    @FXML
    private Label kullaniciAdiLabel;
    @FXML
    private Label sifreLabel;
    @FXML
    private Button geriButon2;

    private Personel personel;

    public void setPersonal(Personel personel) {
        this.personel = personel;
    }

    @FXML
    public void goster(){
    }

    @FXML
    public void onGeri(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToAnaSayfa(actionEvent);
    }

    public void onDisplay() {
        setPersonal(MainAppService.getInstance().getPersonal());
        setFields();
    }

    private void setFields(){
        isimSoyisimLabel.setText(personel.getNameSurname());
        mailLabel.setText(personel.getEmail());
        unvanLabel.setText(personel.getTitle());
        kullaniciAdiLabel.setText(personel.getUserName());
        sifreLabel.setText(personel.getPassword());
    }
}
