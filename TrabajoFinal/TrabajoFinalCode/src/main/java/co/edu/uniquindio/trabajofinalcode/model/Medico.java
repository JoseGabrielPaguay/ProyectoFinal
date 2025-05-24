package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;

public class Medico extends Usuario {
    private EspecialidadMedica especialidad;
    private String numeroLicencia;

    public Medico(String nombre, String apellido, String id, String correo,
                  String contacto, LocalDate fechaNacimiento, EspecialidadMedica especialidad, String numeroLicencia, String contraseña) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento,contraseña);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadMedica especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

}
