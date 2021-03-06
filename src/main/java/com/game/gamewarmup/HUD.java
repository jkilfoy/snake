package com.game.gamewarmup;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HUD {

    public static void render(GraphicsContext graphics, World world) {
        if (world.isDisplayHUD()) {
            graphics.setFill(Color.RED);
            graphics.setFont(Font.font("Verdana", FontWeight.BLACK, 28));
            graphics.fillText("Score: " + world.getScore(), 16, 8 + World.TOP_BORDER_OFFSET);
            if (world.isGameOver()) {
                graphics.fillText("G A M E   O V E R", world.getWidth()/4, world.getHeight()/3);
            }
            else if (world.isPaused()) {
                graphics.fillText("P A U S E D", world.getWidth()/3, world.getHeight()/3);
            }
        }
    }

}
