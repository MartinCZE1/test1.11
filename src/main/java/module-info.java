module com.example.test111 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.test111 to javafx.fxml;
    exports com.example.test111;
}