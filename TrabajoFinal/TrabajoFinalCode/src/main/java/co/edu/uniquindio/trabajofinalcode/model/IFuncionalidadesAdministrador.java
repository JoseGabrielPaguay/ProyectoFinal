package co.edu.uniquindio.trabajofinalcode.model;

public interface IFuncionalidadesAdministrador {
    boolean crearMedico();
    boolean actualizarMedico();
    boolean eliminarMedico();
    boolean crearPaciente();
    boolean actualizarPaciente();
    boolean eliminarPaciente();
    boolean verificarDisponibilidadMedico();
    boolean verificarDisponibilidadPaciente();
    boolean generarReporteCita();
}
