module co.edu.uniquindio.trabajofinalcode {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.trabajofinalcode to javafx.fxml;
    exports co.edu.uniquindio.trabajofinalcode;
}