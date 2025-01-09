module com.example.zadatak1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.example.zadatak1 to javafx.fxml;
    exports com.example.zadatak1;
}