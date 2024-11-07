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


    }




    public void cargar(){

    }
}
