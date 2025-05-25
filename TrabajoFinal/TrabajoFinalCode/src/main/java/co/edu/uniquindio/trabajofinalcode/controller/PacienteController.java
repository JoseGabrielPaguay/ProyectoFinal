package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.CitaMedica;
import co.edu.uniquindio.trabajofinalcode.model.Hospital;

import java.time.LocalDate;
import java.util.LinkedList;

public class PacienteController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void registrarCita(LocalDate fecha, String hora, String motivo, String notasPrevias){
        try{
            hospital.registrarCitaMedica(fecha, hora, motivo, notasPrevias);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarCita(String idCita){
        try{
            hospital.eliminarCitaMedica(idCita);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<CitaMedica> obtenerListaCitasPacinete(String idPaciente){
        try{
            return hospital.obtenerHistorialMedicoPaciente(idPaciente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<String> getHorarios(){

    }


}
