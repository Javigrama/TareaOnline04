/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays_CC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import utilidades.IO_ES;

/**
 * Clase que despliega un menú para seleccionar los diferentes ejercicios. Al
 * igual que en los casos anteriores, el método que se encarga de validar la
 * entrada es el que controla la posible excepción por error en la inserción
 *
 */
public class CadenaCaracteres {

    final String palabra = "$Hyperboss";
    final String ROJO = "\u001B[31m";

    public void opcionesMenu() {

        int opcion = -1;

        do {

            System.out.println();
            System.out.println("Introduzca una opción");
            System.out.println("1. Buscapalabras:  ");
            System.out.println("2. COÑAZO azul: ");
            System.out.println("3. Primera Frase:  ");
            System.out.println("0. Salir:  ");
            System.out.print("--> ");
            opcion = IO_ES.leerInteger("Seleccione una opción entre ", 0, 3);

            switch (opcion) {

                case 0:
                    System.out.println("Retornando al menu principal");
                    break;

                case 1:
                    System.out.println(palabra + " aparece " + buscaPalabra(getContenido(), palabra) + " veces");
                    break;

                case 2:
                    azul(getContenido(), palabra);
                    break;

                case 3:
                    System.out.println(primeraFrase(getContenido(), palabra));
                    break;

                default:
                    System.out.println("Del 1 al 3 y 0 si desea salir");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Método que nor sirve para recuperar el contenido del archivo sobre el que
     * vamos a trabajar
     *
     * @return devuelve un String con el contenido del documento
     */
    public String getContenido() {

        String str = "";
        try {
            str = new String(Files.readAllBytes(Paths.get("..\\MRJ_Online04\\src\\arrays_CC\\lectura.txt")));
        } catch (IOException e) {
            System.out.println(ROJO + "ERROR al recuperar el archivo " + e.getMessage());
        }
        return str;
    }

    /**
     * Método que cuenta palabras. Sólo nos sirve para ésta tarea pues hemos
     * eliminado todos los signos de puntuación, excepto las tildes buscando el
     * símbolo $ y carácteres para que encajen con $Hyperboss. El método divide
     * el texto en tokens con Scanner y cada token es asignado a la variable
     * str. De cada token se eliminan todo lo que no sean carácteres de la A a
     * la Z, de la a a la z o las vocales con tilde y se sustituyen por cadena
     * vacía. Una vez hecho esto hacemos un trim para eliminar espacios y
     * comparamos con equals con lo que buscamos. Si hay coincidencia sumamos
     * uno al contador.
     *
     * @param texto El texto en el que buscamos
     * @param palabra Es la palabra buscada
     * @return Devuelve el número de veces que se repite la palabra
     */
//       Después de elaborar este método descubrí el método contains()  de
//       String que hace esto mucho más sencillo. 
    public int buscaPalabra(String texto, String palabra) {

        String str = "";
        int contador = 0;
//           CharSequence palabra2= "$Hyperboss";   
        Scanner entrada = new Scanner(texto);
        while (entrada.hasNext()) {

            str = entrada.next();
//                    if(str.contains(palabra2)) contador++;
            str = str.replaceAll("[^A-Za-z$áéíóú]", "");
            str = str.trim();
            if (str.equals(palabra)) {
                contador++;
            }

        }

        return contador;
    }

    /**
     * Método que busca coincidencias del 2º parámetro en el primero y en dónde
     * encuentre el 2º parámetro lo sustituye por otro String coloreado además
     * de azul
     *
     * @param texto Es el texto en el que buscamos el segundo parámetro
     * @param palabra2 Es el String que buscamos y que sustituiremos por otro
     * coloreado de azul
     */
    public void azul(String texto, String palabra2) {

        String AZUL = "\u001B[34m";
        String RESET = "\u001B[0m";
        String str = "";
        Scanner entrada = new Scanner(texto);

        while (entrada.hasNext()) {

            str = entrada.next();
            if (str.contains(palabra2)) {

                str = str.replace("$Hyperboss", "COÑAZO");
                System.out.print(AZUL + str + RESET + " ");
            } else {
                System.out.print(str + " ");
            }

        }
        System.out.println();
    }

//         Este método comentado hace lo mismo y lo construí antes de 
//         descubrir el método contains de String. Es más elaborado
//         pues usa el método matches de String y una regex
    /*public void azul(String texto, String palabra){
          
                  String AZUL = "\u001B[34m";
                  String RESET = "\u001B[0m";
                  String str="";
                  Scanner entrada=new Scanner(texto);
                  
                    while(entrada.hasNext()){
               
                        str=entrada.next();
                        if(str.matches(".?\\$Hyperboss.*")){
                            
                             str=str.replace("$Hyperboss", "COÑAZO");
                             System.out.print(AZUL+str+RESET+" ");
                        }
                        else System.out.print(str+" ");
                        
                    }
                         System.out.println();
           }    */
    
    
    
    
    /**
     * Método que imprime por pantalla la primera frase del texto recibido como
     * primer parámetro en la que aparece el string recibido en el segundo
     * parametro
     *
     * @param texto Es el texto en el que buscamos la coincidencia
     * @param palabra Es la cadena que buscamos.
     * @return Devuelve la primera frase del texto en la que aparece la cadena
     */
    
    
    //He convertido el texto en un array de Strings y he utilizado el 
//         punto '.' para separar los tokens. De esa forma obtengo frases completas.
//         Luego itero por el array de Strings desde la posición 0 y si encuentra
//         la palabra buscada devuelve lo que contiene la celda en la que hemos 
//         hallado la palabra que no es otra cosa que una frase pues el split
//         fue por puntos.
    
    public String primeraFrase(String texto, String palabra) {

        String str = "";
        String[] splitter = texto.split("\\.");
        int c;

        for (int i = 0; i < splitter.length; i++) {

            c = splitter[i].indexOf(palabra);
            if (c != -1) {
                return splitter[i];
            }
        }

        return str;
    }

}
