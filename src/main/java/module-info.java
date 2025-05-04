module com.example.juego {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.juego to javafx.fxml;
    exports com.example.juego;
}