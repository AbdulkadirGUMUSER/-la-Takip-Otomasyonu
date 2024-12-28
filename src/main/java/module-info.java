module com.example.ilacotomasyonu {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.example.ilacotomasyonu to javafx.fxml;
    exports com.example.ilacotomasyonu;
}