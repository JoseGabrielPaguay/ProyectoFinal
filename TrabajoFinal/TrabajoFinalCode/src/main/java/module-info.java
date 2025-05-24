module co.edu.uniquindio.trabajofinalcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.trabajofinalcode to javafx.fxml;
    opens co.edu.uniquindio.trabajofinalcode.viewController to javafx.fxml;
    opens co.edu.uniquindio.trabajofinalcode.controller to javafx.fxml;
    opens co.edu.uniquindio.trabajofinalcode.model to javafx.fxml;

    exports co.edu.uniquindio.trabajofinalcode.viewController;
    exports co.edu.uniquindio.trabajofinalcode.controller;
    exports co.edu.uniquindio.trabajofinalcode.model;
    exports co.edu.uniquindio.trabajofinalcode;
}
