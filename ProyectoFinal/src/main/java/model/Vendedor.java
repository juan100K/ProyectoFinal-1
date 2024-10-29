package model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{


    public Vendedor(){

    }


    private List<Contactos> contactosList=new ArrayList<>();

    public Vendedor(List<Contactos> contactosList) {
        this.contactosList = contactosList;
    }

    public List<Contactos> getContactosList() {
        return contactosList;
    }


}
