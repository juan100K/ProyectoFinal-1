package viewController;


import controller.ModelController;
import controller.VendedorController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import maper.dto.VendedorDto;
import maper.mapper.MapperMarket;
import model.Market;
import model.Vendedor;
import org.mapstruct.Mappings;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VendedorviewController {


    @FXML
    ObservableList<VendedorDto>listaVendedor= FXCollections.observableArrayList();

    VendedorController vendedor;


    @FXML
    private Button bttAgregarVendedor;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;
    Market market;




    @FXML
    void initialize(){
        vendedor=new VendedorController();

    }

    @FXML
    void agregarVendedor(ActionEvent event) throws IOException {
        crearVendedor();
    }


    private VendedorDto Vendedor(){
        String nombre= txtNombre.getText();
        String apellido= txtApellido.getText();
        String cedula= txtCedula.getText();
        String email= txtDireccion.getText();
        return new VendedorDto(
                nombre,
                apellido,
                cedula,
                email


        );


    }
    
    private void limpiarCampo(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText(" ");
        txtCedula.setText(" ");
        
    }

    private void crearVendedor() throws IOException {
        VendedorDto vendedorDto=Vendedor();
        if(datosValidos(vendedorDto)) {
            if (vendedor.agregarVendedor(vendedorDto)) {
                listaVendedor.add(vendedorDto);
                limpiarCampo();
                mostrarMensaje("Notificacio vendedor", "vendedor creado", "vendedor creado con exito", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Notificacion Vendedor", "vendedor no asignado", "el vendedor no se acreado", Alert.AlertType.ERROR);
            }
        }
    }

    private boolean datosValidos(VendedorDto vendedorDto){
        String mensaje=" ";
        if(vendedorDto.nombre()==null || vendedorDto.nombre().equals(" ")){
            mensaje+="Datos invalidos ";
        }
        if(vendedorDto.cedula()==null || vendedorDto.cedula().equals(" ")){
           mensaje+="Espacio sin rellenar o invalido";
        }
        if (vendedorDto.email()==null || vendedorDto.email().equals("")){
            mensaje+="Espacio sin rellenar";
        }
        if (vendedorDto.apellido()==null || vendedorDto.apellido().equals("")){
            mensaje+="Espacio sin rellenar";
        }
        if(mensaje.equals(" ")){
            return true;
        }else {
            mostrarMensaje("Datos Invalidos","Vendedor no creado","Datos vacio ", Alert.AlertType.ERROR);
            return false;
        }

    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }




}
