package com.game.gamewarmup;

import com.game.gamewarmup.gameobject.Food;
import com.game.gamewarmup.gameobject.Perimeter;
import com.game.gamewarmup.gameobject.Snake;
import com.game.gamewarmup.gameobject.SnakeSegment;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.Getter;

@Getter
public class World {

    public static final double FOOD_WIDTH = 16;
    public static final double SNAKE_WIDTH = 32;
    public static final double FOOD_FROM_BORDER_DISTANCE = 8;
    public static final double InIT_SNAKE_GROWTH = 24;
    public static final double SNAKE_GROWTH_InC = 4;

    // WORLD PROPERTIES
    double width;
    double height;
    double borderWidth;
    boolean gameOver;
    int growthCounter;

    // GAME OBJECTS
    Snake snake;
    Food food;
    Perimeter[] perimeter;

    public World(double width, double height, double borderWidth) {
        this.width = width;
        this.height = height;
        this.borderWidth = borderWidth;
        gameOver = false;
        growthCounter = 0;

        snake = new Snake(Color.GREEN, SNAKE_WIDTH);
        perimeter = new Perimeter[4];
        perimeter[0] = new Perimeter(0, 0, width, borderWidth);                 // top
        perimeter[1] = new Perimeter(width - borderWidth, 0, width, height);    // right
        perimeter[2] = new Perimeter(0, height - borderWidth, width, height);   // bottom
        perimeter[3] = new Perimeter(0, 0, borderWidth, height);                // left
        makeFood();
    }

    public void makeFood() {
        double foodX = Math.random() * (width - 2*borderWidth - FOOD_WIDTH) + borderWidth;
        double foodY = Math.random() * (height - 2*borderWidth - FOOD_WIDTH) + borderWidth;
        food = new Food(foodX, foodY, foodX + FOOD_WIDTH, foodY + FOOD_WIDTH);
    }

    public void gameOver() {
        gameOver = true;
        System.exit(0);
    }

    public void update() {
        if (gameOver) return;
        // move snake
        snake.update();

        // game over collision detection
        for (Perimeter p : perimeter) {
            if (snake.getHead().intersects(p)) {
                gameOver();
                return;
            }
        }
        for (SnakeSegment segment : snake.getBody()) {
            if (snake.getHead().intersects(segment)) {
                gameOver();
                return;
            }
        }

        // food collision detection
        if (snake.getHead().intersects(food)) {
            double newGrowth = InIT_SNAKE_GROWTH + growthCounter * SNAKE_GROWTH_InC;
            snake.grow(newGrowth);
            makeFood();
            growthCounter++;
        }
    }

    public void render(GraphicsContext graphics) {
        graphics.setFill(Color.WHEAT);
        graphics.fillRect(0, 0, width, height);
        snake.render(graphics);
        food.render(graphics);
        for (Perimeter p : perimeter) {
            p.render(graphics);
        }
    }
}
