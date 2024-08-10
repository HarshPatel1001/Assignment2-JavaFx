package com.example.gamestore;

import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class GameCell extends ListCell<Game> {

    // Container for holding image and name
    private final HBox hbox = new HBox(10);

    // Image view for displaying the game's background image
    private final ImageView imageView = new ImageView();

    // Label for displaying the game's name
    private final Label nameLabel = new Label();

    /**
     * Constructor for GameCell. Initializes the layout and adds the image and label to the HBox.
     */
    public GameCell() {
        hbox.getChildren().addAll(imageView, nameLabel); // Add imageView and nameLabel to HBox
        setGraphic(hbox); // Set HBox as the graphic for this cell
    }

    /**
     * Updates the content of the cell based on the provided Game object.
     *
     * @param game the game object to display in this cell
     * @param empty true if the cell is empty, false otherwise
     */
    @Override
    protected void updateItem(Game game, boolean empty) {
        super.updateItem(game, empty);

        if (empty || game == null) {
            setGraphic(null); // Clear the graphic if the cell is empty
        } else {
            nameLabel.setText(game.getName()); // Set the game's name on the label
            if (game.getBackgroundImageUrl() != null && !game.getBackgroundImageUrl().isEmpty()) {
                // Set the background image for the game if URL is provided
                imageView.setImage(new Image(game.getBackgroundImageUrl()));
                imageView.setFitHeight(60); // Adjust the height of the image
                imageView.setFitWidth(60); // Adjust the width of the image
            } else {
                imageView.setImage(null); // Clear the image if URL is not provided
            }
            setGraphic(hbox); // Set the HBox as the graphic for this cell
        }
    }
}
