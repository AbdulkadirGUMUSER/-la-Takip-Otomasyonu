package com.example.ilacotomasyonu.services;

import com.example.ilacotomasyonu.AnaSayfaController;
import com.example.ilacotomasyonu.ProfilController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchSceneService {

    private static SwitchSceneService instance;

    public static SwitchSceneService getInstance() {
        if (instance == null) {
            instance = new SwitchSceneService();
        }
        return instance;
    }

    public void switchToAnaSayfa(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/anaSayfa-view.fxml"));
        Parent root = loader.load();
        AnaSayfaController anaSayfaController = loader.getController();
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AnaSayfa Ekrani");

        anaSayfaController.onDisplay();
    }

    public void switchToKayitOl(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/kayitOl.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kayit Ekrani");
    }

    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/hello-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Giris Ekrani");
    }

    public void switchToProfil(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/profil.fxml"));
        Parent root = loader.load();
        ProfilController profilController = loader.getController();
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("İlaç Satın Alma");

        profilController.onDisplay();
    }

    public void switchToIlacEkle(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/ilacEkle-view.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("İlaç Satın Alma");
    }

    public void switchToDepo(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/depo.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ilac Deposu");
    }

    public void switchToCalisanlar(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/calisanlar.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calisanlar");
    }

    public void switchToReceteEkle(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ilacotomasyonu/receteEkle.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Recete Ekle");
    }
}
