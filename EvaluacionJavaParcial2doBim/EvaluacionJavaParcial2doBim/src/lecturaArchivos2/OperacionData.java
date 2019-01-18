/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;
//importacion de librerias 
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author reroes
 */
public class OperacionData { //clase OperacionData

    ArrayList<Profesor> informacion = new ArrayList<>(); //Atributos de la clase 

    public void agregarInformacion(ArrayList<Profesor> info) { //Metodo set
        informacion = info;
    }

    public ArrayList<Profesor> obtenerInformacion() { //Metodo Get que retornara una lista
        return informacion;
    }
   
    // proceso de ordenar, a través del uso de Collections metodo ordena los objetos con respecto a los cantones
    public void ordenarPorCanton(){ 
        ArrayList<Profesor> dataPorCantones = new ArrayList<>(); //Crea una nueva lista vacia
        dataPorCantones.addAll(informacion); //lista es una copia de la lista completa
        Collections.sort(dataPorCantones, 
                        (o1, o2) -> o1.canton.compareTo(o2.canton)); //linea ordena por cantones 
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i)); //Presenta la lista de objetos ordenados
        }
    }
    
    public ArrayList<Profesor> ordenarPorNombres(){ //Metodo ordena por nombres y retorna una lista de los nombresOrdenados
        ArrayList<Profesor> dataPorNombres = new ArrayList<>(); //Crea lista vacia 
        dataPorNombres.addAll(informacion); //Copia la informacion de la lista completa 
        Collections.sort(dataPorNombres, 
                        (o1, o2) -> o1.nombres.compareTo(o2.nombres)); //Ordena la lista por nombres 
        return dataPorNombres; //Retorna la lista
        
    }
    public void conteo_personalidad(){ //Metodo cuenta la cantidad por atributo personalidad 
        int adecuado=0,porConvocar=0; //contadores
        for (int i = 0; i < this.informacion.size(); i++) { //for recorre toda la lista
            if (this.informacion.get(i).getPersonalidad().equals("ADECUADO")) { //compara si el atributo es igual a ADECUADO contador eleva en 1, caso contrario el otro contador suma 1
                adecuado += 1;
            } else if (this.informacion.get(i).getPersonalidad().equals("POR CONVOCAR")) {
                porConvocar += 1;
            }
        }
        System.out.printf("La cantidad de participantes ADECUADOS es %d\n", adecuado); //Presenta la información de cada contador
        System.out.printf("La cantidad de participantes POR CONVOCAR es %d\n", porConvocar);
    }
    public void conteo_idoneidad(){ //metodo evalua por idoneidad
        int idoneo=0 , noIdoneo=0; //contadores 
        for (int i = 0; i < this.informacion.size(); i++) { //for recorre toda la lista
            if (this.informacion.get(i).getDictamenIdoniedad().equals("IDONEO")) {
                idoneo +=1; //En caso del atributo dictamen... ser IDONEO el contador suma 1, caso contrario el otro suma 1
            } else if (this.informacion.get(i).getDictamenIdoniedad().equals("NO IDONEO")) {
                noIdoneo += 1;
            }
        }
        System.out.printf("La cantidad de participantes IDONEO es %d\n", idoneo); //presenta la información acumulada en cada contador
        System.out.printf("La cantidad de participantes NO IDONEO es %d\n", noIdoneo);
    }  
    public void lecturaData() {
        for (int i = 0; i<obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));
            
        }
        
    }

}
