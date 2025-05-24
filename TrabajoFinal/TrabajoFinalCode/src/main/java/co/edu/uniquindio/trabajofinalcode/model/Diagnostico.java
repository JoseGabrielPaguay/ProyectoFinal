package co.edu.uniquindio.trabajofinalcode.model;

public class Diagnostico {

    String cedulaPaciente;
    String nombrePaciente;
    String tratamiento;
    String descripcion;


    public Diagnostico(String cedulaPaciente, String nombrePaciente, String tratamiento, String descripcion) {
        this.cedulaPaciente = cedulaPaciente;
        this.nombrePaciente = nombrePaciente;
        this.tratamiento = tratamiento;
        this.descripcion = descripcion;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
