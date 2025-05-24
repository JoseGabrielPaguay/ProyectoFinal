package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica {
    private int idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;;
    private String notasPrevias;
    private Sala sala;

    public CitaMedica(LocalDate fecha, LocalTime hora, String motivo, String notasPrevias) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.notasPrevias = notasPrevias;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
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
