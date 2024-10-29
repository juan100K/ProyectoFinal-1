package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import maper.dto.VendedorDto;
import maper.mapper.MapperMarket;
import model.Market;
import model.Vendedor;
import uq.proyectofinal.Main;
import util.ArchivoUtils;
import util.Persistencia;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModelController implements Runnable{

   private Persistencia persistencia=new Persistencia();
   private Properties properties;



   MapperMarket mapperMarket=MapperMarket.INSTANCE;
   Market market;

   Thread hilo1xml=new Thread();
   Thread hilo2binario=new Thread();
    ExecutorService executorService= Executors.newFixedThreadPool(1);

    VendedorDto vendedor;

    private static ModelController modelController;

    private ModelController(){

    }

public synchronized static ModelController getInstance(){
        if(modelController==null){
            modelController=new ModelController();
            return modelController;
        }
        return modelController;
}

public void RegistrarAdminitrador(String mensaje,int nivel,String accion){
    persistencia.guardarLog(mensaje,nivel,accion);
}
    public void loadWindow(String fxmlFile) {
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


    @Override
    public void run() {
        Thread hilo=Thread.currentThread();
        executorService.execute(hilo);
        if(hilo==hilo1xml){
            /*
            try {
             //   persistencia.guardarVendedorxml(vendedor);
                System.out.println("Guardar");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                persistencia.guardarVendedorxml(vendedor);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

             */
        }


    }
    public boolean agregarEmplado(VendedorDto vendedorDto){
        Vendedor vendedor= mapperMarket.vendedorDto(vendedorDto);
        return false;
    }

    public void guardarxml(Object object){
        hilo1xml=new Thread(this);
        hilo1xml.start();
    }


}
