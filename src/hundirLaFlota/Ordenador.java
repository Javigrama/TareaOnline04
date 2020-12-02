/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirLaFlota;

import java.util.Random;


public class Ordenador extends HundirlaFlota {
    
        
   
        public Ordenador(){
            
            super();
       
        }
    
        @Override
       public void imprimirTablero(String[][] tablero) {

        System.out.println("MAPA DEL ORDENADOR");
        System.out.print("  _0_ _1_ _2_ _3_ _4_ _5_ _6_ _7_ _8_ _9_");
                         
        for (int f = 0; f < tablero.length; f++) {
            System.out.println();

            for (int c = 0; c < tablero[f].length; c++) {
                
                
                if (tablero[f][c]=="*"){ 
                                       
                    System.out.print(c == 0 ? (char)(65+f) + "|_" + ROJO+String.valueOf(tablero[f][c])+RESET 
                            + "_" : "|_" + ROJO+ String.valueOf(tablero[f][c])+RESET + "_");
                }
                
               else if (tablero[f][c] == "A") {

                    System.out.print(c == 0 ? (char)(65+f) + "|_" + VERDE+String.valueOf(tablero[f][c])+ RESET 
                            + "_" : "|_" + VERDE+String.valueOf(tablero[f][c])+RESET + "_");
                } 
            else {
                   
                    System.out.print(c == 0 ? (char)(65+f) + "|_ _" : "|_ _");
                }
            }

            System.out.print("|");
        }

        System.out.println();
        System.out.println("\nPUNTOS RESTANTES DEL ORDENADOR: "+ getMarcadorOrdenador()+"\n\n\n");

        
    }
        
        
        /*
        public void imprimirTablero(String[][] tablero) {

        System.out.println("MAPA DEL ORDENADOR");
        System.out.print("  _0_ _1_ _2_ _3_ _4_ _5_ _6_ _7_ _8_ _9_");
                         
        for (int f = 0; f < tablero.length; f++) {
            System.out.println();

            for (int c = 0; c < tablero[f].length; c++) {
                
//                if (tablero[f][c] == "A"||tablero[f][c]=="*") {
                    if (tablero[f][c] != null){
                    System.out.print(c == 0 ? (char)(65+f) + "|_" + String.valueOf(tablero[f][c]) + "_" : "|_" + String.valueOf(tablero[f][c]) + "_");
                } 
            else {
                    System.out.print(c == 0 ? (char)(65+f) + "|_ _" : "|_ _");
                }
            }

            System.out.print("|");
        }

        System.out.println();
        System.out.println("\nPUNTOS RESTANTES DEL ORDENADOR: "+ getMarcadorOrdenador()+"\n\n\n");

        
                

    }

        */
   
        
        
        @Override
        public boolean turno(String tablero[][]){
            
            Random ran=new Random();
            int f;
            int c;
         
               
                do{
                 
                  f=ran.nextInt(9);
                  c=ran.nextInt(9);
                  
                }while(tablero[f][c]=="A"||tablero[f][c]=="*"); 
                
                System.out.println("EL ORDENADOR HA ELEGIDO LA CASILLA: "+((char)(f+65))+(c));
                if(tablero[f][c]!=null){

                    hundido(tablero, f, c, "EL ORDENADOR");
                    tablero[f][c]="*";
                    setMarcadorJugador(getMarcadorJugador()-1);
                return true;
                

                
                }
            
            else {
                System.out.println("El ORDENADOR HA HECHO AGUA");
                tablero[f][c]="A";
                return false;
            }
     
           
    }
}
