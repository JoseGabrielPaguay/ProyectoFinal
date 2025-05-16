package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;

public class Consulta {
    private String idConsulta;
    private LocalDate fecha;
    private String sala;

    public Consulta(String idConsulta, LocalDate fecha, String sala) {
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        this.sala = sala;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
