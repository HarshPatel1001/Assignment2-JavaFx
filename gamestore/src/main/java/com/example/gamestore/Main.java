package com.example.gamestore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the main view
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/gamestore/main-view.fxml"));

        // Create a scene with the loaded FXML and set its size
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Increased size for better display

        // Add the CSS stylesheet to style the scene
        scene.getStylesheets().add(getClass().getResource("/com/example/gamestore/style.css").toExternalForm());

        // Set the application icon using an image from resources
        Image icon = new Image(getClass().getResourceAsStream("/com/example/gamestore/icon.png"));
        stage.getIcons().add(icon);

        // Set the title of the application window
        stage.setTitle("Game Store");

        // Set the scene for the stage (window)
        stage.setScene(scene);

        // Display the stage (window)
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch();
    }
}
