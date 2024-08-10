package com.example.gamestore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class GameDetailController {

    @FXML
    private Label nameLabel; // Label to display the game's name

    @FXML
    private Label releaseDateLabel; // Label to display the game's release date

    @FXML
    private Label descriptionLabel; // Label to display the game's description

    @FXML
    private ImageView backgroundImageView; // ImageView to display the game's background image

    private Game game; // The Game object containing details to display

    /**
     * Sets the game details in the UI components.
     *
     * @param game the Game object containing the details to display
     */
    public void setGame(Game game) {
        this.game = game; // Store the game object
        nameLabel.setText(game.getName()); // Set the game's name on the nameLabel
        releaseDateLabel.setText("Released on: " + game.getReleaseDate()); // Set the release date on the releaseDateLabel
        descriptionLabel.setText(game.getDescription()); // Set the game's description on the descriptionLabel
        if (game.getBackgroundImageUrl() != null && !game.getBackgroundImageUrl().isEmpty()) {
            // If the background image URL is not empty, set the image in the ImageView
            backgroundImageView.setImage(new Image(game.getBackgroundImageUrl()));
        }
    }

    /**
     * Handles the action for the back button to close the details window.
     *
     * @param event the ActionEvent triggered by the back button
     */
    @FXML
    private void handleBackButton(ActionEvent event) {
        // Close the current window
        Stage stage = (Stage) nameLabel.getScene().getWindow(); // Get the current window
        stage.close(); // Close the window
    }
}
