package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo implements ICosto {
    private double capacidadCarga;

    public Camioneta(String matricula, String marca, String modelo, int anoFabricacion, double capacidadCarga, Reserva reserva) {
        super(matricula, marca, modelo, anoFabricacion, reserva);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    //Metodo de costo de la camioneta
    @Override
    public double calcularCosto() {
        double tarifaBase= 20000;
        double porcentajeExtraPorTonelada= 0.05;
        double adicional=tarifaBase*capacidadCarga*porcentajeExtraPorTonelada;
        double total=tarifaBase+adicional;
        return total;   
    }

   @Override
    public String toString(){
        return "Camioneta: "+super.toString()+" ,capacidad carga "+ capacidadCarga;
    }
 
    
    

    
    
}