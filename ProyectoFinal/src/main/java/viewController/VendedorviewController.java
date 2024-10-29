package viewController;

import controller.Guardar;
import controller.ModelController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VendedorviewController {


    @FXML
    ObservableList<VendedorDto>listaVendedor= FXCollections.observableArrayList();

    List<Vendedor>vendedores=new ArrayList<>();
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

    }

    @FXML
    void agregarVendedor(ActionEvent event){
        crearVendedor();
    }


    private VendedorDto Vendedor(){
        String nombre= txtNombre.getText();
        String apellido= txtApellido.getText();
        String cedula= txtCedula.getText();
        String direccion= txtDireccion.getText();
        return new VendedorDto(
                nombre,
                apellido,
                cedula,
                direccion,
                null

        );


    }
    
    private void limpiarCampo(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText(" ");
        txtCedula.setText(" ");
        
    }

    private void crearVendedor(){
        VendedorDto vendedorDto=Vendedor();
        if(datosValidos(vendedorDto)){
            listaVendedor.add(vendedorDto);
            Vendedor vendedor= MapperMarket.INSTANCE.vendedorDto(vendedorDto);
            vendedores.add(vendedor);
            for (Vendedor m:vendedores){
                System.out.println(m.getNombre());
            }
            ExecutorService executorService= Executors.newFixedThreadPool(1);
            Thread hiloGuardar=new Thread(new Guardar(vendedores));
            executorService.execute(hiloGuardar);
            limpiarCampo();
            mostrarMensaje("Notificacio vendedor","vendedor creado","vendedor creado con exito", Alert.AlertType.INFORMATION);
        }else {
            mostrarMensaje("Notificacion Vendedor","vendedor no asignado","el vendedor no se acreado", Alert.AlertType.ERROR);
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
        if (vendedorDto.direccion()==null || vendedorDto.direccion().equals("")){
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
