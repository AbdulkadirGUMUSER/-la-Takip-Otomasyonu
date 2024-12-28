package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.IlacManager;
import com.example.ilacotomasyonu.backend.business.IlacService;
import com.example.ilacotomasyonu.backend.business.ReceteManager;
import com.example.ilacotomasyonu.backend.business.ReceteService;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.entities.Recete;
import com.example.ilacotomasyonu.backend.exceptions.ReceteException;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReceteEkleController {


    @FXML
    private GridPane ilaclarGrid;

    @FXML
    private ComboBox<Ilac> secilenIlacCB;

    @FXML
    private TextField ilacSayisiTF;

    @FXML
    private TextField hastaAdiTF;

    @FXML
    private TextField doktorAdiTF;

    private IlacService ilacService;

    private List<Ilac> ilacList=new ArrayList<>();

    private int row=1;

    Alert alert=new Alert(Alert.AlertType.NONE);

    private ReceteService receteService;

    public ReceteEkleController(){
        ilacService=new IlacManager();
        receteService=new ReceteManager();
    }

    public void initialize() {
        secilenIlacCB.getItems().addAll(ilacService.getAllIlac());
        secilenIlacCB.getSelectionModel().selectFirst();
        Label ilacAdiLbl=new Label("Ilac Adi");
        ilacAdiLbl.setFont(new Font("System",18));
        Label ilacSayisiLbl=new Label("Ilac Sayisi");
        ilacSayisiLbl.setFont(new Font("System",18));

        ilaclarGrid.add(ilacAdiLbl,0,0);
        ilaclarGrid.add(ilacSayisiLbl,1,0);
    }

    @FXML
    protected void onReceteOlusturBtnClick(ActionEvent event) throws IOException {
        Recete recete=new Recete(doktorAdiTF.getText(),hastaAdiTF.getText(),ilacList.toArray(Ilac[]::new));

        try {
            receteService.addRecete(recete);
        } catch (ReceteException e) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
            return;
        }
        SwitchSceneService.getInstance().switchToAnaSayfa(event);
    }
    @FXML
    protected void onArttirBtnClick(){
        try {
            if(Integer.valueOf(ilacSayisiTF.getText())<=0||ilacSayisiTF.getText().isEmpty()){
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("İlaç sayısı 0 dan büyük olmalı!");
                alert.showAndWait();
                return;
            }
        }catch (NumberFormatException e){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Lütfen sayı giriniz!");
            alert.showAndWait();
            return;
        }

        Label ilacAdiLbl=new Label(secilenIlacCB.getValue().getName());
        ilacAdiLbl.setFont(new Font("System",18));
        Label ilacSayisiLbl=new Label(ilacSayisiTF.getText());
        ilacSayisiLbl.setFont(new Font("System",18));

        ilaclarGrid.add(ilacAdiLbl,0,row);
        ilaclarGrid.add(ilacSayisiLbl,1,row);

        row++;

        ilacList.add(new Ilac(secilenIlacCB.getValue().getId(),secilenIlacCB.getValue().getName(),Integer.valueOf(ilacSayisiTF.getText()),secilenIlacCB.getValue().getFiyat()));
    }

    @FXML
    protected void onGeriBtnClick(ActionEvent event) throws IOException {
        SwitchSceneService.getInstance().switchToAnaSayfa(event);
    }
}
