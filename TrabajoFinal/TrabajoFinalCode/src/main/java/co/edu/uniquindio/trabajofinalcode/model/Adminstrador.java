package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;

public class Adminstrador extends Usuario{

    public Adminstrador(String nombre, String apellido, String id, String correo, String contacto, LocalDate fechaNacimiento, String contrasena) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento, contrasena);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}
