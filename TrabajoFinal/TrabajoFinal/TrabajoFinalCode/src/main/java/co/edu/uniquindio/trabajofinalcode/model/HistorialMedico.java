package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class HistorialMedico {
    private int idHistorial;
    private Paciente paciente;
    private LinkedList<String> diagnostico;
    private LinkedList<String> tratamientos;
    private LinkedList<String> alergias;;
    private LocalDateTime ultimaActualizacion;

    public HistorialMedico(int idHistorial, Paciente paciente, LinkedList<String> diagnostico, LinkedList<String> tratamientos,
                           LinkedList<String> alergias, LocalDateTime ultimaActualizacion) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.tratamientos = tratamientos;
        this.alergias = alergias;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LinkedList<String> getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(LinkedList<String> diagnostico) {
        this.diagnostico = diagnostico;
    }

    public LinkedList<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(LinkedList<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public LinkedList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(LinkedList<String> alergias) {
        this.alergias = alergias;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
}
