/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import arrays_CC.CadenaCaracteres;
import arrays_CC.Arrays;
import hundirLaFlota.HundirLaFlota;
import java.util.Scanner;
import utilidades.IO_ES;
import utilidades.ValidarCadenas;

/**
 * Es la clase principal que despliega un menú para seleccionar las
 * diferentes opciones. La elección de una opción puede generar una 
 * excepción que es capturada en todo caso dentro del método que valida
 * la entrada.
 * @author Javier Martínez Ruiz
 */
public class MRJ_Online04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       MRJ_Online04 obj=new MRJ_Online04();   //Creamos un objeto para llamar al método menú
       obj.opcionesMenu();
    }   
    
    
    
    
    /**
     * Método que despliega un menú con 4 opciones reguladas por un switch
     * Se trata de un bucle en tanto no se pulse 0. 
     * Las posibles excepciones las controla el método que lee la entrada.
     * Al finalizar libera el recurso
     */
        public void opcionesMenu(){         
      
            int opcion=-1;
            Scanner entrada=new Scanner(System.in);
                                          
            do{                           
                                         
                               
                System.out.println();

                System.out.println("1. Ejercicios con Cadenas de Carácteres:  ");
                System.out.println("2. Ejercicios con expresiones regulares: ");
                System.out.println("3. Ejercicios de Arrays:  ");
                System.out.println("4. Hundir de la flota:  ");
                System.out.println("0. Salir:  ");
                System.out.print("--> ");
                opcion=IO_ES.leerInteger("Escriba una opción entre ", 0, 4);
                
          
           
                    if (opcion == 0) { 
                         System.out.println("Cerrando el scanner");
                       entrada.close(); }
               
               
               
             switch(opcion){
                 
                    case 0:
                         System.out.println("Au Revoir");
                         break;
                    
                    case 1: 
                         CadenaCaracteres cadena=new CadenaCaracteres();
                         cadena.opcionesMenu();
                         break;
                        
                    case 2: 
                         ValidarCadenas validar=new ValidarCadenas();
                         validar.opcionesMenu();
                         break;
                        
                    case 3: 
                         Arrays arrays=new Arrays();
                         arrays.opcionesMenu();
                         break;
                          
                    case 4: 
                      
                         HundirLaFlota.nuevaPartida();
                         break;
                     
                          
                    default: System.out.println("Del 1 al 4 y 0 si desea salir");
                        break;
                }
            } while(opcion!=0);
    }
    
}
