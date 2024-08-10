package com.example.gamestore;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    // API key for accessing the RAWG API
    private static final String API_KEY = "f2ed114f4b6d445ca565684e58a5f9d7";

    /**
     * Searches for games based on the provided game name.
     *
     * @param gameName the name of the game to search for
     * @return a list of games that match the search criteria
     */
    public List<Game> searchGames(String gameName) {
        // Construct the URL for searching games
        return fetchGames("https://api.rawg.io/api/games?key=" + API_KEY + "&search=" + gameName);
    }

    /**
     * Retrieves a list of trending games.
     *
     * @return a list of trending games
     */
    public List<Game> getTrendingGames() {
        // Construct the URL for fetching trending games
        return fetchGames("https://api.rawg.io/api/games?key=" + API_KEY + "&ordering=-added");
    }

    /**
     * Fetches games from the given API URL and parses the response.
     *
     * @param apiUrl the URL to fetch games from
     * @return a list of games parsed from the API response
     */
    private List<Game> fetchGames(String apiUrl) {
        List<Game> games = new ArrayList<>();
        try {
            URL url = new URL(apiUrl); // Create a URL object with the given API URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection to the URL
            connection.setRequestMethod("GET"); // Set the request method to GET

            int responseCode = connection.getResponseCode(); // Get the HTTP response code
            if (responseCode == 200) { // Check if the response code indicates success
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the response
                StringBuilder result = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    result.append(inputLine); // Append each line of the response
                }
                in.close(); // Close the BufferedReader

                JsonElement jsonElement = JsonParser.parseString(result.toString()); // Parse the JSON response
                JsonObject jsonObject = jsonElement.getAsJsonObject(); // Get the root JSON object
                JsonArray jsonArray = jsonObject.getAsJsonArray("results"); // Get the array of game results

                // Iterate over each game in the results array
                for (JsonElement element : jsonArray) {
                    JsonObject gameJson = element.getAsJsonObject(); // Get the game JSON object
                    Game game = new Game();
                    game.setName(gameJson.get("name").getAsString()); // Set the game's name
                    game.setReleaseDate(gameJson.get("released").getAsString()); // Set the release date
                    game.setBackgroundImageUrl(gameJson.get("background_image").getAsString()); // Set the background image URL
                    // Set the description if available; otherwise, set a default message
                    game.setDescription(gameJson.has("description") ? gameJson.get("description").getAsString() : "No description available");
                    games.add(game); // Add the game to the list
                }
            } else {
                System.out.println("Error: Server returned response code " + responseCode); // Print an error message if the response code is not 200
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        }
        return games; // Return the list of games
    }
}
