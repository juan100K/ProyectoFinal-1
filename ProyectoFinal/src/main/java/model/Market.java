package model;

import model.service.IVendedorService;

import java.util.ArrayList;

public class Market implements IVendedorService {

    ArrayList<Vendedor>listaVendedores=new ArrayList<>();

    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public Market(){

    }



    @Override
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




    public void agregarVendedor(Vendedor vendedor){
        getListaVendedores().add(vendedor);
    }

    public void mostrarVendedoresAntesDeSerializar() {
        System.out.println("Vendedores antes de serializar:");
        for (Vendedor vendedor : getListaVendedores()) {
            System.out.println(vendedor.getNombre() + " " + vendedor.getApellido());
        }
    }



}
