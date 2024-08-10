module com.example.gamestore {
    // Required JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;

    // Required for JSON parsing with GSON
    requires com.google.gson;

    // Required for HTTP requests (if your project uses them)
    requires java.net.http;

    // Export your main package to make it accessible to the JavaFX framework
    opens com.example.gamestore to javafx.fxml, com.google.gson;

    // Specify the main class
    exports com.example.gamestore;
}
