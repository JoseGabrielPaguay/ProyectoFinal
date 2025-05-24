package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Hospital;

import java.time.LocalDate;

public class RegistrarseController {

    Hospital hospital;

    public void setHospital(Hospital hospital){
        this.hospital = hospital;
    }

    //Método para registrar un admnistrador
    public void registrarAdmin(String nombre, String apellido, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String contrasena){
        try{
            hospital.registrarAdmin(nombre, apellido, cedula, correo, telefono, fechaNacimiento, contrasena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
