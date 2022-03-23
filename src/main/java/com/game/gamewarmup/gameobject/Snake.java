package com.game.gamewarmup.gameobject;

import com.game.gamewarmup.util.Direction;
import com.game.gamewarmup.deque.Deque;
import com.game.gamewarmup.util.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Snake implements EventHandler<KeyEvent> {

    public static final double INIT_X = 100;
    public static final double INIT_Y = 100;
    public static final double INIT_SPEED = 4;
    public static final Direction INIT_DIRECTION = Direction.DOWN;

    private Color color;
    private double width;               // the width of the snake
    private Rectangle head;             // the head of the snake
    private double speed;               // how fast the snake is moving in pixels/tick
    private Direction direction;        // which direction the snake is moving in
    private Deque<SnakeSegment> body;   // each segment of the snake's body

    public Snake(Color color, double width) {
        this.color = color;
        this.width = width;
        speed = INIT_SPEED;
        direction = INIT_DIRECTION;
        head = new Rectangle(INIT_X, INIT_Y, INIT_X + width, INIT_Y + width);
        body = new Deque<>();
    }

    public void update() {
        // move the snake's head
        head.increase(speed, direction);
        head.decrease(speed, direction);

        // slither the first and last body segments of the snake
        if (!body.isEmpty()) {
            body.getFirst().increase(speed);
            body.getLast().decrease(speed);
        }

        // if the caboose is now empty, remove it
        if (body.getLast().getLength() <= 0) {
            body.removeLast();
        }
    }

    public void render(GraphicsContext graphics) {
        head.render(graphics, color);
        for (SnakeSegment segment : body) {
            segment.render(graphics, color);
        }
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W:
                direction = Direction.UP;
                break;
            case A:
                direction = Direction.LEFT;
                break;
            case S:
                direction = Direction.DOWN;
                break;
            case D:
                direction = Direction.RIGHT;
                break;
        }
    }
}
