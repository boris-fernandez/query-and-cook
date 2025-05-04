package com.example.juego.objetoJuego;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class ObjetoJuego {
    // Posicion inicial
    protected int posicionX;
    protected int posicionY;
    // Imagen
    protected Image nombreImagen;

    public ObjetoJuego(int posicionX, int posicionY, String nombreImagen) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.nombreImagen = new Image(getClass().getResourceAsStream("/images/" + nombreImagen));
    }

    public abstract void dibujar(GraphicsContext grafico, double ancho, double alto);
}
