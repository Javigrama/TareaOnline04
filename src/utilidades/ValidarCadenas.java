/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que valida cadenas a través de expresiones
 * regulares
 * @author Javier Martínez Ruiz
 * @version 1.0
 */


public class ValidarCadenas {
    
        static String VERDE = "\u001B[32m";
        static String ROJO="\u001B[31m";
        static String RESET = "\u001B[0m";
    
    
   /**
    * Método que despliega un menú con varias opciones
    * para elegir. Al igual que en otros menús, las excepciones
    * son controladas por el método que valida la entrada
    */
     public void opcionesMenu(){
      
            int opcion=-1;
        
                                          
            do{                           
                                         
                                 
                System.out.println();
                System.out.println("Introduzca una opción");
                System.out.println("1. Comprobar matrícula de automovil:  ");
                System.out.println("2. Comprobar matrícula de ciclomotor: ");
                System.out.println("0. Salir:  ");
                System.out.print("--> ");
                opcion=IO_ES.leerInteger("Inserte una opción entre ", 0,2);
               
             
      
             switch(opcion){
                 
                    case 0:
                        System.out.println("Retornando al menu principal");
                        break;
                    
                    case 1: 
                        if(comprobarMatriculaAutomovil(IO_ES.leerMatricula())) System.out.println(VERDE+ "La matrícula es válida"+ RESET);
                        else System.out.println( ROJO+"La matrícula NO es válida"+ RESET);
                        break;
                        
                   case 2: 
                        if(comprobarMatriculaCiclomotor(IO_ES.leerMatricula())) System.out.println(VERDE+"La matrícula es válida"+ RESET);
                        else System.out.println(ROJO +"La matrícula NO es válida"+ RESET);
                        break;
                          
                    default: System.out.println("Del 1 al 2 y 0 si desea salir");
                        break;
                }
            } while(opcion!=0);
    }
    
     
     /**
      * El método valida matrículas de automovil a través de la clase
      * pattern
      * @param str El String o matrícula a validar
      * @return true or false en función de si se ha encontrado el parámetro
      * recibido en el patrón creado y localizado dentro del objeto mat
      */
     
//     Se hace un patrón cuando queremos buscar en bucles. Para una sola búsqueda
//     con un matches hubiera sido suficiente pero quería entender bien este 
//     método que nunca lo utilizo
     
        public static boolean comprobarMatriculaAutomovil(String str){
        
            
            Pattern patron=Pattern.compile("\\d{4}([B-Z&&[^AEIOUÑ]]{3})");
            Matcher mat=patron.matcher(str);
            return mat.matches();
         }
    
    
        /**
      * El método valida matrículas de ciclomotor a través de la clase
      * pattern
      * @param str El String o matrícula a validar
      * @return true or false en función de si se ha encontrado el parámetro
      * recibido en el patrón creado y localizado dentro del objeto mat
      */
    
        public static boolean comprobarMatriculaCiclomotor(String str){
        
            Pattern patron=Pattern.compile("[B-Z&&[^AEIOUÑ]]\\d{4}([B-Z&&[^AEIOUÑ]]{3})");
            Matcher mat=patron.matcher(str);
            return mat.matches();
        }
}
