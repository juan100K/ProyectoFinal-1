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
import util.Persistencia;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ModelController implements Runnable{

   private Persistencia persistencia=new Persistencia();
   private Properties properties;



   MapperMarket mapperMarket=MapperMarket.INSTANCE;
   Market market=new Market();



   Thread hilo1xml;
   Thread hilo2binario=new Thread();
    ExecutorService executorService= Executors.newFixedThreadPool(1);



    static Semaphore semaphore = new Semaphore(1);

    VendedorDto vendedor;

    private static ModelController modelController;
    private List<Vendedor>vendedorList;

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
        try {
        Thread hilo=Thread.currentThread();
        ocupar();
        if(hilo==hilo1xml){
            System.out.println("Guardando");
            Persistencia.guardarVendedorxml(market.getListaVendedores());
            System.out.println(market);
           liberar();
        }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean agregarEmplado(VendedorDto vendedorDto){
        Vendedor vendedor= mapperMarket.vendedorDto(vendedorDto);
        return false;
    }

    public void guardarxml(){
        hilo1xml=new Thread(this);
        hilo1xml.start();
    }

    public void liberar() throws InterruptedException {
        semaphore.acquire();
    }
    public void ocupar(){
        semaphore.release();
    }

    public void guardarVendedor(VendedorDto vendedorDto) throws IOException {
        Vendedor vendedor=mapperMarket.vendedorDto(vendedorDto);
        market.agregarVendedor(vendedor);
        guardarxml();
    }

    public void cargarxml() throws IOException {
      vendedorList=(List<Vendedor>) persistencia.cargarDatos();
        System.out.println(vendedorList);
    }




}
