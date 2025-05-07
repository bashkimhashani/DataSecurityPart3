module com.example.datasecuritypart3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datasecuritypart3 to javafx.fxml;
    exports com.example.datasecuritypart3;
}