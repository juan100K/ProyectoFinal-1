package maper.mapper;

import java.util.ArrayList;
import maper.dto.VendedorDto;
import model.Vendedor;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-30T18:12:48-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
*/
public class MapperMarketImpl implements MapperMarket {

    @Override
    public VendedorDto vendedorDto(Vendedor vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String cedula = null;

        nombre = vendedor.getNombre();
        apellido = vendedor.getApellido();
        cedula = vendedor.getCedula();

        String direccion = null;
        ArrayList<VendedorDto> vendedorDtos = null;

        VendedorDto vendedorDto = new VendedorDto( nombre, apellido, cedula, direccion, vendedorDtos );

        return vendedorDto;
    }

    @Override
    public Vendedor vendedorDto(VendedorDto vendedorDto) {
        if ( vendedorDto == null ) {
            return null;
        }

        Vendedor vendedor = new Vendedor();

        vendedor.setApellido( vendedorDto.apellido() );
        vendedor.setNombre( vendedorDto.nombre() );
        vendedor.setCedula( vendedorDto.cedula() );

        return vendedor;
    }
}
