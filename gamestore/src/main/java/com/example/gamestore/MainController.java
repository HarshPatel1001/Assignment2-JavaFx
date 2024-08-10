package com.example.gamestore;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.List;

public class MainController {

    @FXML
    private TextField searchField; // TextField for user to input search query

    @FXML
    private Button searchButton; // Button to trigger search action

    @FXML
    private Button backButton; // Button to navigate back to home page

    @FXML
    private ListView<Game> gameListView; // ListView to display games

    private final GameService gameService = new GameService(); // Service to fetch game data

    @FXML
    private void initialize() {
        searchButton.setOnAction(event -> searchGames()); // Set action for search button
        gameListView.setOnMouseClicked(this::showGameDetails); // Set action for double-click on game
        gameListView.setCellFactory(listView -> new GameCell()); // Set custom cell factory for ListView
        displayTrendingGames(); // Display trending games when the app loads
        backButton.setOnAction(event -> goBackToHome()); // Set action for back button
    }

    // Method to perform game search based on user input
    private void searchGames() {
        String query = searchField.getText().trim(); // Get the search query
        if (!query.isEmpty()) {
            List<Game> games = gameService.searchGames(query); // Fetch search results
            gameListView.getItems().setAll(games); // Update ListView with search results
            backButton.setVisible(true); // Show back button when search results are displayed
        }
    }

    // Method to display trending games
    private void displayTrendingGames() {
        List<Game> trendingGames = gameService.getTrendingGames(); // Fetch trending games
        gameListView.getItems().setAll(trendingGames); // Update ListView with trending games
        backButton.setVisible(false); // Hide back button on home page
    }

    // Method to show game details in a new window on double-click
    private void showGameDetails(MouseEvent event) {
        if (event.getClickCount() == 2) { // Double-click to show details
            Game selectedGame = gameListView.getSelectionModel().getSelectedItem(); // Get selected game
            if (selectedGame != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gamestore/game-detail-view.fxml"));
                    Parent root = loader.load();

                    GameDetailController controller = loader.getController();
                    controller.setGame(selectedGame); // Pass selected game to detail view

                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL); // Block interaction with the main window
                    stage.setTitle(selectedGame.getName());
                    stage.setScene(new Scene(root));
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace(); // Handle exceptions
                }
            }
        }
    }

    // Method to navigate back to the home page
    @FXML
    private void goBackToHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gamestore/main-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) searchField.getScene().getWindow(); // Get current stage
            stage.setScene(new Scene(root)); // Set new scene to home view
            stage.show();

        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
}
