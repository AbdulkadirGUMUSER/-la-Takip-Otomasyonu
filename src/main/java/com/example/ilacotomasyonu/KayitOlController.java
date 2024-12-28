package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.CalisanManager;
import com.example.ilacotomasyonu.backend.business.CalisanService;
import com.example.ilacotomasyonu.backend.business.MudurManager;
import com.example.ilacotomasyonu.backend.business.MudurService;
import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.entities.Mudur;
import com.example.ilacotomasyonu.backend.exceptions.UserException;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class KayitOlController {

    private ArrayList<String> mudurListesi = new ArrayList<>();
    private ArrayList<String> calisanListesi = new ArrayList<>();

    @FXML
    private TextField kayitOlKullaniciAdiTF;
    @FXML
    private PasswordField kayitOlSifreTF;
    @FXML
    private TextField kayitOlMailTF;
    @FXML
    private ComboBox<String> pozisyonCB;
    @FXML
    private Label mesajLabel;
    @FXML
    private TextField isimSoysimTF;
    @FXML
    private Button kayitOlBtn;
    @FXML
    private Button geriBtn;

    private MudurService mudurService;
    private CalisanService calisanService;

    Alert alert=new Alert(Alert.AlertType.NONE);

    public KayitOlController() {
        mudurService=new MudurManager();
        calisanService=new CalisanManager();
    }

    public void initialize() {
        pozisyonCB.getItems().addAll("Çalışan","Müdür");
        pozisyonCB.getSelectionModel().selectFirst();
    }

    @FXML
    private void onKayitOlBtnClick(ActionEvent event) {

        String kullaniciAdi = kayitOlKullaniciAdiTF.getText();
        String email = kayitOlMailTF.getText();
        String sifre = kayitOlSifreTF.getText();
        String isimSoyisim = isimSoysimTF.getText();
        String pozisyon = pozisyonCB.getValue();

            if (pozisyon.equalsIgnoreCase("Müdür")) {
                Mudur mudur=new Mudur(isimSoyisim,kullaniciAdi,sifre,pozisyon,email);
                try {
                    mudurService.addMudur(mudur);
                }catch (UserException exception){
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText(exception.getMessage());
                    alert.showAndWait();
                    return;
                }
                mesajLabel.setText("Müdür olarak kayıt başarılı!");
            } else if (pozisyon.equalsIgnoreCase("Çalışan")) {
                Calisan calisan=new Calisan(isimSoyisim,kullaniciAdi,sifre,pozisyon,email);
                try {
                    calisanService.addCalisan(calisan);
                }catch (UserException exception){
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText(exception.getMessage());
                    alert.showAndWait();
                    return;
                }
                mesajLabel.setText("Çalışan olarak kayıt başarılı!");
            }

        mesajLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold; -fx-font-style: bold;");
    }
    @FXML
    private void geriTusu(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToLogin(actionEvent);
    }
}
