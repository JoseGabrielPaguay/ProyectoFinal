package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Paciente extends Usuario{
    private GrupoSanguineo tipoSangre;
    private LinkedList<String> alergias;
    private String eps;

    public Paciente(String nombre, String apellido, String id, String correo, String contacto,
                    LocalDate fechaNacimiento, GrupoSanguineo tipoSangre, LinkedList<String> alergias, String eps) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento);
        this.tipoSangre = tipoSangre;
        alergias = new LinkedList<>();
        this.eps = eps;
    }

    public GrupoSanguineo getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(GrupoSanguineo tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public LinkedList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(LinkedList<String> alergias) {
        this.alergias = alergias;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}
