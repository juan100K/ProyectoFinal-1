package model;

import controller.ModelController;
import controller.ServiceController.VendedroInterface;
import maper.dto.VendedorDto;
import maper.mapper.MapperMarket;

import java.util.ArrayList;

public class Market implements VendedroInterface {

    MapperMarket mapperMarket=MapperMarket.INSTANCE;

    ModelController modelController;

    ArrayList<Vendedor>listaVendedores=new ArrayList<Vendedor>();
    ArrayList<Productos>listaProducto=new ArrayList<>();

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


    @Override
    public boolean agregarEmpleado(VendedorDto vendedorDto) {
        return modelController.agregarEmplado(vendedorDto);
    }


    public void agregarVendedor(Vendedor vendedor){
        getListaVendedores().add(vendedor);
    }



}
