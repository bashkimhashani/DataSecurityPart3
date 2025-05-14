module com.example.datasecuritypart3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.datasecuritypart3 to javafx.fxml;
    exports com.example.datasecuritypart3;
}