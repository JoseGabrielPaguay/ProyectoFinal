package co.edu.uniquindio.trabajofinalcode.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Paciente extends Usuario {
    private GrupoSanguineo tipoSangre;
    private LinkedList<Diagnostico> diagnosticos;
    private String eps;

    public Paciente(String nombre, String apellido, String id, String correo, String contacto,
                    LocalDate fechaNacimiento, GrupoSanguineo tipoSangre, String eps ,String contrasena) {
        super(nombre, apellido, id, correo, contacto, fechaNacimiento, contrasena);
        this.tipoSangre = tipoSangre;
        diagnosticos = new LinkedList<>();
        this.eps = eps;
    }

    public GrupoSanguineo getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(GrupoSanguineo tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public LinkedList<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }
    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }


    public void setDiagnosticos(LinkedList<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

}
