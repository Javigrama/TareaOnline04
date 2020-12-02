/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays_CC;

import utilidades.IO_ES;


/**
 * La clase Arrays despliega un menú para seleccionar ejercicios
 * Contiene 5 métodos, 1 por cada ejercicio
 * y uno adicional que comprueba si en un array hay números repetidos.
 * Este último método no se solicitaba y se ha creado sólo por 
 * motivos didácticos.
 * @author Javier Martínez Ruiz
 */
public class Arrays {
    
    
        public void opcionesMenu(){
      
            int opcion=-1;
            
                                          
            do{                           
                                         
                               
                System.out.println();

                System.out.println("1. Array con diez pares");
                System.out.println("2. Array con 20 aleatorios");
                System.out.println("3. Array de números reales definido por usuario");
                System.out.println("4. Array de números enteros definido por usuario");
                System.out.println("0. Salir:");
                System.out.print("--> ");
                opcion=IO_ES.leerInteger("Elija una opción entre ", 0, 4);
                
                      
               
             switch(opcion){
                 
                    case 0:
                          System.out.println("Retornando al menú principal");
                          break;
                    
                    case 1:
                          diezPares();
                          break;
                        
                    case 2: 
                          diezAleatorios();
                         break;
                        
                    case 3: 
                          mediaMaxMin(IO_ES.leerInteger("Inserte el tamaño del array ", 1));
                         break;
                          
                    case 4: 
                         mayoresMenoresCincuenta(IO_ES.leerInteger("Inserte el tamaño del array ", 1));
                         break;
                          
                    default: System.out.println("Del 1 al 4 y 0 si desea salir");
                        break;
                }
            } while(opcion!=0);
        }
      
        
        
        /**
         * Método que crea un array de 10 posiciones y asigna los 10 primeros
         * números pares, uno por cada índice. Después imprime por pantalla el 
         * contenido del array
         */
        
        public void diezPares(){
            
            int[] array=new int[10];
            
                for(int i=0; i<10; i++)
                         array[i]=i*2;
                for(int i:array) System.out.print(i+" ");
                System.out.println();
        } 
        
        
        
        /**
         * El método crea un array de longitud 10 y le asigna números aleatorios
         * del 1 al 20. Como Math.random da un valor del 0.0 a 1 y no queríamos 
         * 0, le hemos sumado 1 a todos los resultados posibles de 0 a 19.
         * Aunque en la tarea no se especifica he decidido que los números asignados
         * no se repitan por lo que he creado un método booleano para controlar
         * esta circunstancia. Asignamos un número a la variable random y llamamos
         * a nuestro método repetido para que compruebe si el número ya está 
         * presente en el array. Si lo está volvemos a generar un número random
         * y si no lo está asignamos al array. Una vez el array tiene valor asignado
         * en todos las referencias preguntamos al usuario por un número del 1 al 20 y
         * buscamos ese número. Si está avisamos y salimos y si no está continuamos
         * preguntando por un número a buscar
         */
        
        public void diezAleatorios(){
            
             int[] array=new int[10];
             int search;
             boolean encontrado=false;
             int random;
             
                for(int i=0; i<array.length; i++){
                   
                    do{
                        random=(int)((Math.random()*19)+1); //Hay que hacer un casting pues random devuelve doble y nuestro array es de int.
                    }while(!repetido(array, random)); //mientas repetido no devuelva true es que el número ya está en el array.
                    array[i]=random;    //Si no está en el array, asignamos. Una vez asignado el array pasamos a la parte 2
                }
              
            
                    do{  // es un bucle pues si el número no está hay que pedir uno nuevo
                        search=IO_ES.leerInteger("Inserte un número entre ", 1, 20); //pedimos el número a buscar
                        
                        for(int i=0; i<array.length; i++){   //sencillamente iteramos y si el número está en el array
                            if(array[i]==search){           //pues devolvemos la posición que es i
                                encontrado=true;
                                System.out.println("El número "+ search+ " está en la posición "+ i);
                            }
                            
                        }
                           if(!encontrado){   //si no se encuentra el número se avisa y vuelta a empezar
                               System.out.println("No hemos encontrado el "+search); 
                                 
                            }
                    }while(!encontrado);
        }
    
        
        
        /**
         * Método que evalúa si en el array recibido por parámetro se encuentra
         * el número recibido por parámetro
         * @param array Array en el que se busca el número
         * @param numero número a buscar en el array
         * @return Devuelve un booleano, false si el número ya está presente y
         * true si el número no está presente
         */
        
        private boolean repetido(int[] array, int numero){
            
            for(int i=0; i<array.length; i++){
                
                if(array[i]==numero) return false;
            }
            
            return true;
        }
        
        
        /**
         * Método que crea un array de valores double con un tamaño introducido por
         * el usuario. Calcula el valor mínimo, el máximo y la media de los 
         * valores contenidos en el array
         * @param tamaño 
         */
        
        
        public void mediaMaxMin(int tamaño){
            
            double[] array=new double[tamaño];
            double min;
            double max;
            double sum=0;
            
                for(int i=0; i<array.length; i++)
                        array[i]=Math.random();
                
                    min=array[0]; //asignamos min y máximo al array[0]
                    max=array[0]; 
               
                for(int i=0; i<array.length; i++){
                
                    if(array[i]<min){
                     
                        min=array[i]; //comparamos y asignamos a min si es menor
              
                    }
                    else if(array[i]>max){ //si es mayor asignamos a max
                        max=array[i];
                    }
                    
                    sum+=array[i];   //para calcular la media
                }

                System.out.println(min +" es el minimo");
                System.out.println(max+ " es el maximo");
                System.out.println(sum/tamaño+ " es la media ");
            
        }
        
        
        
        /**
         * método que calcula valores por encima o por 
         * debajo de 50. Si un valor es igual a 50 no se 
         * tomará en cuenta porque se pide mayor o menor
         * @param tamaño El size del array 
         */
        
        
        public void mayoresMenoresCincuenta(int tamaño){
            
            int[] array=new int[tamaño];
            int mayorDeL=0;
            int menorDeL=0;
            
                for(int i=0; i<array.length; i++){
                    
                    array[i]=(int)(Math.random()*100); //casting que son enteros
                    //En este caso el 0 si lo necesitamos, pues es entre 0 y 100
                }
            
                  for(int i=0; i<array.length; i++){
                  
                      if(array[i]>50) mayorDeL++;
                    
                      else if(array[i]<50) menorDeL++;
                    
                      System.out.print(array[i]+ ((i+1)%10==0? "\n":" "));
                }
                System.out.println();
                System.out.println("Hay "+ mayorDeL+ " números mayores de 50 y\n "
                                   + menorDeL + " números menores de 50");
        }
}
