/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

/**
 *
 * @author reroes
 */
/*
{"cedula":"1803742806","nombres":"MULLO ROMERO ESTHER DEL CARMEN", 
"zona":"ZONA 3","provincia":"TUNGURAHUA", 
"canton":"AMBATO", "personalidad": "POR CONVOCAR", 
"razonamiento":"POR CONVOCAR", 
"dictamenIdoniedad":"NO IDONEO"}
 */
public class Profesor {

    String cedula;
    String nombres;
    String zona;
    String provincia;
    String canton;
    String personalidad;
    String razonamiento;
    String dictamenIdoniedad;
    
    public Profesor(){
        cedula = " ";
        nombres = " ";
        zona = " ";
        provincia = " ";
        canton= " ";
        personalidad = " ";
        razonamiento = " ";
        dictamenIdoniedad = " ";
               
    }
    public Profesor(String ced, String nomb, String zon, String provin, String cant, String persona, String raz, String dict) {
        cedula = ced;
        nombres = nomb;
        zona = zon;
        provincia = provin;
        canton = cant;
        personalidad = persona;
        razonamiento = raz;
        dictamenIdoniedad = dict;
    }

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String ced) {
        cedula = ced;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nomb) {
        nombres = nomb;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zon) {
        zona = zon;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String prov) {
        provincia = prov;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getRazonamiento() {
        return razonamiento;
    }

    public void setRazonamiento(String razon) {
        razonamiento = razon;
    }

    public String getDictamenIdoniedad() {
        return dictamenIdoniedad;
    }

    public void setDictamenIdoniedad(String dictamen) {
        dictamenIdoniedad = dictamen;
    }
    

    public String toString() {
        return String.format("%s - %s - %s - %s - %s - %s - %s - %s \n", cedula, nombres, zona, provincia, canton, personalidad, razonamiento
        ,dictamenIdoniedad);
    }
}
