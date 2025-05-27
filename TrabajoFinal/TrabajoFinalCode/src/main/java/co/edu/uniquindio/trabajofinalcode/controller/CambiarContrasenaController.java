package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Hospital;

public class CambiarContrasenaController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void cambiarContrasena(String codigo, String nuevaContrasena, String correo){
        try{
            hospital.cambiarContrasena(codigo, nuevaContrasena, correo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
