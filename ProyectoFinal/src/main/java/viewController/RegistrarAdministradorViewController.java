package viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RegistrarAdministradorViewController {

    private Properties user=new Properties();

    @FXML
    private Button bttRegistrarAdministrador;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize(){
        guardar();
    }




    private void mostrarMensaje(String titulo, String header, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.showAndWait();
    }

    private void guardar(){
        try {
            FileInputStream fr=new FileInputStream("ProyectoFinal/src/main/resources/Loggin/contraseña.properties");

            user.load(fr);
            fr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
    @FXML
    private void guardar(ActionEvent event) throws IOException {
        String nombre=txtNombre.getText();
        String password=txtContraseña.getText();
        if(nombre==null || password==null){
            mostrarMensaje("Registrar Administrador","No se registro administrador", Alert.AlertType.INFORMATION);
        }else{
            user.setProperty(nombre,password);
            saveProperties(user,"ProyectoFinal/src/main/resources/Loggin/contraseña.properties");

            JOptionPane.showMessageDialog(null,"Administrador agregado");

        }
    }

    private static void saveProperties(Properties properties,String PROPERTIES) throws FileNotFoundException {
       try(FileOutputStream fileOutputStream=new FileOutputStream(PROPERTIES)) {
           properties.store(fileOutputStream,"Nuevo Administrador");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }






}
