package src.juego;

import java.util.Scanner;

public class Datos {

    static Scanner sc = new Scanner(System.in);

    // Metodo para mostrar mensaje
    public static void mostrarMensaje(String mensaje){
        System.out.print(mensaje+" ");
    }

    // Metodo para leer numeros
    public static int opcionMensaje(String mensaje){
        mostrarMensaje(mensaje);
        return sc.nextInt();
    }

     //Metodo para leer texto
    public static String obtenerLinea(String mensaje){
        mostrarMensaje(mensaje);
        sc.nextLine();
        return sc.nextLine();
    }

}