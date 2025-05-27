package co.edu.uniquindio.trabajofinalcode.model;

import java.io.Serializable;

public class Diagnostico implements Serializable {

    private Medico medico;
    private Paciente paciente;
    private String descripcion;


    public Diagnostico(Medico medico, Paciente paciente, String descripcion) {
        this.medico = medico;
        this.paciente = paciente;
        this.descripcion = descripcion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
