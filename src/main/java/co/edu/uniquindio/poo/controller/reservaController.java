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

    public ObservableList<Reserva> getReservas() {
        return reservas;
    }

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
            double costo = calcularCosto(vehiculo) * dias; // Calcula el costo total basado en los días
            Reserva nuevaReserva = new Reserva(dias, "Reserva " + reservas.size(), cliente, vehiculo);
            nuevaReserva.setCosto(costo); // Asigna el costo calculado a la reserva
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

    public boolean actualizarReserva(Reserva reserva, int dias, Cliente cliente, Vehiculo vehiculo) {
        // Verifica que la reserva no sea nula
        if (reserva == null) {
            return false; // No se puede actualizar si la reserva es nula
        }
    
        // Actualiza los campos de la reserva
        reserva.setDiasReserva(dias);
        reserva.setCliente(cliente);
        reserva.setVehiculo(vehiculo);
    
        // Aquí podrías agregar lógica adicional para persistir los cambios en la base de datos
        // Por ejemplo, si usas una lista, asegúrate de que la lista esté actualizada.
    
        return true; // Retorna verdadero si la actualización fue exitosa
    }

    public double calcularCosto(Vehiculo vehiculo) {
        if (vehiculo instanceof ICosto) {
            return ((ICosto) vehiculo).calcularCosto();
        }
        return 0; // o lanzar una excepción, si lo prefieres
    }
 
}

