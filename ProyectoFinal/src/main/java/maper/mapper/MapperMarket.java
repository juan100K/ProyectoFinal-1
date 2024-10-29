package maper.mapper;
import maper.dto.VendedorDto;
import model.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperMarket {

    MapperMarket INSTANCE= Mappers.getMapper(MapperMarket.class);

@Named("vendedorDto")
    VendedorDto vendedorDto(Vendedor vendedor);
Vendedor vendedorDto(VendedorDto vendedorDto);










}
