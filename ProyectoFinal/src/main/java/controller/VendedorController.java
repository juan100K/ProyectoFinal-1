package controller;

import controller.ServiceController.VendedroInterface;
import maper.dto.VendedorDto;
import model.Vendedor;

public class VendedorController implements VendedroInterface {

    ModelController modelController;

    public VendedorController(){
        modelController=ModelController.getInstance();
    }


    @Override
    public boolean agregarEmpleado(VendedorDto vendedorDto) {
        return modelController.agregarEmplado(vendedorDto);
    }
}
