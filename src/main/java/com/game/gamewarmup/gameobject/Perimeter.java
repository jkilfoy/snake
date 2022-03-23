package com.game.gamewarmup.gameobject;

import com.game.gamewarmup.util.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Perimeter extends Rectangle {

    public Perimeter(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public void render(GraphicsContext graphics) {
        graphics.setFill(Color.BLACK);
        graphics.fillRect(x1, y1, Math.abs(getWidth()), Math.abs(getHeight()));
    }
}
