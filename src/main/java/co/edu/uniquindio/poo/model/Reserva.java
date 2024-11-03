package co.edu.uniquindio.poo.model;

public class Reserva {
    private String nombre;
    private int dias;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Reserva(int dias, String nombre, Cliente cliente,Vehiculo vehiculo) {
        this.dias = dias;
        this.nombre=nombre;
        this.cliente=cliente;
        this.vehiculo=vehiculo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "\nReserva: nombre: " + nombre + ", dias: " + dias +"vehiculo= "+vehiculo.getMatricula()+" está asociada con "+cliente.getNombre()+"\n";
    }
    

    

    
    
}

