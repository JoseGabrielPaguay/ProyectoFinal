package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;

public class InicioSesionController {

    Hospital hospital;

    public void setHospital(Hospital hospital){
        this.hospital = hospital;
    }

    public boolean iniciarSesion(String correo, String contrasena){
        try{
            return hospital.iniciarSesion(correo, contrasena);
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
