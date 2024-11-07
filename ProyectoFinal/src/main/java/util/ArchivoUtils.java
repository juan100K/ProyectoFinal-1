package util;

import model.Vendedor;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtils {
    static String fechaSistema=" ";



    public void crearArchivo(String ruta,String contenido,boolean flagAnexar) throws IOException {
        FileWriter fr=new FileWriter(ruta,flagAnexar);
        BufferedWriter bw=new BufferedWriter(fr);
        bw.write(contenido);
        bw.flush();
        bw.close();
    }



    public static void xml(String nombre,Object object)throws IOException{
        XMLEncoder codificar;
        codificar=new XMLEncoder(new FileOutputStream(nombre));
        codificar.writeObject(object);
        codificar.close();

    }

    public static Object deseralizacionObjetoXML(String nombre)throws IOException{
        XMLDecoder descodificar;
        descodificar=new XMLDecoder(new FileInputStream(nombre));
        Object object;
        descodificar=new XMLDecoder(new FileInputStream(nombre));
        object=descodificar.readObject();
        descodificar.close();
        return object;

    }





    public void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo)
    {
        String log = "";
        Logger LOGGER = Logger.getLogger(accion);
        FileHandler fileHandler =  null;
        cargarFechaSistema();
        try {
            fileHandler = new FileHandler(rutaArchivo,true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            switch (nivel) {
                case 1:
                    LOGGER.log(Level.INFO,accion+","+mensajeLog+","+fechaSistema) ;
                    break;

                case 2:
                    LOGGER.log(Level.WARNING,accion+","+mensajeLog+","+fechaSistema) ;
                    break;

                case 3:
                    LOGGER.log(Level.SEVERE,accion+","+mensajeLog+","+fechaSistema) ;
                    break;

                default:
                    break;
            }

        } catch (SecurityException e) {

            LOGGER.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();
        }
        finally {

            fileHandler.close();
        }
    }
    private static void cargarFechaSistema() {

        String diaN = "";
        String mesN = "";
        String añoN = "";

        Calendar cal1 = Calendar.getInstance();


        int  dia = cal1.get(Calendar.DATE);
        int mes = cal1.get(Calendar.MONTH)+1;
        int año = cal1.get(Calendar.YEAR);
        int hora = cal1.get(Calendar.HOUR);
        int minuto = cal1.get(Calendar.MINUTE);


        if(dia < 10){
            diaN+="0"+dia;
        }
        else{
            diaN+=""+dia;
        }
        if(mes < 10){
            mesN+="0"+mes;
        }
        else{
            mesN+=""+mes;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = año+"-"+mesN+"-"+diaN;
        //		horaFechaSistema = hora+"-"+minuto;
    }

}
