package co.edu.uniquindio.trabajofinalcode.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Administrador extends Usuario implements Serializable {

    public Administrador(String nombre, String apellido, String id, String correo, String contacto, LocalDate fechaNacimiento, String contrasena) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento, contrasena);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}
