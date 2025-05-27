package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;

import java.util.LinkedList;

public class MedicoController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public LinkedList<Paciente> cargarListaPacientes(String idMedico){
        try{
            return hospital.obtenerListaPacientesMedico(idMedico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void registrarDiagnostico(String cedulaPaciente, String descripcion){
        try{
            Paciente paciente = hospital.buscarPacienteCedula(cedulaPaciente);
            hospital.registrarDiagnostico(cedulaPaciente, paciente.getNombre(), descripcion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
