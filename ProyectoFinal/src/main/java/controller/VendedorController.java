package controller;

import controller.ServiceController.Service.VendedorControllerService;
import maper.dto.VendedorDto;

public class VendedorController implements VendedorControllerService {

    ModelController modelController;

    public VendedorController(){
        System.out.println("Llamado singleton desde VendedorController");
        modelController=ModelController.getInstance();
    }


    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return modelController.agregarVendedor(vendedorDto);
    }
}
