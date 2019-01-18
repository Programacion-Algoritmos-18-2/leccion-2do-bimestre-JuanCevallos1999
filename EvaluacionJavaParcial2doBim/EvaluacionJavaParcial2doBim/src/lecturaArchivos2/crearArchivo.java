/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class crearArchivo {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            salida = new Formatter("data/nombres.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo
//metodo para agregar los registros de la lista recibida ordenada por nombres
    public void agregar_registros(ArrayList<Profesor> info) {
        ArrayList<Profesor> informacion = info; //la lista sera igual a la recibida
        for (int i = 0; i < informacion.size(); i++) { //recorre toda la lista 
            Profesor pro = informacion.get(i); //obtiene un objeto
            salida.format("%s - %s - %s - %s - %s - %s - %s - %s", pro.getCedula(), pro.getNombres(), pro.getZona(), pro.getProvincia(),
                    pro.getCanton(), pro.getPersonalidad(), pro.getRazonamiento(), pro.getDictamenIdoniedad()); //lo envia al archivo 
            System.out.println("Informacin escrita"); //validación
        }
    }
//metodo para cerrar el nuevo archivo
    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }
}
