package co.edu.uniquindio.trabajofinalcode.model;

import java.io.Serializable;

public class Sala implements Serializable {
    private String numeroSala;

    public Sala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }
}
