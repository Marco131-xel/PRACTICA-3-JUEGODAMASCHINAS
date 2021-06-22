package src.tablero;

public class Casilla {
//---

    private boolean color;
    private Ficha ficha;
    private String casilla = "█";
    private String casillaColor = "█";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[46m";
    public static final String ANSI_BLUE = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[32m";

    public Casilla(boolean color){
        this.color = color;
        this.ficha = null;
    }

    //Metodo para colorear casillas
    public String pintarCasillas(){
        String casAux = "";
        if (ficha != null) {
            if (color) { 
                casAux =  ANSI_WHITE+casillaColor+casillaColor+ ANSI_RESET + ficha.obtenerFicha() + ANSI_WHITE+ casillaColor+casillaColor+ ANSI_RESET ;
            } else { 
                casAux =  ANSI_BLUE +casilla +casilla+ANSI_RESET + ficha.obtenerFicha() + ANSI_BLUE+ casilla+casilla+ANSI_RESET ;
            }
        }else {
            if (color) { 
                casAux =  ANSI_WHITE+ casillaColor + casillaColor + casillaColor + casillaColor +  casillaColor +ANSI_RESET ;
            } else { 
                casAux =  ANSI_BLUE + casilla + casilla + casilla + casilla + casilla +ANSI_RESET ;
            }
        }
    return casAux;
    }

        //Metodo para fijar ficha
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

     public Ficha getFicha() {
        Ficha aux = this.ficha;
        this.ficha = null;
        return aux;
    }

    public Ficha actual(){
        return this.ficha;
    }

    public boolean isOcupaFicha(){
        return (this.ficha!=null);
    }

    // Metodo para ficha reina
    public String fichaReina(){
        Ficha aux = this.ficha;
        return ANSI_YELLOW+aux+ANSI_RESET;
    }
}