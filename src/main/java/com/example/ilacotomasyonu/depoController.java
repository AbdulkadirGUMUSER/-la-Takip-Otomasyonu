package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.IlacManager;
import com.example.ilacotomasyonu.backend.business.IlacService;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.entities.Recete;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class depoController {

    @FXML
    private GridPane depoGrid;

    private IlacService ilacService;

    public depoController(){
        ilacService=new IlacManager();
    }

    @FXML
    protected void onGeriButtonClick(ActionEvent actionEvent) throws IOException{
        SwitchSceneService.getInstance().switchToAnaSayfa(actionEvent);
    }

    public void initialize(){
        int column=0;
        int row=0;

        for(Ilac ilac:ilacService.getAllIlac()){
            if(column==5){
                column=0;
                row++;
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/ilacotomasyonu/ilacItem.fxml"));
            try {
                AnchorPane pane = fxmlLoader.load();
                ilacItemController controller = fxmlLoader.getController();
                controller.setIlac(ilac);
                controller.onDisplay();
                depoGrid.add(pane, column++, row);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
