module com.example.hamza_assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hamza_assignment to javafx.fxml;
    exports com.example.hamza_assignment;
}