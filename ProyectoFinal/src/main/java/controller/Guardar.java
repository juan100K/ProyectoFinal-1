package controller;

import maper.dto.VendedorDto;
import model.Vendedor;
import util.Persistencia;

import java.io.IOException;
import java.util.List;

public class Guardar implements Runnable{

    private List<Vendedor>vendedorList;
    private Persistencia persistencia=new Persistencia();

    public Guardar(List<Vendedor>vendedorList){
        this.vendedorList=vendedorList;
    }


    @Override
    public void run() {
        try {
            guardarxml();
            salvarDatos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public synchronized void guardarxml() throws IOException {
      persistencia.guardarVendedorxml(vendedorList);
    }

    public synchronized void salvarDatos() throws IOException {
        persistencia.salvarDatosVendedores(vendedorList);
    }


    public void cargar(){

    }
}
