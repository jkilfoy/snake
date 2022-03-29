package com.game.gamewarmup;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class Game extends Canvas {

    public static final int SIZE = 16;
    public static final int WORLD_SIZE = 512;
    public static final int BORDER_SIZE = 16;

    GraphicsContext context;
    World world;

    public Game() {
        super(WORLD_SIZE, WORLD_SIZE);
        world = new World(WORLD_SIZE, WORLD_SIZE, BORDER_SIZE);
        context = getGraphicsContext2D();

        // add event handler
        addEventHandler(KeyEvent.KEY_PRESSED, world.getSnake());
        setFocusTraversable(true);

        // run the game
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
        world.update();
    }

    private void render() {
        world.render(context);
        HUD.render(context, world);
    }

}
