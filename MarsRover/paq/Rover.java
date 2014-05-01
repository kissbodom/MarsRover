/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paq;

/**
 *
 * @author HUGO
 */ 
public class Rover {

    private int x;
    private int y;
    private char orientacion;
    private boolean habil;
    private static int cuantos = 0;
    private int n;


    public Rover() {
    }

    public Rover(int x, int y, char orientacion) {
        cuantos++;
        this.n = cuantos;
        
        if (( x <= Plateau.getInstance().RIGHT && x >= Plateau.getInstance().LEFT) && ( y <= Plateau.getInstance().UPPER && y >= Plateau.getInstance().LOWER)) {
            if (Plateau.getInstance().PUNTOS_CARDINALES.indexOf(String.valueOf(orientacion)) != -1) {
            
                this.x = x;
                this.y = y;                       
                this.orientacion = orientacion;
                this.habil = true;
            } else {
                this.habil = false;
                System.out.println("La orientacion proporcionada para el Rover " + this.n + " no es valida.");
            }
        } else {
            this.habil = false;
            System.out.println("Las coordenadas de la posicion del Rover " + this.n + " se encuentran fuera del Plateau.");
        }
                
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientacion() {
        return orientacion;
    }

    public boolean isHabil() {
        return habil;
    }

    public void setHabil(boolean habil) {
        this.habil = habil;
    }
    
    

    public void setOrientacion(char ladoGiro) {

        int ind = Plateau.getInstance().PUNTOS_CARDINALES.indexOf(this.orientacion);
        if (ladoGiro == 'L') {

            ind--;
            if (ind < 0) {
                ind = Plateau.getInstance().PUNTOS_CARDINALES.length() - 1;
            }

        } else if (ladoGiro == 'R') {

            ind++;
            if (ind == Plateau.getInstance().PUNTOS_CARDINALES.length()) {
                ind = 0;
            }

        }
        this.orientacion = Plateau.getInstance().PUNTOS_CARDINALES.charAt(ind);
    }

    public void mover(char m) {
        switch (this.orientacion) {
            case 'N': {
                if (this.y + 1 <= Plateau.getInstance().UPPER) {
                    this.y++;
                }
            }
            break;
            case 'E': {
                if (this.x + 1 <= Plateau.getInstance().RIGHT) {
                    this.x++;
                }
            }
            break;
            case 'S': {
                if (this.y - 1 >= Plateau.getInstance().LOWER) {
                    this.y--;
                }
            }
            break;
            case 'O': {
                if (this.x - 1 >= Plateau.getInstance().LEFT) {
                    this.x--;
                }
            }
            break;
        }
    }

    public void obedecerInstruccion(String instrucciones) {

        for (int i = 0; i < instrucciones.length(); i++) {
            char instruccion = instrucciones.charAt(i);
            if (instruccion == 'L' || instruccion == 'R') {
                this.setOrientacion(instruccion);
            } else if (instruccion == 'M') {
                this.mover(instruccion);
            } else {
                System.out.println("No se reconoce una instruccion dada para el Rover " + this.n);
            }
        }
    }

    public void mostrarPosicion() {
        System.out.println("Posicion del Rover "+ this.n + ": " + this.x + " " + this.y + " " + this.orientacion);
    }
}