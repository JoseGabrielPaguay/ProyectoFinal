package co.edu.uniquindio.trabajofinalcode.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Medico extends Usuario implements Serializable {
    private EspecialidadMedica especialidad;
    private String numeroLicencia;
    private Horario horario;

    public Medico(String nombre, String apellido, String id, String correo,
                  String contacto, LocalDate fechaNacimiento, EspecialidadMedica especialidad, String numeroLicencia, String contrasena) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento,contrasena);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
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
