package util;

import maper.dto.VendedorDto;
import model.Market;
import model.Vendedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Persistencia {

    private final String rutaLog="ProyectoFinal/src/main/resources/Log/log.txt";
    public static final String rutaxml="ProyectoFinal/src/main/resources/Persistencia/model.xml";

    public static final String rutaVendedor="ProyectoFinal/src/main/resources/archivos/salvarDatosVendedor.txt";


    public static void cargarDatos(Market market) throws IOException {
        List<Vendedor>vendesor=cargarDatosVendedor();
        if(vendesor.size()>0){
            market.getListaVendedores().addAll(vendesor);
        }
    }




    private static ArchivoUtils archivoUtils=new ArchivoUtils();

    public void salvarDatos(String ruta,String contenido,boolean anexar){

    }

    public  void guardarLog(String mensaje,int nivel,String accion){
        archivoUtils.guardarRegistroLog(mensaje,nivel,accion,rutaLog);
    }

    public static void guardarVendedorxml(Market market) {
        try {
            ArchivoUtils.xml(rutaxml, market);
        }catch (Exception e){

        }
    }

    public static List<Vendedor> cargarDatosVendedor() throws IOException {
      ArrayList<Vendedor>vendedors=new ArrayList<Vendedor>();
      ArrayList<String>contenido=ArchivoUtils.leerDatos(rutaVendedor);
      String linea=" ";
      for(int i=0;i<contenido.size();i++){
          linea= contenido.get(i);
          Vendedor vendedor=new Vendedor();
          vendedor.setNombre(linea.split("@@")[0]);
          vendedor.setApellido(linea.split("@@")[1]);
          vendedor.setCedula(linea.split("@@")[2]);
          vendedor.setEmail(linea.split("@@")[3]);
          vendedors.add(vendedor);
      }
      return vendedors;

    }


    public static void guardarVendedor(ArrayList<Vendedor> vendedor) throws IOException {
        String contenido = " ";
        for (Vendedor v : vendedor) {
            contenido += v.getNombre() + "@@" + v.getApellido() + "@@" + v.getCedula() + "@@" + v.getEmail();
        }

            ArchivoUtils.crearArchivo(rutaVendedor, contenido, false);
        }



}
