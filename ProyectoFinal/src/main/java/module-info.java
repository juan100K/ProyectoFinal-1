module uq.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;
    requires java.logging;
    requires java.desktop;

    exports viewController;
    opens viewController to javafx.fxml;
    exports model;
    exports maper.mapper;
    exports maper.dto;
    exports controller;
    opens uq.proyectofinal to javafx.fxml;
    exports uq.proyectofinal;
    opens controller to javafx.fxml;



}