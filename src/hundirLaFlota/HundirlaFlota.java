/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirLaFlota;

import java.util.Random;

/**
 * Clase que emula el famosísimo juego del hundir la flota
 * Aunque en la tarea no se solicita he creado la clase de forma que 
 * se avise si se hunde un barco. La clase es superclase de la clase 
 * Ordenador y la clase Jugador, que no añaden nuevas variables
 * pero cada una de ellas implementa los métodos imprimirTablero y 
 * turno de forma diferente. Se ha optado por colorear sólo el mapa
 * del Ordenador que es nuestro mapa objetivo
 *  * @author Javier Martínez Ruiz
 */
public abstract class HundirlaFlota {
    
    
        String[][] tablero;
        static int marcadorJugador;
        static int marcadorOrdenador;
        final int LIMARRIBA = 0;
        final int LIMDERECHA = 9;
        final int LIMIZQUIERDA = 0;
        final int LIMABAJO = 9;
        private int reset;
        final String VERDE = "\u001B[32m";
        final String ROJO="\u001B[31m";
        final String RESET = "\u001B[0m";
        
       /**
        * El constructor establece los marcadores en 24
        * Crea el tablero con 10 posiciones, asigna 30 a la variable reset
        * y asigna valores al tablero con el método validarTablero.
        * La variable reset sirve para resetear el Tablero, es decir ponerlo a
        * null nuevamente si entra en un bucle en el que todas las asignaciones
        * devuelven false o se producen ArraysOutOfBounds Exceptions. Puede ocurrir
        * si los barcos se disponen de tal forma que no se cumplan las condiciones
        * de emplazamiento. Estas condiciones implican que haya horizontal o 
        * verticalmente, al menos un espacio de separación entre barco y barco
        */
    
    public HundirlaFlota(){
        
        marcadorJugador=24;    
        marcadorOrdenador=24;
        tablero=new String[10][10];
        setReset(30);            
        validarTablero(tablero); 
                                
        
    }

     public abstract void imprimirTablero(String[][] tablero);
     
     public abstract boolean turno(String[][] tablero);
     
    /**
     * Un getter que devuelve el valor de reset
     * @return el valor de reset
     */
    
    public int getReset() {
        return reset;
    }

    
    /**
     * UN setter que setea el valor de reset
     * @param reset 
     */
    private void setReset(int reset) {
        this.reset = reset;
    }
    
    
    /**
     * getter que sirve para obtener el tablero
     * @return Devuelve el tablero
     */
    public String[][] getTablero() {

        return tablero;
    }

    
    /**
     * Getter que devuelve el marcador del jugador.
     * Los marcadores son static pues nos sirve un marcador
     * para ambas clases, jugador y ordenador
     * @return el marcador del jugador
     */
 
    public static int getMarcadorJugador() {
        return marcadorJugador;
    }
    
    /**
     * Para setear el marcador del jugador si hay tocado
     * @param marcadorJugador 
     */

    public static void setMarcadorJugador(int marcadorJugador) {
        HundirlaFlota.marcadorJugador = marcadorJugador;
    }

    
    /**
     * getter para obtener el marcador del ordenador
     * @return el marcador del ordenador
     */
    public static int getMarcadorOrdenador() {
        return marcadorOrdenador;
    }
    
    /** Para setear el marcador del ordenador si hay tocado
     * @param marcadorOrdenador 
     */

    public static void setMarcadorOrdenador(int marcadorOrdenador) {
        HundirlaFlota.marcadorOrdenador = marcadorOrdenador;
    }

    
    /**
     * Método que devuelve el resultado del juego
     * @return Devuelve un String con el resultado  
     */
    
    public static String resultado(){
        
        if(getMarcadorJugador()==0) {
            return "And the winner is...EL ORDENADOR!!!";
        }
        else if(getMarcadorOrdenador()==0){
            
            return "And the winner is...EL HUMANO!!!";
        }
        return "";
    }
        
    
    /**
     * Este método inicia una nueva partida construyendo un
     * nuevo jugador y un nuevo ordenador. Se establecen dos booleanos, uno para
     * indicar si hay ganador y otro que establece el turno. La partida se desarrolla
     * en un ciclo que perdura mientras winner sea false y el turno es para el 
     * ordenador cuando turno es false y para el jugador cuando turno es true. 
     * 
     */
    
    
    /*La dinámica de la partida es la siguiente: 
    Primero se imprimen los dos tableros, el del ordenador vacío y el del jugador
    con los barcos correspondientes que han sido asignados aleatoriamente.
    Mientras la variable winner sea false, estamos dentro de un bucle do while.
    Si un contrincante reduce el marcador de otro contrincante a 0, winner se 
    torna true y se rompe el ciclo finalizando la partida.
    Dentro de este ciclo hay dos ciclos while que son manejados por la variable 
    turno. Mientras turno sea false se ejecuta
    el turno del ordenador y mientras sea true se ejecuta el turno del jugador.
    Dentro de cada turno hay otro do while que se ejecuta mientras el método
    turno devuelva true. Es decir, un jugador ejecuta el método booleano turno. 
    Si este método devuelve true es que se ha tocado a un barco y la variable tocado
    se torna true. Se producen asignaciones de tablero y marcador, se imprime y 
    vuelve a tirar. Si no se toca se producen asignaciones de Agua y la variable tocado
    se torna false con lo que se rompe el do while interno. Se cambia la variable
    turno y empieza el turno del oponente que sigue la misma dinámica, es decir, 
    turno boolean, dónde se producen las asignaciones, impresión por pantalla con 
    los nuevos datos y comprobación de condiciones de victoria.
    
    */
    
     public static void nuevaPartida(){
        
        Jugador jugador;
        Ordenador ordenador;
         
        boolean winner=false;
        boolean turno=true;

       
        jugador=new Jugador();
        ordenador=new Ordenador();
        boolean tocado=false;
        
        
        
         ordenador.imprimirTablero(ordenador.getTablero());
         jugador.imprimirTablero(jugador.getTablero());
            do{
                 
               
        
              while(!turno){
                 
                  do{
                        tocado=ordenador.turno(jugador.getTablero());    //turno
                        ordenador.imprimirTablero(ordenador.getTablero());  //impresión de resultados
                        jugador.imprimirTablero(jugador.getTablero());
                        if(getMarcadorJugador()==0) winner=true;   //condiciones de victoria
                        
                  }while(tocado&&!winner);   //condiciones de turno
                  
                  turno=true;

              }
        
              while(turno){
                  
                  do{
                        tocado=jugador.turno(ordenador.getTablero());
                        ordenador.imprimirTablero(ordenador.getTablero());
                        jugador.imprimirTablero(jugador.getTablero());
                        if(getMarcadorOrdenador()==0) winner=true; 
                  }while(tocado&&!winner);
                 
                   turno=false;
                  }
                 
              
            }while(!winner);
     
        System.out.println(resultado());

    }


    
     
     /**
      * Método que sirve para hacer las asignaciones de barcos al tablero
      * 
      * @param tablero Recibe el tablero sobre el que se harán las asignaciones
      * @see #validarBarco
      */
    
     
     
     /* Este método sirve para asignar valores o barcos al tablero
     Tiene los 10 barcos en un array y mediante bucle for va suministrando
     las esloras de cada barco para validarlos. Puede ocurrir que al asignar los barcos
     queden dispuestos de tal forma que la asignación de otro ya no sea posible
     y los métodos de asignación entren en un bucle en el que siempre devuelvan
     false. Para subsanar esto se ha creado un contador y un método de reseteo de 
     tablero. Si se alcanzan 30 excepciones, se resetea el tablero a null
     y se vuelve a lanzar desde 0 la asignación de barcos. Si no se alcanzan, el
     tablero queda valiadado. 
     */
    private void validarTablero(String[][]tablero){
        
        
        int[] barcos = {5, 5, 3, 3, 3, 1, 1, 1, 1, 1};
        int eslora;
        boolean validado=false;
        
      do{
           
            for(int i=0; i<barcos.length; i++){
                eslora=barcos[i];
            
                    validarBarco(tablero, eslora);
                   
                    } 
              if(this.getReset()<0){
                 this.resetablero();
                 this.setReset(30);
           
              }
              
              else validado=true;
             
       }while(!validado);
    }
    
    
    /**
     * Void que sirve para poner el tablero a null en caso de bucle en las
     * asignaciones
    */
    
    public void resetablero(){
        
        for(int i=0; i<tablero.length; i++)
            for(int j=0; j<tablero[i].length; j++)
                tablero[i][j]=null;
    }

    
    /**
     * Método que valida cada barco. En un bucle do while que continúa 
     * mientras no se asigne un barco y el contador de reset sea mayor o igual que 0
     * Se genera una coordenada aleatoria y se comprueba si el barco encaja en 
     * el tablero. Se va comprobando por cada lado y si encaja se asigna,
     * se sale del bucle y se recibe una nueva eslora por parte del método validarTablero
     * @param tablero recibe el tablero
     * @param eslora El length del barco
     */
    
    
    private void validarBarco(String[][] tablero, int eslora) {

        Random ran = new Random();
        int f; 
        int c; 
        boolean asignado=false;
        
      

     
        do{
            f= ran.nextInt(9);
            c= ran.nextInt(9);
         
        
            if(izquierdaPegado(tablero, eslora, f, c)||izquierdaDespegado(tablero, eslora, f, c)){
               
                for(int i=0; i<eslora ; i++){
                    tablero[f][c-i]=String.valueOf(eslora);
                }

                asignado=true;
              

            }
          
          
          /*  else if(izquierdaDespegado(tablero, eslora, f, c)){
               
                for(int i=0; i<eslora ; i++){
                    tablero[f][c-i]=String.valueOf(eslora);
                }

                asignado=true;
              

           }*/
          
            else if (abajoPegado(tablero, eslora, f, c)||abajoDespegado(tablero, eslora, f, c)) {

                for (int i = 0; i < eslora; i++) {
                     tablero[f + i][c] = String.valueOf(eslora);
            }

               asignado=true;

            } 
            
            
          /*  else if (abajoDespegado(tablero, eslora, f, c)) {

                for (int i = 0; i < eslora; i++) {
                     tablero[f + i][c] = String.valueOf(eslora);
            }

               asignado=true;

            }*/ 
           
           
           
            else if(derechaPegado(tablero, eslora, f, c)||(derechaDespegado(tablero, eslora, f, c))){
               
                for(int i=0; i<eslora ; i++){
                    tablero[f][c+i]=String.valueOf(eslora);
                }

                asignado=true;

                    
            }
           
           
            /*else if(derechaDespegado(tablero, eslora, f, c)){
               
               for(int i=0; i<eslora ; i++){
                    tablero[f][c+i]=String.valueOf(eslora);
                }

                asignado=true;

                    
            }*/
           
            
            else if (arribaPegado(tablero, eslora, f, c)||arribaDespegado(tablero, eslora, f, c)) {

                for (int i = 0; i < eslora; i++) {
                      tablero[f - i][c] = String.valueOf(eslora);
            }

                asignado=true;

            } 
            
           /* else if (arribaDespegado(tablero, eslora, f, c)) {

                for (int i = 0; i < eslora; i++) {
                      tablero[f - i][c] = String.valueOf(eslora);
            }

                asignado=true;

            } */
        
        
           
 
        }while(!asignado&&getReset()>=0);

    }

    /**
     * LOS MÉTODOS PRIVADOS NO GENERAN JAVADOC PERO SE INCLUYE AQUÍ
     * 
     * Metodo que comprueba si un barco encaja en tablero, devolviendo
     * false si no encaja y true si encaja
     * @param tablero Recibe el tablero
     * @param eslora  El length del barco
     * @param fila    La coordenada fila
     * @param columna La coordenada columna
     * @return        Devuelve true or false en función de si encaja
     */
    
    
    
    
    /*
    Los 8 métodos que siguen tiene la misma dinámica y se encargan de comprobar 
    si encajan en el tablero, por la izquierda, la derecha, arriba y abajo. En primer
    lugar se comprueba si la longitud del barco, la eslora sobresale por el borde
    izquierdo del tablero. Supongamos que se generó coordenada columna 4 y la eslora 
    recibida es 5. Pues si le restamos a 4 la eslora -1, nos daría  0, que es igual
    al límite izquierdo, con lo que el barco cumpliría la condición de longitud.
    A continuación, si la longitud se cumple, comprobamos si la longitud llega
    justo hasta el borde o sobra. Es importante porque el barco puede quedar 
    pegado al borde. Si queda pegado al borde sólo necesitamos que el tablero sea
    null por la derecha una celda y por arriba y por abajo de la fila en todas las
    celdas. Si no queda pegado al borde, también necesitamos que por la izquierda,
    al menos una celda sea null para cumplir las condiciones de emplazamiento.
    En las filas de arriba y de abajo, sólo hace falta comprobar la longitud del barco
    pero no es necesario comprobar las diagonales, pues se permite el emplazamiento
    de otros barcos. Por eso no le sumo 1 a la columna en las filas de arribay abajo.
    En el momento en que alguna condición no se cumpla devuelve false y además
    si se producen excepciones reduce el contador de reset previeniendo el bucle
    infinito.
    */
    
    
    
    
    
    
    
  
    
         
    private boolean izquierdaPegado(String[][] tablero, int eslora, int fila, int columna) {

       
       
        boolean longitud;
        boolean asignado=true;
        
            if (columna - (eslora - 1) == LIMIZQUIERDA) {
                longitud = true;
            } else {
                longitud=false;
                asignado=false;
            }

           try{
            if (longitud) {

                for (int i = 0; i <= eslora&&asignado; i++) {
                    if (tablero[fila][(columna+1)-i] != null) {
                        asignado= false;
                    }
                }
                 
                for (int i = 0; i < eslora&&asignado; i++) {
                    if(tablero[fila-1][columna-i]!=null){ 
                        asignado=false;
                    }
                    else if(tablero[fila+1][columna-i]!=null){
                        asignado=false;
                    }
                }
                
            }
           }catch(ArrayIndexOutOfBoundsException e){
//               System.out.println("comprobaciones izquierda");
//               System.out.println(reset+" "+this.getClass());
               this.setReset(getReset()-1);
               asignado=false;
           }
           
           return asignado;
    }
     
    
    private boolean izquierdaDespegado(String[][] tablero, int eslora, int fila, int columna) {
        
        boolean longitud;
        boolean asignado=true;
        
            if (columna - (eslora - 1) > LIMIZQUIERDA) {
                longitud = true;
            } else {
                longitud=false;
                asignado=false;
            }
            
            
        try{
            if (longitud) {

                for (int i = 0; i <= (eslora+1)&&asignado; i++) {
                    if (tablero[fila][(columna+1)-i] != null) {
                        asignado= false;
                    }
                }
                 
                for (int i = 0; i < eslora&&asignado; i++) {
                     if(tablero[fila-1][columna-i]!=null){ 
                        asignado=false;
                    }
                    else if(tablero[fila+1][columna-i]!=null){
                        asignado=false;
                    }
                }
               
            }
            
        }catch(ArrayIndexOutOfBoundsException e){
//                  System.out.println("comprobaciones izquierda");
//                  System.out.println(reset+""+this.getClass());
                  this.setReset(getReset()-1);
                  asignado= false;
           }
           
           
        return asignado;
    }
        
        

    
    private boolean derechaPegado(String[][] tablero, int eslora, int fila, int columna) {

        boolean longitud;
        boolean asignado=true;
        
        if (columna + (eslora - 1) == LIMDERECHA) {
              longitud = true;
        } 
        
        else {
              longitud=false;
              asignado=false;
        }

        try{
            if (longitud) {

                for (int i = 0; i <= eslora; i++) {
                    if (tablero[fila][(columna-1)+i] != null) {
                        asignado = false;
                    }
                }
                
                for (int i = 0; i < eslora&&asignado; i++) {
                    
                    if(tablero[fila-1][columna+i]!=null){
                        asignado = false;
                    }
                    else if(tablero[fila+1][columna+i]!=null){
                        asignado = false;
                    }
                }
                
            }
        }catch(ArrayIndexOutOfBoundsException e){
                 this.setReset(getReset()-1);
                 asignado= false;
        }
     
        return asignado;
    }   
        
    
    private boolean derechaDespegado(String[][] tablero, int eslora, int fila, int columna) {

        boolean longitud;
        boolean asignado=true;
        
        if (columna + (eslora - 1) < LIMDERECHA) {
              longitud = true;
        } 
        
        else {
              longitud=false;
              asignado=false;
        }
        
        try{
            if (longitud) {

                for (int i = 0; i <= eslora+1; i++) {
                    if (tablero[fila][(columna-1)+i] != null) {
                        asignado= false;
                    }
                }
                
                for (int i = 0; i < eslora&&asignado; i++) {
                    
                    if(tablero[fila-1][columna+i]!=null){
                        asignado= false;
                    }
                    else if(tablero[fila+1][columna+i]!=null){
                        asignado= false;
                    }
                }
                
            }
        }catch(ArrayIndexOutOfBoundsException e){
                     this.setReset(getReset()-1);
                     asignado= false;
        }
       
        return asignado;
    }
    
    
      
    private boolean arribaPegado(String[][] tablero, int eslora, int fila, int columna) {

        boolean longitud;
        boolean asignado=true;
        
        if (fila - (eslora - 1) == LIMARRIBA) {
            longitud = true;
        } 
        
        else {
            longitud = false;
            asignado = false;
        }

        
        
        try{
            if (longitud){

                for (int i = 0; i <= eslora; i++) {
                    if (tablero[(fila+1)-i][columna] != null) {
                        asignado = false;
                    }
                }
                
                for(int i=0; i < eslora&&asignado; i++){   
                    
                    if(tablero[fila-i][columna-1]!=null){
                        asignado = false;
                    }
                    else if(tablero[fila-i][columna+1]!=null){
                        asignado = false;
                    }
                }    
            }
            
        }catch(ArrayIndexOutOfBoundsException e){
                    this.setReset(getReset()-1);
                    asignado = false;
        }
        return asignado;
    }
    
    
    
    private boolean arribaDespegado(String[][] tablero, int eslora, int fila, int columna) {

        boolean longitud;
        boolean asignado=true;
        
        if (fila - (eslora - 1) > LIMARRIBA) {
            longitud = true;
        } 
        
        else {
            longitud = false;
            asignado = false;
        }
         
        try{
            if (longitud){

                for (int i = 0; i <= eslora+1; i++) {
                    if (tablero[(fila+1)-i][columna] != null) {
                        asignado = false;
                    }
                }
                
                for(int i=0; i < eslora&&asignado; i++){   
                     
                    if(tablero[fila-i][columna-1]!=null){
                        asignado = false;
                    }
                    else if(tablero[fila-i][columna+1]!=null){
                        asignado = false;
                    }
                }
            }
            
        }catch(ArrayIndexOutOfBoundsException e){
                     this.setReset(getReset()-1);
                     asignado = false;
        }
           
        return asignado;
    }

    
    
        
    private boolean abajoPegado(String[][] tablero, int eslora, int fila, int columna) {

        boolean longitud;
        boolean asignado=true;

        if (fila + (eslora - 1) == LIMABAJO) {
            longitud = true;
        } else {
            
            longitud=false;
            asignado= false;
        }

        try{
            if (longitud) {

                for (int i = 0; i <=eslora; i++) {
                    
                    if (tablero[(fila-1)+i][columna] != null) {
                        asignado = false;
                    }
                }
                
                 for (int i = 0; i <eslora&&asignado; i++) {
                
                    if(tablero[fila+i][columna-1]!=null){
                        asignado = false;
                    }
                
                    else if(tablero[fila+i][columna+1]!=null){
                        asignado = false;
                    }
                
                }
                
            }
        }catch(ArrayIndexOutOfBoundsException e){
              this.setReset(getReset()-1);
              asignado = false;
        }
        return asignado;
    }
    
    
    
    
    private boolean abajoDespegado(String[][] tablero, int eslora, int fila, int columna) {

        boolean longitud;
        boolean asignado=true;

        if (fila + (eslora - 1) < LIMABAJO) {
            longitud = true;
        } else {
            
            longitud=false;
            asignado= false;
        }
    
        try{
            if (longitud) {

                for (int i = 0; i <=eslora+1; i++) {
                    if (tablero[(fila-1)+i][columna] != null) {
                        asignado = false;
                    }
                }
                
                for (int i = 0; i <eslora&&asignado; i++) {
                
                    if(tablero[fila+i][columna-1]!=null){
                        asignado = false;
                    }
                    else if(tablero[fila+i][columna+1]!=null){
                        asignado = false;
                    }
                
                }
                 
           }
        }catch(ArrayIndexOutOfBoundsException e){
                this.setReset(getReset()-1);
                asignado = false;
        }
        return asignado;
    }

    
    /**
     * Método que sirve para comprobar si un barco esta tocado o ha sido hundido
     * Cuando un barco es tocado este método rescata el valor de la eslora del 
     * barco. Si ese valor es 1 informa que el barco está hundido
     * Si no es 1 informa que es tocado y además le resta uno al valor de la eslora y
     * se lo asigna a todas las celdas en un radio de la máxima eslora, es decir 5
     * que tengan el mismo valor. Podría ocurrir que existieran
     * dos barcos con la misma eslora separados sólo por una celda null o con valor
     * "Agua". Por ejemplo dos barcos de 3 separados sólo por una celda. Cómo la 
     * eslora es 3 e iteraríamos 4 celdas,
     * podría ocurrir que asignaramos a un barco equivocado un valor equivocado.
     * Aquí, el uso del break para parar un bucle ha resultado idóneo. Si una celda
     * es 3, le asignamos dos y ahora comprobamos en un radio de 4. Si la siguiente es null 
     * o agua paramos el bucle y empezamos el mismo bucle por otro costado y así
     * hasta hacer los 4 polos. El resultado es que si hay tocado se reduce el valor
     * de las celdas que simbolizan ese barco en 1
     * 
     * @param tablero El tablero
     * @param fila las coordenadas de fila y columna
     * @param columna
     * @param player el jugador que interviene
     */
             
    public void hundido(String[][] tablero, int fila, int columna, String player){
        
        String valor=tablero[fila][columna];
//        int eslora=Integer.parseInt(valor);
           int eslora=5;
        String nuevovalor=String.valueOf(Integer.parseInt(valor)-1);
        boolean avanti=true;
        
            if(valor.equals("1")){
                 System.out.println(ROJO+player +" HA HUNDIDO UN BARCO!!!!"+RESET);
             }
        
            else {
              
                
                      
//                     Comprobamos parte izquierda
                try{
                    for(int i=1; i<eslora&&avanti; i++){
                        
                        
                        if((tablero[fila][columna-i]==null)||(tablero[fila][columna-i].equals("A"))) avanti= false;
//                        else if(tablero[fila][columna-i].equals("A")) avanti=false;
                        else if((tablero[fila][columna-i].equals(valor))&&avanti) tablero[fila][columna-i]=nuevovalor;
//                              
                        }
                         
                    
                }catch(ArrayIndexOutOfBoundsException e){ 
//                        System.out.println("capturada");
                }
                
                
                avanti=true;
                  
//                       Comprobamos parte derecha
                try{
                    for(int i=1; i<eslora&&avanti; i++){
                        
                        if((tablero[fila][columna+i]==null)||(tablero[fila][columna+i].equals("A"))) avanti=false;
//                        else if(tablero[fila][columna+i].equals("A")) break;
                        else if((tablero[fila][columna+i].equals(valor))&&avanti) tablero[fila][columna+i]=nuevovalor;
//                              
                        }
                         
                }catch(ArrayIndexOutOfBoundsException e){ 
//                    System.out.println("capturada");
                }
                
                
              
                avanti=true;
                
//                             Comprobamos parte ARRIBA
                try{
                    for(int i=1; i<eslora&&avanti; i++){
                        
                        if((tablero[fila-i][columna]==null)||(tablero[fila-i][columna].equals("A"))) avanti=false;
//                        else if(tablero[fila-i][columna].equals("A")) break;
                        else if((tablero[fila-i][columna].equals(valor))&&avanti) tablero[fila-i][columna]=nuevovalor;
//                             
                        }
                         
                    
                }catch(ArrayIndexOutOfBoundsException e){ 
//                    System.out.println("capturada");
                }
                

                avanti=true;
                
//                               Comprobamos parte ABAJO
                try{
                    for(int i=1; i<eslora&&avanti; i++){
                        
                        if((tablero[fila+i][columna]==null)||tablero[fila+i][columna].equals("A")) avanti=false;
//                        else if(tablero[fila+i][columna].equals("A")) break;
                        else if(tablero[fila+i][columna].equals(valor)) tablero[fila+i][columna]=nuevovalor;
//                              
                        }
                         
                    
                }catch(ArrayIndexOutOfBoundsException e){
//                    System.out.println("capturada");
                }
                
                
                
                
                
                /*
                
//                     Comprobamos parte izquierda
                try{
                    for(int i=1; i<eslora; i++){
                        
                        
                        if(tablero[fila][columna-i]==null) break;
                        else if(tablero[fila][columna-i].equals("A")) break;
                        else if(tablero[fila][columna-i].equals(valor)) tablero[fila][columna-i]=nuevovalor;
//                              
                        }
                         
                    
                }catch(ArrayIndexOutOfBoundsException e){ 
//                        System.out.println("capturada");
                }
                
                
                
                
//                       Comprobamos parte derecha
                try{
                    for(int i=1; i<eslora; i++){
                        
                        if(tablero[fila][columna+i]==null) break;
                        else if(tablero[fila][columna+i].equals("A")) break;
                        else if(tablero[fila][columna+i].equals(valor)) tablero[fila][columna+i]=nuevovalor;
//                              
                        }
                         
                }catch(ArrayIndexOutOfBoundsException e){ 
//                    System.out.println("capturada");
                }
                
                
              
                
                
//                             Comprobamos parte ARRIBA
                try{
                    for(int i=1; i<eslora; i++){
                        
                        if(tablero[fila-i][columna]==null) break;
                        else if(tablero[fila-i][columna].equals("A")) break;
                        else if(tablero[fila-i][columna].equals(valor)) tablero[fila-i][columna]=nuevovalor;
//                             
                        }
                         
                    
                }catch(ArrayIndexOutOfBoundsException e){ 
//                    System.out.println("capturada");
                }

                
//                               Comprobamos parte ABAJO
                try{
                    for(int i=1; i<eslora; i++){
                        
                        if(tablero[fila+i][columna]==null) break;
                        else if(tablero[fila+i][columna].equals("A")) break;
                        else if(tablero[fila+i][columna].equals(valor)) tablero[fila+i][columna]=nuevovalor;
//                              
                        }
                         
                    
                }catch(ArrayIndexOutOfBoundsException e){
//                    System.out.println("capturada");
                }
                */
               System.out.println(ROJO+ player+ " HA ALCANZADO UN BARCO!!!"+ RESET);  
            
             }
        
      
           
    }
   
}


