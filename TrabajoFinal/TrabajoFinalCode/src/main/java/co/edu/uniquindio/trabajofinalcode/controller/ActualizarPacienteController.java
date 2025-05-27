package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.*;

public class ActualizarPacienteController {
    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void actualizarPaciente(String cedula, String nombre, String apellido, String eps, String telefono, String correo){
        try{
            hospital.actualizarPaciente(cedula, nombre, apellido, eps, telefono, correo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
