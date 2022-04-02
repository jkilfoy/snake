package com.game.gamewarmup.gameobject;

import com.game.gamewarmup.util.Direction;
import com.game.gamewarmup.deque.Deque;
import com.game.gamewarmup.util.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import lombok.Getter;

@Getter
public class Snake implements EventHandler<KeyEvent> {

    public static final double INIT_X = 100;
    public static final double INIT_Y = 100;
    public static final double INIT_SPEED = 4;
    public static final double SPEED_INC = 0.5;
    public static final Direction INIT_DIRECTION = Direction.DOWN;

    private Color color;
    private double width;               // the width of the snake
    private Rectangle head;             // the head of the snake
    private double speed;               // how fast the snake is moving in pixels/tick
    private double growing;             // the amount of growing the snake will do
                                        // the snake is growing as long as growing > 0
    private Direction direction;        // which direction the snake is moving in
    private Deque<SnakeSegment> body;   // each segment of the snake's body

    public Snake(Color color, double width) {
        this.color = color;
        this.width = width;
        speed = INIT_SPEED;
        direction = INIT_DIRECTION;
        growing = 0;
        head = new Rectangle(INIT_X, INIT_Y, INIT_X + width, INIT_Y + width);
        body = new Deque<>();
    }

    /**
     * Adds a front body segment directly "behind" the head w.r.t. the specified direction
     * @param direction the direction the segment will move in
     */
    public void addFrontSegment(Direction direction) {
        Rectangle r = head.getBoundary(direction.getOpposite());
        SnakeSegment segment = new SnakeSegment(r.getX1(), r.getY1(), r.getX2(), r.getY2(), direction);
        body.addFirst(segment);
    }

    public void grow(double amount) {
        growing += amount;
        speed += SPEED_INC;
    }

    public void update() {
        // move the snake's head
        head.increase(speed, direction);
        head.decrease(speed, direction);

        // add a body if there isn't one and the snake is growing
        if (body.isEmpty() && growing > 0) {
            addFrontSegment(direction);
        }
        // slither the first and last body segments of the snake
        else if (!body.isEmpty()) {
            body.getFirst().increase(speed);
            if (growing > 0) {
                growing -= speed;
            } else {
                body.getLast().decrease(speed);
                // if the caboose is now empty, remove it
                if (body.getLast().getLength() <= 0) {
                    body.removeLast();
                }
            }
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
        // compute new direction
        Direction newDirection = direction;
        switch (keyEvent.getCode()) {
            case W:
            case UP:
                if (direction.sameAxis(Direction.UP)) return;
                newDirection = Direction.UP;
                break;
            case A:
            case LEFT:
                if (direction.sameAxis(Direction.LEFT)) return;
                newDirection = Direction.LEFT;
                break;
            case S:
            case DOWN:
                if (direction.sameAxis(Direction.DOWN)) return;
                newDirection = Direction.DOWN;
                break;
            case D:
            case RIGHT:
                if (direction.sameAxis(Direction.RIGHT)) return;
                newDirection = Direction.RIGHT;
                break;
        }

        // do not turn if there's not enough space
        if (body.size() >= 2 && body.getFirst().getLength() < width) {
            switch (body.get(1).getDirection()) {
                case UP:
                    if (newDirection.equals(Direction.DOWN)) return;
                    break;
                case LEFT:
                    if (newDirection.equals(Direction.RIGHT)) return;
                    break;
                case DOWN:
                    if (newDirection.equals(Direction.UP)) return;
                    break;
                case RIGHT:
                    if (newDirection.equals(Direction.LEFT)) return;
                    break;
            }
        }

        addFrontSegment(newDirection);
        direction = newDirection;
    }
}
