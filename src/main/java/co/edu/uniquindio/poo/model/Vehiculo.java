package co.edu.uniquindio.poo.model;

public class Vehiculo {
    public String matricula;
    public String marca;
    public String modelo;
    public int anoFabricacion;
    public Reserva reserva;


    public Vehiculo(String matricula, String marca, String modelo, int anoFabricacion, Reserva reserva) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.reserva=reserva;
    }


    public String getMatricula() {
        return matricula;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public int getAnoFabricacion() {
        return anoFabricacion;
    }


    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }
    
    public Reserva getReserva() {
        return reserva;
    }


    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


    @Override
    public String toString() {
        return " matricula " + matricula + " ,marca " + marca + " ,modelo " + modelo + " ,año Fabricacion "
                + anoFabricacion;
    }


   
    
}

