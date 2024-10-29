package viewController;

import controller.ModelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LogginviewController {

    String user;

  private   Properties users=new Properties();
  private boolean validar=false;


    @FXML
    private Button bttIngresar;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize(){
        obtenerUsuario();
    }

    @FXML
    private void verificar(ActionEvent event) {
        String name = txtNombre.getText().trim();
        String password = txtContraseña.getText().trim();
        if (users.containsKey(name)&&users.containsValue(password)) {
            validar=true;
            JOptionPane.showMessageDialog(null,"Bienvinido  "+ name);
            ModelController.getInstance().RegistrarAdminitrador("Inicio de secion por  "+name,1,"Inicio de seccion");
            ModelController.getInstance().loadWindow("agregarVendedor.fxml");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no registrado");
        }
    }

    private void obtenerUsuario(){
        try {
            users.load(new FileInputStream("ProyectoFinal/src/main/resources/Loggin/contraseña.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean validar(){
        if(validar){
            return true;
        }else {
            return false;
        }
    }





}
