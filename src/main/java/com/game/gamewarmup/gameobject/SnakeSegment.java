package com.game.gamewarmup.gameobject;

import com.game.gamewarmup.util.Direction;
import com.game.gamewarmup.util.Rectangle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SnakeSegment extends Rectangle {

    private Direction direction;    // the direction this segment will move in

    public SnakeSegment(double x1, double y1, double x2, double y2, Direction direction) {
        super(x1, y1, x2, y2);
        this.direction = direction;
    }

    public double getLength() {
        switch (direction) {
            case LEFT:
            case RIGHT:
                return getWidth();
            case UP:
            case DOWN:
                return getHeight();
        }
        return 0;
    }

    public void increase(double length) {
        increase(length, direction);
    }

    public void decrease(double length) {
        decrease(length, direction);
    }
}
