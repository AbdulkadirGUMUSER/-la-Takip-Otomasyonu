package com.example.ilacotomasyonu;

import com.example.ilacotomasyonu.backend.business.IlacManager;
import com.example.ilacotomasyonu.backend.business.IlacService;
import com.example.ilacotomasyonu.backend.business.ReceteManager;
import com.example.ilacotomasyonu.backend.business.ReceteService;
import com.example.ilacotomasyonu.backend.entities.Ilac;
import com.example.ilacotomasyonu.backend.entities.Recete;
import com.example.ilacotomasyonu.backend.exceptions.IlacException;
import com.example.ilacotomasyonu.services.SwitchSceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class
ReceteItemController {

    @FXML
    private Label hastaAdiLbl;

    @FXML
    private Label doktorAdiLbl;

    @FXML
    private GridPane ilacGrid;

    private Recete recete;

    Alert alert = new Alert(Alert.AlertType.NONE);

    private ReceteService receteService;
    private IlacService ilacService;

    public ReceteItemController() {
        receteService=new ReceteManager();
        ilacService=new IlacManager();
    }

    public void setRecete(Recete recete) {
        this.recete = recete;
    }

    public void onDisplay(){
        hastaAdiLbl.setText(recete.getHastaAdi());
        doktorAdiLbl.setText(recete.getDoktorAdi());

        int row=0;
        int col=0;
        for(Ilac ilac : recete.getIlacList()) {
            if(col==1){
                row++;
                col=0;
            }

            ilacGrid.add(new Label(ilac.getName()+" "+ilac.getSayisi()+" kutu"), col++, row);
        }
    }

    @FXML
    protected void onSilBtnClicked(ActionEvent actionEvent) throws IOException {
        for(Ilac ilac : recete.getIlacList()) {
            Ilac newIlac=new Ilac(ilac.getId(),ilac.getName(),ilac.getSayisi(),ilac.getFiyat());
            newIlac.setSayisi(ilacService.getById(ilac.getId()).getSayisi()-ilac.getSayisi());

            try {
                ilacService.updateIlac(newIlac);
            } catch (IlacException e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Depoda yeterli ilaç bulunmamaktadır");
                alert.showAndWait();
                return;
            }
        }
        receteService.deleteRecete(recete);

        SwitchSceneService.getInstance().switchToAnaSayfa(actionEvent);
    }

}
