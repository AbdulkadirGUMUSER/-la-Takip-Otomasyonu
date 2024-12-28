package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.CalisanManager;
import com.example.ilacotomasyonu.backend.business.CalisanService;
import com.example.ilacotomasyonu.backend.business.MudurManager;
import com.example.ilacotomasyonu.backend.business.MudurService;
import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.entities.Mudur;

import java.io.IOException;
import java.util.Iterator;

import com.example.ilacotomasyonu.backend.entities.Personel;
import com.example.ilacotomasyonu.services.MainAppService;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField kullaniciAdiTF;
    @FXML
    private PasswordField sifreTF;
    @FXML
    private Button girisBtn;
    @FXML
    private Button kayitBtn;

    private MudurService mudurService;
    private CalisanService calisanService;

    public HelloController() {
        //this.mudurListesi.add(new Mudur("kadir gümüşer","kadirgmsr","170704","müdür","kadir@gmail.com"));
        mudurService=new MudurManager();
        calisanService=new CalisanManager();
    }


    @FXML
    protected void onGirisYapClick(ActionEvent actionEvent) throws IOException {
        String kullaniciAdi = kullaniciAdiTF.getText();
        String sifre = sifreTF.getText();
        Personel personel =null;
        Iterator mudurListIt = this.mudurService.getAllMudurs().iterator();
        Iterator calisanListIt=this.calisanService.getAllCalisan().iterator();

        while(mudurListIt.hasNext()) {
            Mudur mudur = (Mudur) mudurListIt.next();
            System.out.println(mudur.getUserName());
            if (mudur.getUserName().equals(kullaniciAdi) && mudur.getPassword().equals(sifre)) {
                personel =mudur;
                break;
            }
        }
        while(calisanListIt.hasNext()&& personel == null) {
            Calisan calisan = (Calisan) calisanListIt.next();
            if (calisan.getUserName().equals(kullaniciAdi) && calisan.getPassword().equals(sifre)) {
                personel =calisan;
                break;
            }
        }

        Alert alert;
        if (personel !=null) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Giriş Başarılı");
            alert.setHeaderText((String)null);
            alert.setContentText(personel.getTitle()+" girişi başarılı!");
            alert.showAndWait();

            MainAppService.getInstance().setPersonal(personel);
            SwitchSceneService.getInstance().switchToAnaSayfa(actionEvent);

        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hatalı Giriş");
            alert.setHeaderText((String)null);
            alert.setContentText("Kullanıcı adı veya şifre hatalı!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onKayitOlClick(ActionEvent actionEvent) throws IOException {
            SwitchSceneService.getInstance().switchToKayitOl(actionEvent);
    }
}