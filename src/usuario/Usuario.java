package src.usuario;

public class Usuario {

    private String nombre;
    private int cantidadGanadas;
    private int cantidadPerdidas;

    public Usuario(String nombre){
        this.nombre = nombre;
        this.cantidadGanadas = 0; 
        this.cantidadPerdidas = 0;
    }

    //Inicio metodos setter y getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidadGanadas() {
        return cantidadGanadas;
    }

    public void setCantidadGanadas(int cantidadGanadas) {
        this.cantidadGanadas = cantidadGanadas;
    }

    public int getCantidadPerdidas() {
        return cantidadPerdidas;
    }

    public void setCantidadPerdidas(int cantidadPerdidas) {
        this.cantidadPerdidas = cantidadPerdidas;
    }

    public String getInformacion(){
        return "Nombre: "+nombre+
                "\t\t||Partidas Perdidas: "+cantidadPerdidas+"\t//Partidas Ganadas: "+cantidadGanadas+"\n";
    }
    //fin setter y getters

}