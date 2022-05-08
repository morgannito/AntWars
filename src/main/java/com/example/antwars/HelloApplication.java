package com.example.antwars;

import Map.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.time.Duration;


public class HelloApplication extends Application {

    static Map map;

    public static void main(String[] args) {
        map = new Map(20, 20);
        map.initMap();
        launch(HelloApplication.class, args);
    }

    @Override
    public void start(Stage stage) {
        System.setProperty("prism.forceGPU", "true");
        System.setProperty("prism.order", "d3d,sw");
        Group root = new Group();
        root.setCache(true);
        root.setCacheHint(CacheHint.SPEED);

        Canvas canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // crée une scène
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();
        // get timestamp
        long start = System.nanoTime();
        long duration = Duration.ofMinutes(2).toNanos();
        // crée une instance de l'animation
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // stop la partie au bout de 2 minutes
                if (now>duration+start) {
                    this.stop();
                // dessine le canvas de fin de partie si la partie est terminée
                }else {
                    // dessine le canvas
                    map.displayFx(gc);
                    map.displayAnt(gc);
                }
            }
        };
        // démarre l'animation
        timer.start();
    }
}



