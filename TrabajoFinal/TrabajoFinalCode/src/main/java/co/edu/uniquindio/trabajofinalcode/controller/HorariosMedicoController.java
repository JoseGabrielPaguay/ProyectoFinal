package co.edu.uniquindio.trabajofinalcode.controller;

import co.edu.uniquindio.trabajofinalcode.model.Horario;
import co.edu.uniquindio.trabajofinalcode.model.Hospital;

import java.util.LinkedList;

public class HorariosMedicoController {

    Hospital hospital;

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setHorarioMedico(Horario horarioMedico, String cedulaMedico){
        try{
            hospital.setHorarioMedico(horarioMedico, cedulaMedico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Horario> horariosAElegirMedico(){
        try{
            return hospital.horariosAElegirMedico();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
