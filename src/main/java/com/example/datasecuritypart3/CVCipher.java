package com.example.datasecuritypart3;

import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.*;
import javafx.scene.control.*;

public class CVCipher extends Application {

    private TextField keyField = new TextField();
    private TextField filePathField = new TextField();
    private TextField savePathField = new TextField();
    private TextArea messageArea = new TextArea();
    private ComboBox<String> algorithmBox = new ComboBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Caesar & Vigenère Cipher Tool");
    }
}
