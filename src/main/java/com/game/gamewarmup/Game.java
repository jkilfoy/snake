package com.game.gamewarmup;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class Game extends Canvas {

    public static final int SIZE = 16;
    public static final int LENGTH = 512;
    public static final int BORDER_SIZE = 16;

    GraphicsContext context;
    World world;

    public Game() {
        super(LENGTH, LENGTH);
        world = new World(LENGTH, SIZE, BORDER_SIZE);
        addEventHandler(KeyEvent.KEY_PRESSED, world.getSnake());
        setFocusTraversable(true);
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
        // move snake

        // detect collision

        // resolve collisions
    }

    private void render() {
        world.render(context);

    }

}
