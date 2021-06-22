package src.tablero;

import src.juego.Datos;
import src.tablero.*;

public class Tablero {
    private int contadorNegras = 12;
    private int contadorRojas = 12;
    private Casilla[][] casillas;

     public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[32m";

    //Constructor del tablero
    public Tablero(){
        this.casillas = new Casilla[8][8]; 
    }


    //Método para Crear Tablero
    public void crearTablero(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (1-(i+j) % 2 == 0){
                    casillas[i][j] = new Casilla(true);
                }else {
                    casillas[i][j] = new Casilla(false);
                }
            }
        }
    }

    //Método para agregar Fichas
    public void agregarFichas(){
        //fichas rojas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (1-(i+j) % 2 == 0){
                    casillas[i][j].setFicha(new Ficha(true));
                }
            }
        }

        //fichas verdes
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (1-(i+j) % 2 == 0){
                    casillas[i][j].setFicha(new Ficha(false));
                }
            }
        }
    }



    //Metodo para mostrar el tablero
    public void mostrarTablero(){
        System.out.println("   0     1    2    3    4    5    6    7   ");
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k<3; k++ ) {
                System.out.print(i+" ");
                for (int j = 0; j < 8; j++) {
                System.out.print(casillas[i][j].pintarCasillas()+"");
            }
            System.out.println();
            }
        }
        System.out.println("   0     1    2    3    4    5    6    7   ");
        System.out.println("|\n<Columna>\n");
    }

    // Metodo para el movimiento de fichas
    private void moverFichas(int posX, int posY, int indice){
        int posXFin, posYFin;

        if (casillas[posX][posY].isOcupaFicha()){ //Si la casilla tiene una ficha
            posXFin = Datos.opcionMensaje(" Ingrese las coordenadas del movimiento (Fila): ");
            posYFin = Datos.opcionMensaje(" Ingrese las coordenadas del movimiento (Columna): ");
            if (movimientosPermitidos(posXFin, posYFin)){ //Verifica que los movimientos sean válidos
                if (casillas[posXFin][posYFin].isOcupaFicha()){ //Verifica si una casilla contienen una ficha
                    if (comerFicha(posX, posY, posXFin, posYFin)){ //Verifica si es una ficha contraria (enemiga)
                        casillas[posXFin][posYFin].setFicha(casillas[posX][posY].getFicha());
                        if (indice == 1) {
                            contadorNegras--;
                            Datos.mostrarMensaje("\n Ficha verde comida \n");
                        } else if (indice == 2) {
                            contadorRojas--;
                            Datos.mostrarMensaje("\n  Ficha roja comida  \n");
                        }
                    }else {
                        Datos.mostrarMensaje("\n Fichas Iguales \n");
                    }
                }else {
                    casillas[posXFin][posYFin].setFicha(casillas[posX][posY].getFicha());
                    Datos.mostrarMensaje("\n Ficha Movida \n");
                }
            } else {
                Datos.mostrarMensaje("\n Movimiento Inadecuado \n");
            }
        }else {
            Datos.mostrarMensaje("\n No existe ficha en posición seleccionada \n");
        }
    }

    // Metodo del tablero dinamico
    public void initTablero(){
        System.out.print("\n\n");
        int posX, posY;

        crearTablero();
        agregarFichas();
        mostrarTablero();

        do {
             //Jugador Fichas rojas
            Datos.mostrarMensaje("\n Jugador 1: (Rojas)\n");
            posX = Datos.opcionMensaje(" Coordenadas actuales (Filas): ");
            posY = Datos.opcionMensaje(" Coordenadas actuales (Columna): ");
            moverFichas(posX, posY, 1);

            mostrarTablero();
             //Jugador Fichas verdes
            Datos.mostrarMensaje("\n Jugador 2: (Verdes)\n");
            posX = Datos.opcionMensaje(" Coordenadas actuales (Filas): ");
            posY = Datos.opcionMensaje(" Coordenadas actuales (Columna): ");
            moverFichas(posX, posY, 2);

            mostrarTablero();

        }while (contadores()!= 1);

    }

    // Metodo para movimientos permitidos
    private boolean movimientosPermitidos(int posXFin, int posYFin){
        boolean permitido = false;

        if (1-(posXFin + posYFin) % 2 == 0){
            permitido = true;
        }
        return permitido;
    }

    // Metodo que verifica comer ficha
    private boolean comerFicha(int posX, int posY, int posXFin, int posYFin){
        boolean comer = true;

        if (casillas[posXFin][posYFin].equals(casillas[posX][posY])){
            comer = false;
        }
        return comer;   
    }

    // Muestra resultado final del tablero
    public void muestraTablero(){
        crearTablero();
        agregarFichas();
        mostrarTablero();
    }

    public int contadores(){
        return (contadorRojas == 0 || contadorNegras == 0) ? 1 : 0;
    }

}