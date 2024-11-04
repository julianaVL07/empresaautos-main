module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.model to javafx.base;
    opens co.edu.uniquindio.poo.controller to javafx.fxml;
    opens co.edu.uniquindio.poo.viewController to javafx.fxml;

    exports co.edu.uniquindio.poo;
    exports co.edu.uniquindio.poo.controller;
    exports co.edu.uniquindio.poo.viewController;
}
