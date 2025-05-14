package com.example.datasecuritypart3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

        GridPane topPane = new GridPane();
        topPane.setHgap(10);
        topPane.setVgap(10);
        topPane.setPadding(new Insets(10));

        topPane.add(new Label("Key:"), 0, 0);
        topPane.add(keyField, 1, 0);

        Button browseFileBtn = new Button("Browse");
        Button saveFileVtn = new Button("Save");

    }
}
