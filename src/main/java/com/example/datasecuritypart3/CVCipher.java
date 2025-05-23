package com.example.datasecuritypart3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.*;
import java.nio.file.Files;
import javafx.scene.control.Alert;

import java.io.File;

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
        Button saveFileBtn = new Button("Save As");

        filePathField.setPrefWidth(300);
        savePathField.setPrefWidth(300);

        topPane.add(new Label("Input File:"), 0, 1);
        topPane.add(filePathField, 1, 1);
        topPane.add(browseFileBtn, 2, 1);

        topPane.add(new Label("Save To:"), 0, 2);
        topPane.add(savePathField, 1, 2);
        topPane.add(saveFileBtn, 2, 2);

        browseFileBtn.setOnAction(e -> {
            File file = new FileChooser().showOpenDialog(stage);
            if (file != null) filePathField.setText(file.getAbsolutePath());
        });

        saveFileBtn.setOnAction(e -> {
            File file = new FileChooser().showSaveDialog(stage);
            if (file != null) savePathField.setText(file.getAbsolutePath());
        });
        messageArea.setPromptText("Or type your message here...");
        messageArea.setWrapText(true);
        VBox centerBox = new VBox(10, new Label("Message:"), messageArea);
        centerBox.setPadding(new Insets(10));

        HBox bottomPane = new HBox(10);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(10));

        Button encryptBtn = new Button("Encrypt");
        Button decryptBtn = new Button("Decrypt");

        algorithmBox.getItems().addAll("Caesar", "Vigenère");
        algorithmBox.setValue("Caesar");

        encryptBtn.setOnAction(e -> process(true));
        decryptBtn.setOnAction(e -> process(false));

        bottomPane.getChildren().addAll(new Label("Algorithm:"), algorithmBox, encryptBtn, decryptBtn);

        BorderPane root = new BorderPane();
        root.setTop(topPane);
        root.setCenter(centerBox);
        root.setBottom(bottomPane);

        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }

    private void process(boolean encrypt) {
        String key = keyField.getText().trim();
        String algorithm = algorithmBox.getValue();
        String inputText = "";

        try {
            if (!filePathField.getText().isEmpty()) {
                inputText = Files.readString(new File(filePathField.getText()).toPath());
            } else {
                inputText = messageArea.getText();
            }
            String result;
            if (algorithm.equals("Caesar")) {
                int caesarKey = Integer.parseInt(key);
                result = encrypt ? caesarEncrypt(inputText, caesarKey) : caesarDecrypt(inputText, caesarKey);
            } else {
                result = encrypt ? vigenereEncrypt(inputText, key) : vigenereDecrypt(inputText, key);
            }

            if (!savePathField.getText().isEmpty()) {
                Files.writeString(new File(savePathField.getText()).toPath(), result);
                showAlert("Success", "Output saved to file.");
            } else {
                messageArea.setText(result);
            }

        } catch (Exception ex) {
            showAlert("Error", ex.getMessage());
        }
    }
    private String caesarEncrypt(String text, int shift){
        StringBuilder sb  = new StringBuilder();
        for(char c : text.toCharArray()){
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - (shift % 26));
    }

    private String vigenereEncrypt(String text, String key){
        StringBuilder sb = new StringBuilder();
        key = key.toLowerCase();
        int j = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(j % key.length()) - 'a';
                c = (char) ((c - base + shift) % 26 + base);
                j++;
            }
            sb.append(c);
        }
        return sb.toString();
    }

        private String vigenereDecrypt(String text, String key) {
            StringBuilder sb = new StringBuilder();
            key = key.toLowerCase();
            int j = 0;

            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int shift = key.charAt(j % key.length()) - 'a';
                    c = (char) ((c - base - shift + 26) % 26 + base);
                    j++;
                }
                sb.append(c);
            }
            return sb.toString();
        }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}