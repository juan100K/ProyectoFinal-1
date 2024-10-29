module uq.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;
    requires java.logging;
    requires java.desktop;


    opens viewController to javafx.fxml;
    exports model;
    exports maper.mapper;


    opens uq.proyectofinal to javafx.fxml;
    exports uq.proyectofinal;
    opens controller to javafx.fxml;
}