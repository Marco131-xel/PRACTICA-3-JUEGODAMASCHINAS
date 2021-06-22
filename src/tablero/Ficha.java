package src.tablero;

public class Ficha {
//---
    // Condición true = Rojo  && False = verde
    private boolean colorRojo; 
    private String fichaRoja = "▄";
    private String fichaNegra = "▄";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[42m";
   

    public Ficha(boolean colorRojo){
        this.colorRojo = colorRojo;
    }

    // Metodo para seleccionar ficha
    public String obtenerFicha(){
        return (colorRojo)? ANSI_RED+fichaRoja+ANSI_RESET : ANSI_BLACK+fichaNegra+ANSI_RESET;
    }

    public String getFichaRoja() {
        return fichaRoja;
    }

    public String getFichaNegra() {
        return fichaNegra;
    }

}