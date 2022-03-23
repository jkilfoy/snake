package com.game.gamewarmup.util;

import com.game.gamewarmup.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rectangle {

    protected double x1, y1;     // the top left of the rectangle
    protected double x2, y2;     // the bottom right of the rectangle

    /**
     * Increases the size of this rectangle by translating the boundary point by the specified length
     * @param scalar the amount to increase the size by
     * @param direction the direction to increase the rectangle in
     */
    public void increase(double scalar, Direction direction) {
        switch (direction) {
            case LEFT:
                x1 -= scalar;
                break;
            case UP:
                y1 -= scalar;
                break;
            case RIGHT:
                x2 += scalar;
            case DOWN:
                y2 += scalar;
        }
    }

    /**
     * Decreases the size of this rectangle by translating the boundary point by the specified length
     * @param scalar the amount to decrease the size by
     * @param direction the direction to decrease the rectangle in
     */
    public void decrease(double scalar, Direction direction) {
        switch (direction) {
            case LEFT:
                x2 -= scalar;
                break;
            case UP:
                y2 -= scalar;
                break;
            case RIGHT:
                x1 += scalar;
            case DOWN:
                y1 += scalar;
        }
    }

    /**
     * Returns the width, negative if the left boundary crosses the right
     * @return the width of the rectangle
     */
    public double getWidth() {
        return x2 - x1;
    }

    /**
     * Returns the height, negative if the top boundary crosses the bottom
     * @return the height of the rectangle
     */
    public double getHeight() {
        return y2 - y1;
    }

    public boolean intersects(Rectangle other) {
        return  x2 > other.getX1() && x1 < other.getX2()  // within x bounds
            &&  y2 > other.getY1() && y1 < other.getY2();  // within y bounds
    }

    public void render(GraphicsContext graphics, Color color) {
        graphics.setFill(color);
        graphics.fillRect(x1, y1, Math.abs(getWidth()), Math.abs(getHeight()));
    }
}
