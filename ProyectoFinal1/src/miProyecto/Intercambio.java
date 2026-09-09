/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miProyecto;

/**
 *
 * @author Sauel Arevalo
 */
public class Intercambio {
    
    //Atributos 
    
    public int id_intercambio;
    public String estado;
//Constructor vacio
    public Intercambio() {
    }
//Constructor completo
    public Intercambio(int id_intercambio, String estado) {
        this.id_intercambio = id_intercambio;
        this.estado = estado;
    }
//Constructor completo
    public Intercambio(String estado) {
        this.estado = estado;
    }
//Metodos
    public int getId_intercambio() {
        return id_intercambio;
    }

    public void setId_intercambio(int id_intercambio) {
        this.id_intercambio = id_intercambio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void imprimir (){
        System.out.println("El producto"+ estado);
    }
    
    public static void main (String[] args) {
        //Voy a crear  mi primer objeto 
        
        Intercambio n1 = new Intercambio (1, "Play 5");
         n1.imprimir();
    }
    
}
