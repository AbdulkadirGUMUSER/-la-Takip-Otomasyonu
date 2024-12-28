package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.ReceteManager;
import com.example.ilacotomasyonu.backend.business.ReceteService;
import com.example.ilacotomasyonu.backend.entities.Mudur;
import com.example.ilacotomasyonu.backend.entities.Personel;
import com.example.ilacotomasyonu.backend.entities.Recete;
import com.example.ilacotomasyonu.services.MainAppService;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


import java.awt.*;
import java.io.IOException;

public class AnaSayfaController {

    @FXML
    private Button profilBtn;
    @FXML
    private Button receteEkleBtn;
    @FXML
    private Button depoBtn;
    @FXML
    private Button satınalBtn;
    @FXML
    private GridPane receteGrid;
    @FXML
    private VBox leftBtnBox;

    private Personel personel;

    private ReceteService receteService;

    public AnaSayfaController() {
        receteService=new ReceteManager();
    }

    public void initialize() {
        setPersonal(MainAppService.getInstance().getPersonal());

        if(personel instanceof Mudur) {
            Button calisanBtn=new Button("Çalışanlar");
            leftBtnBox.getChildren().add(calisanBtn);
            calisanBtn.setMinWidth(leftBtnBox.getPrefWidth());
            calisanBtn.setMinHeight(75);
            calisanBtn.setStyle(
                    "-fx-background-color: linear-gradient(to top, #FFFFFF, #FF6666); " +
                            "-fx-text-fill: black;" +
                    "-fx-font-size: 16px;"
            );


            calisanBtn.setOnAction(actionEvent -> {

                try {
                    SwitchSceneService.getInstance().switchToCalisanlar(actionEvent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        int column=0;
        int row=0;

        for(Recete recete:receteService.getAllRecete()){
            if(column==4){
                column=0;
                row++;
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/ilacotomasyonu/receteItem.fxml"));
            try {
                AnchorPane pane = fxmlLoader.load();
                ReceteItemController controller = fxmlLoader.getController();
                controller.setRecete(recete);
                controller.onDisplay();
                receteGrid.add(pane, column++, row);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setPersonal(Personel personel) {
        this.personel = personel;
    }

    @FXML
    protected void onProfilClick(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToProfil(actionEvent);
    }

    @FXML
    protected void onReceteEkleClick(ActionEvent actionEvent) throws IOException{
        SwitchSceneService.getInstance().switchToReceteEkle(actionEvent);
    }

    @FXML
    protected void onIlacDeposuClick(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToDepo(actionEvent);
    }

    @FXML
    protected void onSatinAlClick(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToIlacEkle(actionEvent);
    }

    @FXML
    protected void onCikisClick(ActionEvent actionEvent) throws IOException{
        MainAppService.getInstance().setPersonal(null);
        SwitchSceneService.getInstance().switchToLogin(actionEvent);
    }

    public void onDisplay() {
    }

}