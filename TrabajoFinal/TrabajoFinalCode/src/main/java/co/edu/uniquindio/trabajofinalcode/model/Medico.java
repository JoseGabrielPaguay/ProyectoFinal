package co.edu.uniquindio.trabajofinalcode.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Medico extends Usuario implements Serializable {
    private EspecialidadMedica especialidad;
    private String numeroLicencia;
    private String horario;

    public Medico(String nombre, String apellido, String id, String correo,
                  String contacto, LocalDate fechaNacimiento, EspecialidadMedica especialidad, String numeroLicencia, String contraseña) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento,contraseña);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
