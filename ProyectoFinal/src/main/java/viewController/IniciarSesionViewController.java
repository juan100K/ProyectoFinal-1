package viewController;

import controller.ModelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uq.proyectofinal.Main;

import java.io.IOException;
import java.util.logging.Logger;

public class IniciarSesionViewController {

    @FXML
    private Button bttIngresar;
  @FXML
  private Button bttRegistrarAdministrar;

    @FXML
    void initialize(){
        this.bttIngresar.setOnAction(this::ingresarAdmin);
        this.bttRegistrarAdministrar.setOnAction(this::registrarAdministrador);
    }




    private void ingresarAdmin(ActionEvent event){
        this.loadWindow("ingresoAdministrador.fxml");
        ModelController.getInstance().RegistrarAdminitrador("Inicio Secicion",1,"Secion");

    }
    private void registrarAdministrador(ActionEvent event){
        this.loadWindow("regitrarAdministrador.fxml");
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
