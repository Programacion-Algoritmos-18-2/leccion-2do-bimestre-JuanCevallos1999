package lecturaArchivos2;
// Importacion de librerias utilizadas 
import java.util.ArrayList; //Libreria para usar listas
public class PruebaLeerArchivoTexto { //Clase PruebaLeerArchivoTexto 
    public static void main(String args[]) { //metodo main
        ArrayList<Profesor> listaParticipantes = new ArrayList<>(); //Creamos una lista vacia que contendra ambas listas 
        crearArchivo crear = new crearArchivo();
        String direcciontxt = "data/data2.txt"; //Especificamos las rutas de los archivos
        String direccioncsv = "data/data1.csv"; //Especificamos las rutas de los archivos 
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();     //Creamos un objeto tipo LeerArchivoTexto para poder abrir nuestros archivos 
        OperacionData operacion = new OperacionData(); //Creamos un metodo OperacionData para las respectivas operaciones posteriores
        aplicacion.abrirArchivo(direccioncsv); //Abrimos el archivo en formato csv
        ArrayList<Profesor> listacsv = aplicacion.lista_csv(); //Creamos una lista que recibira del metodo una lista de objetos tratados correspondientemente al formato
        aplicacion.abrirArchivo(direcciontxt); //Enviamos la dirección de la ruta de archivo txt para abrirlo
        ArrayList<Profesor> listaTxt = aplicacion.leerRegistros(); //Creamos una lista que reciba la lista del archivo txt
        for (int i = 0; i < listacsv.size(); i++) { //For que recorrera toda la listacsv y la agregará a una nueva lista de esta clase
            listaParticipantes.add(listacsv.get(i)); //Linea para agregar los objetos uno a uno de la listacsv a nuestra lista madre
        }
       for (int i = 0; i < listaTxt.size(); i++) { //For para recorrer toda la listade objetos en sacados del formato txt
           listaParticipantes.add(listaTxt.get(i)); //linea que agregara a nuestra lista madre cada uno de los objetos 
       }
        operacion.agregarInformacion(listaParticipantes); //Enviamos a la clase operacionData la lista completa de participantes
        //operacion.lecturaData(); //Metodo presenta la lista
        operacion.ordenarPorCanton(); //Metodo ordena por cantones 
        ArrayList<Profesor> listan = operacion.ordenarPorNombres(); //Se recibe la lista de nombres ordenados
        crear.abrirArchivo(); //Metodo para crear un archivo en caso de no existir
        crear.agregar_registros(listan); //metodo para agregar información al archivo
        // System.out.println("-------");
        // operacion.lecturaData();
        aplicacion.cerrarArchivo(); //cerrar archivo
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

