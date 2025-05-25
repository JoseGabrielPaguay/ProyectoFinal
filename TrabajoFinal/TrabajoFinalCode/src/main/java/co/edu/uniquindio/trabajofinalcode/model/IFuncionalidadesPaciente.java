package co.edu.uniquindio.trabajofinalcode.model;

public interface IFuncionalidadesPaciente {
    boolean actualizarCita();
    boolean solicitarCita();
    boolean eliminarCita();
    boolean consultarHistorialMedico();
    void eliminarCitaMedica();
    void registrarCitaMedica();
    boolean notificacionCambioCita();
}
