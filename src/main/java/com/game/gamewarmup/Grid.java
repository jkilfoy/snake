package com.game.gamewarmup;

import javafx.beans.NamedArg;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Grid {

    Tile[][] grid;
    double length;
    double tileSize;

    public Grid(double length, int size) {
        grid = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = Tile.EMPTY;
            }
        }
        this.length = length;
        tileSize = length / size;
    }

    public void render(GraphicsContext graphics) {
        for (int row = 0; row < grid.length; row++) {
            double y = row * tileSize;
            for (int col = 0; col < grid.length; col++) {
                double x = col * tileSize;
                switch (grid[row][col])  {
                    case SNAKE_HEAD:
                        graphics.setFill(Color.MAGENTA);
                        break;
                    case SNAKE_BODY:
                        graphics.setFill(Color.GREEN);
                        break;
                    case FOOD:
                        graphics.setFill(Color.RED);
                        break;
                    case EMPTY:
                        graphics.setFill(Color.WHEAT);
                        break;
                }
                graphics.fillRect(x, y, tileSize, tileSize);
            }
        }

        graphics.setStroke(Color.BLACK);
        graphics.setLineWidth(16);
        graphics.strokeRect(0, 0, length, length);
    }

    public void moveSnake() {

    }

}
