package viewController;

import controller.ModelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VentanaAdministradorviewController {

    @FXML
    private Button bttAgregarVendedor;

    @FXML
    private Label labelNombre;


    @FXML
     void initialize(){
        labelNombre.setText("ADMINISTRADOR");
    }

    @FXML
    void crearVendedor(ActionEvent event){
        ModelController.getInstance().loadWindow("vendedor.fxml");
    }
}
