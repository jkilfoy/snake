module com.game.gamewarmup {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.game.gamewarmup to javafx.fxml;
    exports com.game.gamewarmup;
    exports com.game.gamewarmup.gameobject;
    opens com.game.gamewarmup.gameobject to javafx.fxml;
    exports com.game.gamewarmup.util;
    opens com.game.gamewarmup.util to javafx.fxml;
}