/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq;

/**
 *
 * @author HUGO
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) {

        File archivo;
        FileReader fr;
        BufferedReader buff;
        try {
            // TODO code application logic here
            archivo = new File(args[0]);
            fr = new FileReader(archivo);
            buff = new BufferedReader(fr);

            String esquinaSuperiorDerecha = buff.readLine();
            StringTokenizer tok = new StringTokenizer(esquinaSuperiorDerecha, " ");
            
            int upper = 0;
            int right = 0;
            
            if (tok.hasMoreTokens()) {
                upper = Integer.parseInt(tok.nextToken());
                if (tok.hasMoreTokens()) {
                    right = Integer.parseInt(tok.nextToken());
                }
            }
            
            if ((Integer.valueOf(upper) instanceof Integer) && (Integer.valueOf(right) instanceof Integer)) {
                
                if (upper > 0 && right > 0) {
                    Plateau.getInstance(upper, right);            
                    String linea;            

                    while ((linea = buff.readLine()) != null) {

                        StringTokenizer tok2 = new StringTokenizer(linea, " ");
                        int x = Integer.parseInt(tok2.nextToken());
                        int y = Integer.parseInt(tok2.nextToken());
                        char orientacion = tok2.nextToken().charAt(0);

                        Rover rov = new Rover(x, y, orientacion);
                        if (rov.isHabil()) {
                            String instruccion = buff.readLine();
                            rov.obedecerInstruccion(instruccion);
                            rov.mostrarPosicion();
                        } else {
                            buff.readLine();
                        }                
                    }
                } else {
                    System.out.println("Los valores proporcionados para la coordenada upper-right deben ser mayores a cero.");
                }
            }
                                                
            
        } catch (Exception ex) {
            if (ex instanceof NumberFormatException) {
                System.out.println("Alguno de los valores proporcionados como coordenadas x y no son numeros");
            } 
        }

    }
}
