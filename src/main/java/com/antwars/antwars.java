package com.antwars;

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


public class antwars extends Application {
    public static void main(String[] args) {
        launch(antwars.class, args);
    }

    @Override
    public void start(Stage stage) {
        System.setProperty("prism.forceGPU", "true");
        System.setProperty("prism.order", "d3d,sw");
        System.setProperty("prism.text", "t2d");
        Group root = new Group();
        root.setCache(true);
        root.setCacheHint(CacheHint.SPEED);
        Canvas canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // crée une scène
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setResizable(false);
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
                }else {
                    // dessine le canvas
                    Map.getInstance().displayFx(gc);
                    Map.getInstance().displayAnt(gc);
                }
            }
        };
        // démarre l'animation
        timer.start();
    }
}



