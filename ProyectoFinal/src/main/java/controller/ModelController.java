package controller;

import controller.ServiceController.Monitor;
import controller.ServiceController.Service.IModelFactoryService;
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

public class ModelController implements IModelFactoryService,Runnable{

   private Persistencia persistencia=new Persistencia();



   MapperMarket mapperMarket= MapperMarket.INSTANCE;
   Market market;

    public Market getMarket() {
        return market;
    }

    Thread hilo1xml;
   Thread hilo2binario=new Thread();
    Monitor semaforo=new Monitor(1);







    public ModelController(){
        System.out.println("Invocacion Singleton");
        if(market==null){
           market=new Market();
        }

    }

    private static class singletonHolder{
        private final static ModelController eInstance=new ModelController();

    }

public synchronized static ModelController getInstance(){
        return singletonHolder.eInstance;
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


    public void run() {
        Thread hilo = Thread.currentThread();
        ocupar();
        if (hilo == hilo1xml) {
            try {
                System.out.println("Guardando vendedores...");
                System.out.println(market);
                getMarket().mostrarVendedoresAntesDeSerializar();
                Persistencia.guardarVendedorxml(market);
                System.out.println("Guardado.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            liberar();
        }
    }



    private void cargarDatos(){
        market=new Market();
        try {
            Persistencia.cargarDatos(market);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void guardarxml(){
        hilo1xml=new Thread(this);
        hilo1xml.start();
    }

    private void liberar()  {
        try {
            semaforo.liberar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void ocupar(){
        try {
            semaforo.ocupar();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }





    private void salvarDatos(){
        try {
            Persistencia.guardarVendedor(getMarket().getListaVendedores());

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        Vendedor vendedor= mapperMarket.vendedorDto(vendedorDto);
        getMarket().agregarVendedor(vendedor);
        System.out.println("se agrego el vendedor {"+vendedor.getNombre()+"}");
        guardarxml();
        salvarDatos();
        return true;
    }
}
