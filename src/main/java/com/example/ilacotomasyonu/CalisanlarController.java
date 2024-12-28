package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.CalisanManager;
import com.example.ilacotomasyonu.backend.business.CalisanService;
import com.example.ilacotomasyonu.backend.entities.Calisan;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class CalisanlarController {

    @FXML
    private GridPane calisanlarGrid;

    private CalisanService calisanService;

    public CalisanlarController(){
        calisanService=new CalisanManager();
    }

    @FXML
    protected void onGeriButtonClick(ActionEvent actionEvent) throws IOException {
        SwitchSceneService.getInstance().switchToAnaSayfa(actionEvent);
    }

    public void initialize(){
        int column=0;
        int row=0;

        for(Calisan calisan:calisanService.getAllCalisan()){
            if(column==5){
                column=0;
                row++;
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/ilacotomasyonu/calisanItem.fxml"));
            try {
                AnchorPane pane = fxmlLoader.load();
                CalisanItemController controller = fxmlLoader.getController();
                controller.setCalisan(calisan);
                controller.onDisplay();
                calisanlarGrid.add(pane, column++, row);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
