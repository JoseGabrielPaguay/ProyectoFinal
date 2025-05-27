package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.*;

import java.time.LocalDate;
import java.util.LinkedList;

public class AdministradorController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void actualizarPacienteAdmin(String cedula, String nombre, String apellido, String eps,
                                   String telefono, String correo, LocalDate fechaNacimiento, GrupoSanguineo tipoSangre){
        try{
            hospital.actualizarPacienteAdmin(cedula, nombre, apellido, eps, telefono, correo, fechaNacimiento, tipoSangre);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarMedico(String nombreNuevo, String apellidoNuevo, String cedula,
                                 String telefonoNuevo, LocalDate fechaNacimientoNueva, EspecialidadMedica especialidadMedicaNueva,
                                 String correoNuevo, String numeroDeLicenciaNuevo){
        try{
            hospital.actualizarMedico(nombreNuevo, apellidoNuevo, cedula, telefonoNuevo, fechaNacimientoNueva, especialidadMedicaNueva, correoNuevo, numeroDeLicenciaNuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarCita(String id){
        try{
            hospital.eliminarCitaMedica(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarMedico(String cedula){
        try{
            hospital.eliminarMedico(cedula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPaciente(String cedula){
        try{
            hospital.eliminarPaciente(cedula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void crearSala(String numero){
        try {
            hospital.registrarSala(numero);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void crearMedico(String nombre, String apellido, String cedula, String telefono, String numeroLicencia,
                            LocalDate fechaNacimiento, EspecialidadMedica especialidadMedica, String correo, String contrasena){
        try{
            hospital.registrarMedico(nombre, apellido, cedula, telefono, numeroLicencia, fechaNacimiento, especialidadMedica, correo, contrasena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void crearPaciente(String nombre, String apellido, String cedula, String telefono, String eps,
                              LocalDate fechaNacimiento, GrupoSanguineo grupoSanguineo, String correo, String contrasena){
        try{
            hospital.registrarPaciente(nombre,apellido,cedula,telefono, eps, fechaNacimiento, grupoSanguineo, correo, contrasena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<CitaMedica> listaCitas(){
        try{
            return hospital.listarCitasHospital();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Medico> listaMedicos(){
        try{
            return hospital.listarMedicosHospital();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Paciente> listaPacientes(){
        try{
            return hospital.listarPacientesHospital();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Sala> listaSala(){
        try{
            return hospital.listarSalasHospital();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<GrupoSanguineo> obtenerGruposSanguineos(){
        return hospital.listarGruposSanguineos();
    }

    public LinkedList<EspecialidadMedica> obtenerEspecialidadesMedicas(){
        return hospital.listarEspecialidadesMedicas();
    }
}
