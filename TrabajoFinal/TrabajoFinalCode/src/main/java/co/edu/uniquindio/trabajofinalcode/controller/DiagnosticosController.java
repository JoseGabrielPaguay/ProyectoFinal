package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Diagnostico;
import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;

import java.util.LinkedList;

public class DiagnosticosController {

    Hospital hospital;
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public LinkedList<Diagnostico> obtenerDiagnosticoPaciente(Paciente paciente){
        return hospital.obtenerDiagnosticosPaciente(paciente);
    }
}
