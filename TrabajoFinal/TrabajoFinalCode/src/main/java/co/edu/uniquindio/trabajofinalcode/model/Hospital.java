package co.edu.uniquindio.trabajofinalcode.model;

import java.util.LinkedList;

public class Hospital {
    public String nombre;
    public Adminstrador adminstrador;
    public LinkedList<Paciente> listPacientes;
    public LinkedList<Medico> listMedicos;
    public LinkedList<CitaMedica> listCitasMedicas;
    public LinkedList<HistorialMedico> listHistorialesMedicos;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.listPacientes = new LinkedList<>();
        this.listMedicos = new LinkedList<>();
        this.listCitasMedicas = new LinkedList<>();
        this.listHistorialesMedicos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Paciente> getListPacientes() {
        return listPacientes;
    }

    public void setListPacientes(LinkedList<Paciente> listPacientes) {
        this.listPacientes = listPacientes;
    }

    public LinkedList<Medico> getListMedicos() {
        return listMedicos;
    }

    public void setListMedicos(LinkedList<Medico> listMedicos) {
        this.listMedicos = listMedicos;
    }

    public LinkedList<CitaMedica> getListCitasMedicas() {
        return listCitasMedicas;
    }

    public void setListCitasMedicas(LinkedList<CitaMedica> listCitasMedicas) {
        this.listCitasMedicas = listCitasMedicas;
    }

    public LinkedList<HistorialMedico> getListHistorialesMedicos() {
        return listHistorialesMedicos;
    }

    public void setListHistorialesMedicos(LinkedList<HistorialMedico> listHistorialesMedicos) {
        this.listHistorialesMedicos = listHistorialesMedicos;
    }


}
