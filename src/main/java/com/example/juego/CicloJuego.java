package com.example.juego;

import javafx.animation.AnimationTimer;

public class CicloJuego extends AnimationTimer {
    private AppController controller;
    private long lastTime = 0;

    public CicloJuego(AppController controller) {
        this.controller = controller;
    }

    @Override
    public void handle(long now) {
        if (lastTime == 0) {
            lastTime = now;
            return;
        }

        double deltaTime = (now - lastTime) / 1000000000.0;
        lastTime = now;

        controller.actualizarMovimiento();
        controller.pintar();
    }
}
