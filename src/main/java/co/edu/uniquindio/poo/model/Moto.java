package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo implements ICosto{
    private TipoCaja tipoCaja;

    public Moto(String matricula, String marca, String modelo, int anoFabricacion, double capacidadCarga,Reserva reserva, TipoCaja tipoCaja) {
        super(matricula, marca, modelo, anoFabricacion,reserva);
        this.tipoCaja=tipoCaja;
    }
    
    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(TipoCaja tipoCaja) {
        this.tipoCaja = tipoCaja;
    }
    
    //Metodo de costo de la moto
    @Override
    public double calcularCosto() {
        double tarifaBase= 20000;
        double tarifaAdicional= 5000;
        double tarifaFinal=0;
        if (tipoCaja == TipoCaja.AUTOMATICO) {
            tarifaFinal= tarifaBase+tarifaAdicional;
        }else{
            tarifaFinal= tarifaBase;
        }
        return tarifaFinal;
    }
    
    @Override
    public String toString(){
        return "Moto: "+super.toString()+ " ,tipo caja "+tipoCaja;  
    }
}
    


