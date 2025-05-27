package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;

public class EnviarCodigoContrasenaController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void mandarCodigoCorreo(String correo){
        try{
            hospital.enviarCodigoCorreo(correo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario obtenerUsuario(String correo){
        try{
            return hospital.obtenerUsuarioCorreo(correo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
