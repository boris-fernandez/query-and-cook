package com.example.juego;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        AppController controller = new AppController();

        Scene scene = controller.startGame();
        controller.pintar();
        controller.gestionEventos();
        controller.cicloJuego();
        stage.setTitle("Query and Cook");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}