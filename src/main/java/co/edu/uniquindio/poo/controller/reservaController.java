package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.ICosto;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;



public class reservaController {

    private Empresa empresa;
    private ObservableList<Reserva> reservas;

    public reservaController() {
        this.empresa = new Empresa("Mi Empresa");
        this.reservas = FXCollections.observableArrayList();
    }

    @FXML
    private ComboBox<Cliente> txtListaClientes;
    @FXML
    private ComboBox<Vehiculo> txtListaVehiculo;

    @FXML
    public void initialize() {
        // Cargar datos en ComboBox
        cargarClientes();
        cargarVehiculos();
    }

    private void cargarClientes() {
        // Cargar clientes desde el modelo (puedes tener una lista estática o de otro lugar)
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        // Suponiendo que tienes algunos clientes
        clientes.add(new Cliente("123456", "Juan Pérez", null));
        clientes.add(new Cliente("789101", "Ana Gómez", null));
        txtListaClientes.setItems(clientes);
    }

    private void cargarVehiculos() {
        // Cargar vehículos desde el modelo (puedes tener una lista estática o de otro lugar)
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList();
        // Suponiendo que tienes algunos vehículos
        vehiculos.add(new Moto("ABC123", "Yamaha", "MT-07", 2020, 0, null, TipoCaja.AUTOMATICO));
        vehiculos.add(new Camioneta("XYZ789", "Toyota", "Hilux", 2021, 1000, null));
        txtListaVehiculo.setItems(vehiculos);
    }


    // Cargar clientes y vehículos (asumiendo que se cargan de forma estática)
    public void cargarDatos(ObservableList<Cliente> clientes, ObservableList<Vehiculo> vehiculos) {
        // Aquí puedes cargar los datos desde una base de datos, un archivo o dejarlos quemados.
        // Ejemplo para cargar a la vista
        for (Cliente cliente : clientes) {
            empresa.agregarCliente(cliente);
        }
        for (Vehiculo vehiculo : vehiculos) {
            empresa.agregarVehiculo(vehiculo);
        }
    }

    public boolean crearReserva(int dias, Cliente cliente, Vehiculo vehiculo) {
        if (cliente != null && vehiculo != null) {
            Reserva nuevaReserva = new Reserva(dias, "Reserva " + reservas.size(), cliente, vehiculo);
            if (empresa.agregarReserva(nuevaReserva)) {
                reservas.add(nuevaReserva);
                return true; // Reserva creada exitosamente
            }
        }
        return false; // Falló la creación de la reserva
    }

    public boolean eliminarReserva(Reserva reserva) {
        if (reserva != null) {
            if (empresa.eliminarReserva(reserva.getNombre())) {
                reservas.remove(reserva);
                return true; // Reserva eliminada exitosamente
            }
        }
        return false; // Falló la eliminación de la reserva
    }

    public boolean actualizarReserva(Reserva reservaActual, int dias, Cliente cliente, Vehiculo vehiculo) {
        if (reservaActual != null) {
            reservaActual.setDias(dias);
            reservaActual.setCliente(cliente);
            reservaActual.setVehiculo(vehiculo);
            return true; // Reserva actualizada exitosamente
        }
        return false; // Falló la actualización de la reserva
    }

    public ObservableList<Reserva> getReservas() {
        return reservas; // Retorna la lista de reservas para ser mostrada en la vista
    }

    public double calcularCosto(Vehiculo vehiculo) {
        if (vehiculo instanceof ICosto) {
            return ((ICosto) vehiculo).calcularCosto();
        }
        return 0; // o lanzar una excepción, si lo prefieres
    }
 
}

