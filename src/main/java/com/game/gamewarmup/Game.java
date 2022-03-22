package com.game.gamewarmup;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Game extends Canvas {

    public static final int SIZE = 16;
    public static final int LENGTH = 512;

    GraphicsContext context;
    Grid grid;

    public Game() {
        super(LENGTH, LENGTH);
        grid = new Grid(LENGTH, SIZE);
        context = getGraphicsContext2D();
        run();
    }

    private void run() {
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                //input - handled by event loop
                update();
                render();
            }
        }.start();
    }

    private void update() {

    }

    private void render() {
        grid.render(context);

    }

}
