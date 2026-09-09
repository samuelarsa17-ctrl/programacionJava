/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quickbite.modelo;

/**
 *
 * @author CSU22
 */
public class Plato {
    
    //Atributos
    private String nombre;
    private double precio;
    private int porcionesDisponibles;
    
    //Un unico constructor que reciba los tres valores como parametros
    
    public Plato (String nombre, double precio, int porcionesDisponibles) {
        this.nombre = nombre;
        this.precio = precio;
        this.porcionesDisponibles = porcionesDisponibles;
        
    }
    
    //Metodos
    public void mostrarInformacion() { 
        System.out.println("El nombre del plato es: " + nombre +
                "y el precio es " + precio + "y quedan disponibles "
                + porcionesDisponibles + " platos");
        
    }
    
    public double calcularSubtotal(int cantidad) {
        
        double valorSubtotal = this.precio * cantidad;
        
        return valorSubtotal;
    }
    
    public boolean hayDisponibilidad(int cantidad){
        if(cantidad > porcionesDisponibles) {
        return false;
    }
     else {
    
        return true;
    }
    }
        
    public void despachar (int cantidad){
        
            boolean hayDisponibilidad = hayDisponibilidad(cantidad);
            
            if(hayDisponibilidad == true){
                
                this.porcionesDisponibles = this.porcionesDisponibles - cantidad;
                        System.out.println("Actualizadas las porciones disponibles");
            } else{
                System.out.println("¡Advertencia! No hay disponibilidad");
            }
        }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
        
}
