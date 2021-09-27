package br.com.pedro.converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        scene.getStylesheets().add(getClass().getResource("view/main.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Conversor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image(Main.class.getResource("assets/thermometers.png").toExternalForm()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}