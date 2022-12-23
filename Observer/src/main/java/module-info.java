module com.example.task7 {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example;
    opens com.example to javafx.fxml;
}