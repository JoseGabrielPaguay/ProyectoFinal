package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;
import co.edu.uniquindio.trabajofinalcode.util.EnvioEmail;

public class RecuperarContrasenaController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void enviarCorreo(String correo, String asunto,  String mensaje){
        EnvioEmail.enviarNotificacion(correo, asunto, mensaje);
    }

    public void setCodigoUsuario(String cedula, String codigo){
        try{
            hospital.guardarCodigoActivacion(codigo, cedula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario obtenerUsuarioCorreo(String correo){
        try{
            return hospital.obtenerUsuarioCorreo(correo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
