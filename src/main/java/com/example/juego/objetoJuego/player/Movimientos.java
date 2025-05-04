package com.example.juego.objetoJuego.player;

import javafx.event.EventHandler;

import javafx.scene.input.KeyEvent;

public class Movimientos implements EventHandler<KeyEvent> {
    private boolean arriba, abajo, izquierda, derecha;

    @Override
    public void handle(KeyEvent event) {
        boolean presionar = event.getEventType() == KeyEvent.KEY_PRESSED;

        switch (event.getCode()) {
            case W -> arriba = presionar;
            case S -> abajo = presionar;
            case A -> izquierda = presionar;
            case D -> derecha = presionar;
        }
    }

    public boolean isArriba() { return arriba; }
    public boolean isAbajo() { return abajo; }
    public boolean isIzquierda() { return izquierda; }
    public boolean isDerecha() { return derecha; }
}
