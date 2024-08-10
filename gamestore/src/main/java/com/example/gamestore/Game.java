package com.example.gamestore;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Game {

    private String name; // Name of the game

    @SerializedName("released")
    private String releaseDate; // Release date of the game

    @SerializedName("background_image")
    private String backgroundImageUrl; // URL for the background image of the game

    @SerializedName("description")
    private String description; // Description of the game

    @SerializedName("short_screenshots")
    private List<Screenshot> screenshots; // List of screenshots for the game

    // Getters and setters

    /**
     * Gets the name of the game.
     *
     * @return the name of the game
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the game.
     *
     * @param name the name of the game
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the release date of the game.
     *
     * @return the release date of the game
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the game.
     *
     * @param releaseDate the release date of the game
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Gets the URL for the background image of the game.
     *
     * @return the URL for the background image
     */
    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    /**
     * Sets the URL for the background image of the game.
     *
     * @param backgroundImageUrl the URL for the background image
     */
    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    /**
     * Gets the description of the game.
     *
     * @return the description of the game
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the game.
     *
     * @param description the description of the game
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of screenshots for the game.
     *
     * @return the list of screenshots
     */
    public List<Screenshot> getScreenshots() {
        return screenshots;
    }

    /**
     * Sets the list of screenshots for the game.
     *
     * @param screenshots the list of screenshots
     */
    public void setScreenshots(List<Screenshot> screenshots) {
        this.screenshots = screenshots;
    }

    @Override
    public String toString() {
        return name + " (" + releaseDate + ")"; // Returns a string representation of the game
    }

    public static class Screenshot {
        @SerializedName("image")
        private String imageUrl; // URL for the screenshot image

        /**
         * Gets the URL for the screenshot image.
         *
         * @return the URL for the screenshot image
         */
        public String getImageUrl() {
            return imageUrl;
        }

        /**
         * Sets the URL for the screenshot image.
         *
         * @param imageUrl the URL for the screenshot image
         */
        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
