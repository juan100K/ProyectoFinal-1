package model;

import maper.dto.VendedorDto;
import maper.mapper.MapperMarket;

import java.util.ArrayList;

public class Market  {

    MapperMarket mapperMarket=MapperMarket.INSTANCE;

    ArrayList<Vendedor>listaVendedores=new ArrayList<Vendedor>();

    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public Market(){

    }

    public Market(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }


    public Vendedor crearVendedor(String name,String apellido,String cedula,String direccion){
        Vendedor vendedor=null;
        vendedor=new Vendedor();
        vendedor.setNombre(name);
        vendedor.setCedula(cedula);
        vendedor.setEmail(direccion);
        vendedor.setApellido(apellido);
        getListaVendedores().add(vendedor);

        return vendedor;
    }



}
