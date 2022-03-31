package com.game.gamewarmup;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HUD {

    public static void render(GraphicsContext graphics, World world) {
        if (world.isDisplayHUD()) {
            graphics.setFill(Color.RED);
            graphics.setFont(Font.font("Verdana", FontWeight.BLACK, 28));
            graphics.fillText("Score: " + world.getScore(), 16, 12);
            if (world.isPaused()) {
                graphics.fillText("P A U S E D", world.getWidth()/3, world.getHeight()/3);
            }
        }
    }

}
