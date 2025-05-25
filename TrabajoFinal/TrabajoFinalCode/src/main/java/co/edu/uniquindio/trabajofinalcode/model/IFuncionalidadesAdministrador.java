package co.edu.uniquindio.trabajofinalcode.model;

import java.util.LinkedList;

public interface IFuncionalidadesAdministrador {
    void registrarMedico();
    void actualizarMedico();
    void eliminarMedico();
    void registrarPaciente();
    void actualizarPaciente();
    void eliminarPaciente();
    LinkedList<CitaMedica> generarReporteCitas();
    void eliminarCitaMedica();

}
