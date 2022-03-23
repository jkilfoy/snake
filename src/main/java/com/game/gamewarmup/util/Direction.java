package com.game.gamewarmup.util;

public enum Direction {
    UP, LEFT, RIGHT, DOWN;

    public Direction getOpposite() {
        return getOpposite(this);
    }

    public boolean sameAxis(Direction other) {
        return this.equals(other) || this.equals(other.getOpposite());
    }

    public static Direction getOpposite(Direction direction) {
        switch (direction) {
            case RIGHT:
                return Direction.LEFT;
            case UP:
                return Direction.DOWN;
            case LEFT:
                return Direction.RIGHT;
            case DOWN:
                return Direction.UP;
        }
        return null; // never happens
    }
}
