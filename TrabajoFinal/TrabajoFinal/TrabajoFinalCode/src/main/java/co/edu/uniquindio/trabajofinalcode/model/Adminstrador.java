package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;

public class Adminstrador extends Usuario{
    private AreaAsignada areaAsignada;

    public Adminstrador(String nombre, String apellido, String id, String correo,
                        String contacto, LocalDate fechaNacimiento, AreaAsignada areaAsignada) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento);
        this.areaAsignada = areaAsignada;
    }

    public AreaAsignada getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(AreaAsignada areaAsignada) {
        this.areaAsignada = areaAsignada;
    }
}
