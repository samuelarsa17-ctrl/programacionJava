/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quickbite.modelo;

/**
 *
 * @author CSU22
 */
public class Cliente {
    
    //Atributos
    
    private String nombre;
    private String correo;
    private double saldo;
    
    //Constructor

    public Cliente(String nombre, String correo, double saldo) {
        this.nombre = nombre;
        this.correo = correo;
        this.saldo = saldo;
    }
    
    
    //Metodos
    public void mostrarInformacion(){
        System.out.println("El nombre es " + nombre +
                " el correo es " + correo +
                " el saldo es " + saldo);
    }
    
    public boolean puedePagar (double valor){
        
        if(valor> saldo){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void pagar(double valor){
        boolean puedePagar = puedePagar(valor);
        
        if (puedePagar == true) {
            this.saldo = this.saldo - valor;
            System.out.println("Pagar saldo");
        }
        else{
            System.out.println("No se pudo realizar el pago");
        }
    }
}
