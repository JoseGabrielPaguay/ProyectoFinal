package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.util.EnvioEmail;

public class RecuperarContrasenaController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void enviarCorreo(String correo, String mensaje){
        EnvioEmail.enviarNotificacion(correo, "Codigo", mensaje);
    }
}
