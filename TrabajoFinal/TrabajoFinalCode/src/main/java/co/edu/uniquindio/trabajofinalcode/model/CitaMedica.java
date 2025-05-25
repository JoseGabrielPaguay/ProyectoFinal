package co.edu.uniquindio.trabajofinalcode.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica implements Serializable {
    private String idCita;
    private LocalDate fecha;
    private String hora;
    private String motivo;
    private String notasPrevias;
    private Sala sala;
    private Paciente paciente;
    private Medico medico;

    public CitaMedica(String id, LocalDate fecha, String hora, String motivo, String notasPrevias, Sala sala, Paciente paciente, Medico medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.notasPrevias = notasPrevias;
        this.idCita = id;
        this.sala = sala;
        this.paciente=paciente;
        this.medico=medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String  idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNotasPrevias() {
        return notasPrevias;
    }

    public void setNotasPrevias(String notasPrevias) {
        this.notasPrevias = notasPrevias;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
