package maper.mapper;
import maper.dto.VendedorDto;
import model.Vendedor;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperMarket {

    MapperMarket INSTANCE= Mappers.getMapper(MapperMarket.class);

@Named("vendedorDto")
    VendedorDto vendedorDto(Vendedor vendedor);
Vendedor vendedorDto(VendedorDto vendedorDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<VendedorDto> getVendedroDto( List<Vendedor> listaVendedores);












}
