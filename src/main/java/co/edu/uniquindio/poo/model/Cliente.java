package co.edu.uniquindio.poo.model;
import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String telefono;
    private LinkedList<Reserva> reservas;

    public Cliente(String nombre, String telefono, Reserva reserva) {
        this.nombre = nombre;
        this.telefono=telefono;
        reservas= new LinkedList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }


    @Override
    public String toString() {
        return  nombre + " ,telefono " + telefono;
    }

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }


    
    
}