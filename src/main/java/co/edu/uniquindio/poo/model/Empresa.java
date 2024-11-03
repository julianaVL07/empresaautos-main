package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private LinkedList <Vehiculo> vehiculos;
    private LinkedList<Cliente> clientes;
    private LinkedList<Reserva> reservas;

    public Empresa(String nombre) {
        this.nombre = nombre;
        vehiculos = new LinkedList<>();
        clientes = new LinkedList<>();
        reservas= new LinkedList<>();
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getTelefono())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCliente(String telefono) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String telefono, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)) {
                cliente.setTelefono(actualizado.getTelefono());
                cliente.setNombre(actualizado.getNombre());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String telefono) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)) {
                centinela = true;
            }
        }
        return centinela;
    }

    //Métodos vehiculos 
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        boolean centinela = false;
        if (!verificarCliente(vehiculo.getMatricula())) {
            vehiculos.add(vehiculo);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarVehiculo(String matricula) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculos.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarVehiculo(String matricula, Vehiculo actualizado) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculo.setMatricula(actualizado.getMatricula());
                vehiculo.setMarca(actualizado.getMarca());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarVehiculo(String matricula) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                centinela = true;
            }
        }
        return centinela;
    }


    //Crud de reserva
    
     public boolean agregarReserva (Reserva reserva) {
        boolean centinela = false;
        if (!verificarReserva(reserva.getNombre())) {
            reservas.add(reserva);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarReserva(String nombre) {
        boolean centinela = false;
        for (Reserva reserva : reservas) {
            if (reserva.getNombre().equals(nombre)) {
                reservas.remove(reserva);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarReserva(String nombre, Reserva actualizado) {
        boolean centinela = false;
        for (Reserva reserva : reservas) {
            if (reserva.getNombre().equals(nombre)) {
                reserva.setNombre(actualizado.getNombre());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarReserva(String nombre) {
        boolean centinela = false;
        for (Reserva reserva : reservas) {
            if (reserva.getNombre().equals(nombre)) {
                centinela = true;
            }
        }
        return centinela;
    }

    

    @Override
    public String toString() {
        return "\nEmpresa: nombre: " + nombre + ",\nvehiculos: " + vehiculos + ", \nclientes: " + clientes+",\nreservas: "+reservas;
    }

    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}

    

    
    

