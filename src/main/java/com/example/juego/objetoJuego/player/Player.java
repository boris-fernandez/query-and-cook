package com.example.juego.objetoJuego.player;

import com.example.juego.objetoJuego.ObjetoJuego;
import javafx.scene.canvas.GraphicsContext;

public class Player extends ObjetoJuego {
    // Valor que se movera los personaje en cada accion
    private double velocidad;

    public Player(int x, int y, String nombreImagen, double velocidad) {
        super(x, y, nombreImagen);
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void moverArriba(double velocidad) {
        this.posicionY -= this.velocidad;
    }

    public void moverAbajo(double velocidad) {
        this.posicionY += this.velocidad * velocidad;
    }

    public void moverIzquierda(double velocidad) {
        this.posicionX -= this.velocidad * velocidad;
    }

    public void moverDerecha(double velocidad) {
        this.posicionX += this.velocidad * velocidad;
    }

    @Override
    public void dibujar(GraphicsContext grafico, double ancho, double alto) {
        double anchoJugador = ancho * 0.05;
        double altoJugador = alto * 0.10;

        grafico.drawImage(super.nombreImagen, super.posicionX, posicionY, anchoJugador, altoJugador);
    }
}
