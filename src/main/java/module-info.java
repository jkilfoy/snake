module com.game.gamewarmup {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.game.gamewarmup to javafx.fxml;
    exports com.game.gamewarmup;
}