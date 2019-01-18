package lecturaArchivos2;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.
//Importaciones de librerias que utilizaremos para los archivos, así como excepciones 
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

public class LeerArchivoTexto { //Clase LeerArchivo 
    
    private Scanner entrada;    //Atributos de la clase tipo Scanner porque ingresarán datos

    // Método para abrir los archivos 
    public void abrirArchivo(String direccion) { //Recibe como parametro una dirección que será especificada en el main
        try {  //Try y catch para hacer uso de las expceciones 
            entrada = new Scanner(new File(direccion));  //A la variable de Scanner entra el archivo estipulado en la dirección
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) { //En caso de error presentar esta excepción
            System.err.println("Error al abrir el archivo."); 
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // lee registro del archivo txt
    //Metodo para archivo txt en formato json que devuelve una lista de objetos tipo Profesor
    public ArrayList<Profesor> leerRegistros() {
        ArrayList<Profesor> lista = new ArrayList<>(); //Creamos una lista vacia de tipo profesor
        try //Try y catch para el manejo de las excepciones
        {
            entrada.nextLine();      //entrada recibe todas las lineas del archivo   
            while (entrada.hasNext()) {  //condición para evaluar todas las lineas hasta el final             
                System.out.println("Agregando objeto1");// Utilicé esta linea para corroborar que los objetos se agregan correctamente debido al lento procesamiento de mi pc
                Gson g = new Gson(); // se crea el objeto para leer Json
                String linea = entrada.nextLine();  //Linea recibe las lineas del archivo
                // se hace el proceso de transformación
                Profesor p = g.fromJson(linea, Profesor.class);
                lista.add(p); //Agregamos a la lista que creamos el objeto tipo profesor
                //System.out.println(p);

            } // fin de while
        } // fin de try
        catch (NoSuchElementException elementException) { //Excepciones  en caso de error
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {  //Excepciones en caso de error
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista; //Retornamos la lista que acabamos de llenar con json
    } // fin del m�todo leerRegistros
    //Metodo para leer el archivo formato csv que devuelve una lista de objetos tipo profesor
    public ArrayList<Profesor> lista_csv(){
        ArrayList<Profesor> lista1 = new ArrayList<>(); //Creamos la lista vacia
        try{ //Try y catch para manejar excepciones 
            String line = entrada.nextLine();            //Recibe las lineas del archivo
            while(entrada.hasNext()){ //condicion para evaluar todas las lineas hasta el final
                line = entrada.nextLine();
                System.out.println("Agregando objeto2"); //Utilicé esta linea para asegurarme de que los objetos se agregaran, debido al lento procesamiento
                ArrayList<String> lineas = new ArrayList<String>(Arrays.asList(line.split(","))); //Hacemos un split de cada una de las lineas que forman parte de la lista
                Profesor profesor = new Profesor();        //Creamos un objeto de tipo profesor, para lo cual debimos crear un constructor inicializado todo vacio
                profesor.setCedula(lineas.get(0));   //Obtenemos las partes de la 'linea' separada que usaremos y las seteamos para cada atributo correspondiente  
                profesor.setNombres(lineas.get(1));
                profesor.setZona(lineas.get(2));
                profesor.setProvincia(lineas.get(3));
                profesor.setCanton(lineas.get(4));
                profesor.setPersonalidad(lineas.get(5));
                profesor.setRazonamiento(lineas.get(6));
                profesor.setDictamenIdoniedad(lineas.get(7));
                lista1.add(profesor); //Agregamos a una  lista el objeto creado
            }
        }
        catch (NoSuchElementException elementException) {           //Se hace el manejo de excepciones en caso de encontrar problemas en la ejecución
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } 
        catch (IllegalStateException stateException) {//Se hace el manejo de excepciones en caso de encontrar problemas en la ejecución
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } 
        return lista1;              //Devolvemos la lista con los objetos creados                  
    }    
    public void cerrarArchivo() { 
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
