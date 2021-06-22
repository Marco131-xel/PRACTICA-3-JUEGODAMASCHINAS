package src.usuario;

import src.juego.Datos;

public class TablaUsuarios {

    private Usuario[] usuarios = new Usuario[10];
    private int nuevoUsuario;

    public TablaUsuarios(){
    }

    // Metodo para ingresar jugadores
    public void ingresarJugador(){

        String nombre;

        nombre = Datos.obtenerLinea("\nIngrese el nombre del jugador:");

        asignarJugador(nombre);

    }

    // Metodo adicional para ingresar Jugador
    public void asignarJugador(String nombre){
        if (nuevoUsuario < 10){
            this.usuarios[nuevoUsuario++] = new Usuario(nombre);
        }else {
            Datos.mostrarMensaje(" Limite de Jugadores Alcanzado \n");
        }
    }

    // Metodo para mostrar informacion de Jugador
    public void informacionUsuario(){
        for (int i = 0; i < nuevoUsuario; i++) {
            System.out.print("ID ("+i+") "+usuarios[i].getInformacion());
        }
        System.out.println();
    }

    // Metodo para mostrar informacion por jugador
    public String informacionEspecificaUser(int idUser){
        return usuarios[idUser].getNombre();
    }

}
