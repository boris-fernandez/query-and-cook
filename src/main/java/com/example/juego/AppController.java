package com.example.juego;

import com.example.juego.objetoJuego.fondo.Fondo;
import com.example.juego.objetoJuego.player.Movimientos;
import com.example.juego.objetoJuego.player.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.DisplayMode;

public class AppController {
    // Tamaño original de cada bloque (en píxeles)
    private final int originalTileSize = 20;
    // Factor de escala para aumentar el tamaño de cada bloque
    private final int scale = 4;
    // El tamaño final de cada bloque (en píxeles) después de aplicar la escala
    private final int titleSize = originalTileSize * scale;
    private double tileSize = titleSize;

    // Número máximo de columnas (bloques) que caben en la pantalla
    private final int maxScreenCol = 16;
    // Número máximo de filas (bloques) que caben en la pantalla
    private final int maxScreenRow = 11;


    private int screenWidth = titleSize * maxScreenCol; // 1280 píxeles de ancho
    private int screenHeight = titleSize * maxScreenRow; // 880 píxeles de alto


    private GraphicsContext grafico;
    private Scene scene;
    private Canvas canvas;
    AnimationTimer timer;
    private Movimientos evento;

    private Player player;
    private Fondo fondo;

    public AppController() {
        player = new Player(100, 100, "goku.jpeg", 2);
        timer = new CicloJuego(this);
        evento = new Movimientos();
        fondo = new Fondo(0, 0, "fondo1.jpeg");

    }

    public Scene startGame() {
        // Obtener resolución real del monitor
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        DisplayMode displayMode = device.getDisplayMode();

        Group root = new Group();
        scene = new Scene(root, screenWidth, screenHeight);

        canvas = new Canvas(screenWidth, screenHeight);
        root.getChildren().add(canvas);
        grafico = canvas.getGraphicsContext2D();

        return scene;
    }



    public void pintar() {
        double ancho = canvas.getWidth();
        double alto = canvas.getHeight();

        fondo.dibujar(grafico, ancho, alto);

        player.dibujar(grafico, ancho, alto);
    }


    public void actualizarMovimiento() {
        if (evento.isArriba()) player.moverArriba(player.getVelocidad());
        if (evento.isAbajo()) player.moverAbajo(player.getVelocidad());
        if (evento.isIzquierda()) player.moverIzquierda(player.getVelocidad());
        if (evento.isDerecha()) player.moverDerecha(player.getVelocidad());
    }

    public void gestionEventos() {
        scene.setOnKeyPressed(evento);
        scene.setOnKeyReleased(evento);
    }


    public void cicloJuego() {
        timer.start();
    }
}
