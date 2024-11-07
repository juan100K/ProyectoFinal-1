package util;

import maper.dto.VendedorDto;
import model.Market;
import model.Vendedor;

import java.io.IOException;
import java.util.List;

public class Persistencia {

    private final String rutaLog="ProyectoFinal/src/main/resources/Log/log.txt";
    private static final String rutaxml="ProyectoFinal/src/main/resources/archivoVendedor.xml";

    private final String rutaVendedor="ProyectoFinal/src/main/resources/archivos/salvarDatosVendedor.txt";





    private static ArchivoUtils archivoUtils=new ArchivoUtils();

    public void salvarDatos(String ruta,String contenido,boolean anexar){

    }

    public  void guardarLog(String mensaje,int nivel,String accion){
        archivoUtils.guardarRegistroLog(mensaje,nivel,accion,rutaLog);
    }

    public static void guardarVendedorxml(List<Vendedor> market) throws IOException {
       ArchivoUtils.xml(rutaxml,market);
    }

    public List<Vendedor> cargarDatos() throws IOException {
       List<Vendedor>list= (List<Vendedor>) ArchivoUtils.deseralizacionObjetoXML(rutaxml);
        return list;
    }
    public void salvarDatosVendedores(List<Vendedor>vendedorList) throws IOException {
        String contenido=" ";
        for(Vendedor v:vendedorList){
            contenido += "Nombre" + v.getNombre() + "Apellido" +v.getApellido() + "Cedula "+ v.getCedula() +"\n";
        }
        archivoUtils.crearArchivo(rutaVendedor,contenido,true);
    }



}
