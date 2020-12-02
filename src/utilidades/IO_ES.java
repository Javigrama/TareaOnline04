/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Javier Martínez Ruiz
 */
public class IO_ES {
    
        static String VERDE = "\u001B[32m";
        static String ROJO="\u001B[31m";
        static String RESET = "\u001B[0m";
    
    /**
     *  
     * El método sirve para leer un entero. 
     * Solicita el dato y valida su entrada controlando
     * las posibles excepciones si el token que recibe 
     * Scanner no coincice con el tipo solicitado
     * @param max el número máximo solicitado
     * @param min el número máximo solicitado
     * @param msj mensaje personalizado
     * @return el entero leído
     */
  
   
    
    
    public static int leerInteger(String msj, int min, int max){ //Los 4 métodos de números son iguales variando sólo
                                     // el tipo de dato que manejan y por tanto la variable que   
                                     // los aloja.  
                   int d=0;                     
                   boolean  flag=false;  
                   Scanner entrada=new Scanner(System.in);
                       
                        do{         // Un estructura cíclica do while incia un ciclo que perdura
                                    //mientras no se inserte el dato deseado
                                    try{
                                         System.out.println(msj+ min+" y "+ max);       
                                         d=entrada.nextInt();                         //si el dato insertado no coincide con el  solicitado se genera excepcion.                                           
                                         if(d>=min&&d<=max)
                                         flag=true;                                   // El programa cesa de leer y la excepción se propaga hasta el catch que la trata              
                                    }catch(InputMismatchException e){ System.out.println(ROJO+"Error en la inserción"+RESET); 
                                    entrada.nextLine();}     //limpieza del búfer para reiniciar intento          
                          } while(!flag);                       
                          
                          return d;
                           //Si el dato solicitado coincide con el insertado, la variable boolean se torna true y el ciclo 
             }              // finaliza
    
    
    
    /**
     * Es el método leerInteger sobrecargado para cuando sólo queremos un número
     * @param min número mínimo
     * @param msj mensaje personalizado 
     * @return 
     */
     public static int leerInteger(String msj, int min){ 
                                     
                   int d=0;                     
                   boolean  flag=false;  
                   Scanner entrada=new Scanner(System.in);
                       
                        do{        
                                    try{
                                         System.out.println(msj);       
                                         d=entrada.nextInt();  
                                         if(d>=min)
                                         flag=true;                                                
                                    }catch(InputMismatchException e){ System.out.println(ROJO+"Error en la inserción"+RESET); 
                                    entrada.nextLine();}              
                          } while(!flag);                       
                          
                          return d;
                            
             }              
    
    /**
     * El método lee un número de coma flotante (float)
     * Solicita el dato y valida su entrada controlando 
     * las posibles excepciones si el token que recibe
     * scanner no coincide con el tipo solicitado
     * @return devuelve el número 
     */
    
     public static float leerReal(){  
         
         
                float d=0f;                     
                boolean  flag=false;        
                Scanner entrada=new Scanner(System.in);
                        do{
                            
                                    try{
                                         System.out.println("Escriba un número real");       
                                         d=entrada.nextFloat();                                                                      
                                         flag=true;                                            
                                    }catch(InputMismatchException e){ System.out.println("Error en la inserción");
                                    entrada.nextLine();}
                          } while(!flag);
                          
                           return d;
                     
             }
     
     
      /**
     * El método lee un número entero largo (long).
     * Solicita el dato y valida su entrada controlando 
     * las posibles excepciones si el token que recibe
     * scanner no coincide con el tipo solicitado
     */
     
     
        public static long leerIntegerLargo(){
        
    
                   long d=0L;                     
                   boolean  flag=false;        
                   Scanner entrada=new Scanner(System.in);
                        do{
                            
                                    try{
                                         System.out.println("Escriba un número entero largo");       
                                         d=entrada.nextLong();                                                                      
                                         flag=true;                                            
                                    }catch(InputMismatchException e){ System.out.println("Error en la inserción");
                                    entrada.nextLine();}
                          } while(!flag);
                           
                         return d;
                     
             }
        
        
        
        
       /**
     * El método lee un número real largo (double).
     * Solicita el dato y valida su entrada controlando 
     * las posibles excepciones si el token que recibe
     * scanner no coincide con el tipo solicitado
     */
        
        public static double leerRealLargo(){
        
    
                   double d=0;                     
                   boolean  flag=false;        
                   Scanner entrada=new Scanner(System.in);
                        do{
                            
                                    try{
                                         System.out.println("Escriba un número de coma flotante largo");       
                                         d=entrada.nextDouble();                                                                      
                                         flag=true;                                            
                                    }catch(InputMismatchException e){ System.out.println(ROJO+"Error en la inserción"+RESET);
                                    entrada.nextLine();}
                          } while(!flag);
                             entrada.close();
                          return d;
                     
             }
        
        /**
         * Método void que imprime por pantalla el valor de
         * su parámetro
         * @param cadena 
         */
        
        public static void escribir(String cadena){
            
            System.out.print(cadena);
        }
        
        
        /**
         * Método void que imprime por pantalla el valor de 
         * su parámetro y un salto de línea
         * @param cadena 
         */
        
          public static void escribirLn(String cadena){
            
            System.out.println(cadena);
        }
          
          
          
          /**   
           * Método que solicita un String.
           * @return devuelve el dato introducido
           */
          public static String leerMatricula(){
              
              Scanner entrada=new Scanner(System.in);
              String matricula;
              
                System.out.println("Introduzca la matrícula ");
                matricula=entrada.nextLine();
                      
              return matricula;
              
          }
          
          
          /**
           * Método creado parala clase Hundir la Flota
           * Valida la entrada de coordenadas mediante el método matches
           * @return devuelve la casilla introducida si cumple con el regex
           */
         
          public static String validarCoordenadas(){
              
                Scanner entrada=new Scanner(System.in);
                String casilla;
              
                do{
                    System.out.print("Introduzca la casilla(por ejemplo B4):  ");
                    casilla=entrada.nextLine();
                    if(!casilla.matches("[A-J][0-9]")) System.out.println(ROJO+"Escriba correctamente la casilla"+ RESET);
                }while(!casilla.matches("[A-J][0-9]"));   
                
                return casilla;
              
          }
              
          
          
    }
    
    



