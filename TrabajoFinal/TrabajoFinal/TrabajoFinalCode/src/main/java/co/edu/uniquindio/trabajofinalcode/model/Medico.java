package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;

public class Medico extends Usuario{
    private TipoEspecialidad especialidad;
    private String numeroLicencia;

    public Medico(String nombre, String apellido, String id, String correo,
                  String contacto, LocalDate fechaNacimiento, TipoEspecialidad especialidad, String numeroLicencia) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
    }

    public TipoEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TipoEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
}
