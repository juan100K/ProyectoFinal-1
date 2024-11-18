package viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uq.proyectofinal.Main;

import java.io.IOException;

public class LogginVendedorviewController {


    @FXML
    private Button bttIngresoAdministrador;

    @FXML
    private Button bttIngresoVendedor;


    @FXML
    void initialize(){
        this.bttIngresoAdministrador.setOnAction(this::iniciarSecionAdministrador);
        this.bttIngresoVendedor.setOnAction(this::iniciarSecionVendedor);


    }

    private void iniciarSecionVendedor(ActionEvent event){
        loadWindow("LogginVendedor.fxml");
    }
    private void iniciarSecionAdministrador(javafx.event.ActionEvent event){
        loadWindow("ingresoAdministrador.fxml");
    }

    private void loadWindow(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxmlFile));
            AnchorPane root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
