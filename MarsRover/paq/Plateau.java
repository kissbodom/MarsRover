package paq;

public class Plateau {

    public int UPPER;
    public int RIGHT;
    public final String PUNTOS_CARDINALES = "NESO";
    public final int LOWER = 0;
    public final int LEFT = 0;

    private Plateau(int upper, int right) {
        this.UPPER = upper;
        this.RIGHT = right;
    }
    
    
    private static Plateau single = null;
    public static Plateau getInstance(int upper, int right){
        if (single == null) {
            single = new Plateau(upper, right);
        }
        return single;
    }
    
    public static Plateau getInstance(){
        return single;
    }
}