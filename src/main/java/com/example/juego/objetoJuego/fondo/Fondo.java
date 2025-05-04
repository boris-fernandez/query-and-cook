package com.example.juego.objetoJuego.fondo;

import com.example.juego.objetoJuego.ObjetoJuego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fondo extends ObjetoJuego {

    public Fondo(int posicionX, int posicionY, String nombreImagen) {
        super(posicionX, posicionY, nombreImagen);
    }

    @Override
    public void dibujar(GraphicsContext grafico, double ancho, double alto) {
        grafico.drawImage(super.nombreImagen, 0, 0, ancho, alto);
    }
}
