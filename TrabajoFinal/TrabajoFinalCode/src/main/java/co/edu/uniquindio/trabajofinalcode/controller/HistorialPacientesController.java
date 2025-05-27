package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.CitaMedica;
import co.edu.uniquindio.trabajofinalcode.model.Hospital;

import java.util.LinkedList;

public class HistorialPacientesController {
    Hospital hospital;
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public LinkedList<CitaMedica> obtenerCitasPaciente(String idPaciente){
        try{
            return hospital.obtenerCitasPaciente(idPaciente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

