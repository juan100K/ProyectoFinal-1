package maper.dto;

import java.util.ArrayList;

public record VendedorDto(
        String nombre,
        String apellido,
        String cedula,
        String direccion,

        ArrayList<VendedorDto>vendedorDtos
) {

    @Override
    public ArrayList<VendedorDto> vendedorDtos() {
        return vendedorDtos;
    }


}
