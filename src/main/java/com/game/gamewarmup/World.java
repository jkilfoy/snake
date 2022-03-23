package com.game.gamewarmup;

import com.game.gamewarmup.gameobject.Food;
import com.game.gamewarmup.gameobject.Perimeter;
import com.game.gamewarmup.gameobject.Snake;
import com.game.gamewarmup.util.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.Getter;

@Getter
public class World {

    public static final double FOOD_WIDTH = 16;
    public static final double SNAKE_WIDTH = 32;

    // WORLD PROPERTIES
    double width;
    double height;
    double borderWidth;

    // GAME OBJECTS
    Snake snake;
    Food food;
    Perimeter[] perimeter;



    public World(double width, double height, double borderWidth) {
        this.width = width;
        this.height = height;
        this.borderWidth = borderWidth;

        snake = new Snake(Color.GREEN, SNAKE_WIDTH);
        perimeter = new Perimeter[4];
        perimeter[0] = new Perimeter(0, 0, width, borderWidth);                 // top
        perimeter[1] = new Perimeter(width - borderWidth, 0, width, height);    // right
        perimeter[2] = new Perimeter(0, height - borderWidth, width, height);   // bottom
        perimeter[3] = new Perimeter(0, 0, borderWidth, height);                // left
    }

    public void makeFood() {
        double foodX = Math.random() * (width-FOOD_WIDTH);
        double foodY = Math.random() * (height-FOOD_WIDTH);
        food = new Food(foodX, foodY, foodX + FOOD_WIDTH, foodY + FOOD_WIDTH);
    }

    public void update() {
        snake.update();
    }

    public void render(GraphicsContext graphics) {
        snake.render(graphics);
        food.render(graphics);
        for (Perimeter p : perimeter) {
            p.render(graphics);
        }
    }

    public void moveSnake() {

    }

}
