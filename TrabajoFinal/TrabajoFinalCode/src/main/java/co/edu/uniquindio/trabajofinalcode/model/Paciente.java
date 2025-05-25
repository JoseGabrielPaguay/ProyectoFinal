package co.edu.uniquindio.trabajofinalcode.model;

import co.edu.uniquindio.trabajofinalcode.util.Constantes;
import co.edu.uniquindio.trabajofinalcode.util.Persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class Paciente extends Usuario implements Serializable {
    private GrupoSanguineo tipoSangre;
    private LinkedList<Diagnostico> diagnosticos;
    private String eps;

    public Paciente(String nombre, String apellido, String cedula, String correo, String contacto,
                    LocalDate fechaNacimiento, GrupoSanguineo tipoSangre, String eps ,String contrasena) {
        super(nombre, apellido, cedula, correo, contacto, fechaNacimiento, contrasena);
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

    /**
     * Método para guardar los datos de los diagnosticos
     * @param diagnosticos
     */
    public void guardarDatosDiagnosticos(LinkedList<Diagnostico> diagnosticos) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_DIAGNOSTICOS, diagnosticos);
        } catch (IOException e) {
            System.err.println("Error guardando diagnosticos: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de las citas
     * @return citas
     */
    public LinkedList<Diagnostico> leerDatosDiagnosticos() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_DIAGNOSTICOS);
            if (datos != null) {
                return (LinkedList<Diagnostico>) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando diagnosticos: " + e.getMessage());
        }
        return new LinkedList<>();
    }

}
