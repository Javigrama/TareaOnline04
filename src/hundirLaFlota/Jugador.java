/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirLaFlota;

import utilidades.IO_ES;

/**
 *
 * @author javie
 */
public class Jugador extends HundirlaFlota {
    
    
    /**
     * Constructor de jugador que llama al super
     */
    
  public Jugador(){
      super();
  }
        
  /**
   * El tablero del jugador refleja todos los barcos y los disparos
   * del ordenador
   * @param tablero Recibe el tablero para imprimir los valores del mismo
   */
    
    
  @Override
    public void imprimirTablero(String[][] tablero) {

        System.out.println("MAPA DEL USUARIO");
        System.out.print("  _0_ _1_ _2_ _3_ _4_ _5_ _6_ _7_ _8_ _9_");
                         
        for (int f = 0; f < tablero.length; f++) {
            System.out.println();

            for (int c = 0; c < tablero[f].length; c++) {
                if (tablero[f][c] != null) {
                    System.out.print(c == 0 ? (char)(65+f) + "|_" + String.valueOf(tablero[f][c])
                            
                            + "_" : "|_" + String.valueOf(tablero[f][c]) + "_");
                } 
                
                else {
                    System.out.print(c == 0 ? (char)(65+f) + "|_ _" : "|_ _");
                }
            }

            System.out.print("|");
        }

        System.out.println();
        System.out.println("\nPUNTOS RESTANTES DEL JUGADOR: "+ getMarcadorJugador());
      

        

    }
        
    
        /**
         * Método que solicita coordenadas y asigna valor de agua o tocado
         * @param tablero recibe el tablero del ordenador para asignarle valores
         * @return un booleano que informa si ha sido tocado o agua
         */
        
         /*Llamamos al método de validar coordenadas y recibimos un String de una 
         * carácter letra y un número. Seleccionamos la letra y le restamos 65 que
         * es el valor de la A, lo que nos va a dar un valor de 0 a 9 y al castearlo 
         * a int tenemos nuestro primer valor para iterar. El seguno valor con un
           parse es suficiente. Se avisa si repite coordenada y si es el caso, como
           la solicitud está dentro de un ciclo, pues hay nuevas oportunidades
           El método llama además a hundido `para determinar el alcance de tocado,
           asigna valores y maneja el marcador
        */
        
  @Override
    public boolean turno(String[][] tablero){
            
            String casilla;        
            int f;
            int c;
            
            
           
            
            do{
                  casilla=IO_ES.validarCoordenadas();
                  f=(int)(casilla.charAt(0)-65);
//                c=(int)(casilla.charAt(1)-48);
                  c=Integer.parseInt(String.valueOf(casilla.substring(1)));
               
                  if((tablero[f][c])==("A")) System.out.println("Ya eligió esa casilla antes y fue AGUA");
                  else if((tablero[f][c])==("*")) System.out.println("Ya eligió esa casilla antes y fué tocado");
            }while(tablero[f][c]==("A")||tablero[f][c]==("*")); 
            
            
            if(tablero[f][c]!=null){
                

                hundido(tablero, f, c, "EL JUGADOR");
                tablero[f][c]="*";
                setMarcadorOrdenador(getMarcadorOrdenador()-1);
                return true;
                
            }
            
            else {
                System.out.println("EN ESA POSICIÓN ES AGUA");
                tablero[f][c]="A";
               
            }
            return false;
        
     }

    

    
}
