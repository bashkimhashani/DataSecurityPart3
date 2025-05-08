package com.example.datasecuritypart3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CVCipher extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Applikacioni Caesar & Vigenère Chiper");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Chipher Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
