package com.game.gamewarmup;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Main app = null;
    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws IOException {
        app = this;
        stage = primaryStage;
        stage.setTitle("This is my game!!!!");
        Game game = new Game();
        Group root = new Group(game);
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}