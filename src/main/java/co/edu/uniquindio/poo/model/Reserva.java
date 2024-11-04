package co.edu.uniquindio.poo.model;

public class Reserva {
    private String nombre;
    private int diasReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double costo;

    public Reserva(int diasReserva, String nombre, Cliente cliente,Vehiculo vehiculo) {
        this.diasReserva = diasReserva;
        this.nombre=nombre;
        this.cliente=cliente;
        this.vehiculo=vehiculo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
         this.costo=costo;
    }

    public int getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(int diasReserva) {
        this.diasReserva = diasReserva;
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
        return "\nReserva: nombre: " + nombre + ", dias: " + diasReserva +"vehiculo= "+vehiculo.getMatricula()+" está asociada con "+cliente.getNombre()+"\n";
    }
    

    

    
    
}

