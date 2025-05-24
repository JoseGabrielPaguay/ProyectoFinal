package co.edu.uniquindio.trabajofinalcode.model;

import co.edu.uniquindio.trabajofinalcode.util.Constantes;
import co.edu.uniquindio.trabajofinalcode.util.Persistencia;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

public class Hospital {
    public String nombre;
    public Administrador adminstrador;
    public LinkedList<Paciente> listPacientes;
    public LinkedList<Medico> listMedicos;
    public LinkedList<CitaMedica> listCitasMedicas;
    public LinkedList<Sala> listSalas;

    public Hospital(String nombre) {
        this.adminstrador = leerDatosAdministrador();
        this.nombre = nombre;
        this.listPacientes = leerDatosPacientes();
        this.listMedicos = leerDatosMedicos();
        this.listCitasMedicas = leerDatosCitas();
        this.listSalas = leerDatosSalas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Paciente> getListPacientes() {
        return listPacientes;
    }

    public void setListPacientes(LinkedList<Paciente> listPacientes) {
        this.listPacientes = listPacientes;
    }

    public LinkedList<Medico> getListMedicos() {
        return listMedicos;
    }

    public void setListMedicos(LinkedList<Medico> listMedicos) {
        this.listMedicos = listMedicos;
    }

    public LinkedList<CitaMedica> getListCitasMedicas() {
        return listCitasMedicas;
    }

    public void setListCitasMedicas(LinkedList<CitaMedica> listCitasMedicas) {
        this.listCitasMedicas = listCitasMedicas;
    }

    /**
     * Método que permite registrar un administrador
     * @param nombre
     * @param apellido
     * @param cedula
     * @param correo
     * @param telefono
     * @param fechaNacimiento
     * @param contrasena
     * @throws Exception
     */
    public void registrarAdmin(String nombre, String apellido, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String contrasena) throws Exception{
        if(adminstrador != null){
            throw new Exception("Ya hay un admnistrador registrado");
        }
        Administrador admnistrador = new Administrador(nombre, apellido, cedula, correo, telefono, fechaNacimiento, contrasena);
        this.adminstrador = admnistrador;
        guardarDatosAdmin(admnistrador);
    }

    /**
     * Método para guardar los datos de los pacientes
     * @param pacientes
     */
    public void guardarDatosPacientes(LinkedList<Paciente> pacientes) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_PACIENTES, pacientes);
        } catch (IOException e) {
            System.err.println("Error guardando pacientes: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de los pacientes
     * @return pacientes guardados
     */
    public LinkedList<Paciente> leerDatosPacientes() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_PACIENTES);
            if (datos != null) {
                return (LinkedList<Paciente>)datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando pacientes: " + e.getMessage());
        }
        return new LinkedList<>();
    }

    /**
     * Método para guardar los datos del admin
     * @param admin
     */
    public void guardarDatosAdmin(Administrador admin) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_ADMINISTRADOR, admin);
        } catch (IOException e) {
            System.err.println("Error guardando administardor: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de los clientes
     * @return clientes guardados
     */
    public Administrador leerDatosAdministrador() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_ADMINISTRADOR);
            if (datos != null) {
                return (Administrador) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando administrador: " + e.getMessage());
        }
        return null;
    }

    /**
     * Método para guardar los datos de los medicos
     * @param medicos
     */
    public void guardarDatosMedicos(LinkedList<Medico> medicos) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_MEDICOS, medicos);
        } catch (IOException e) {
            System.err.println("Error guardando medicos: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de los medicos
     * @return medicos guardados
     */
    public LinkedList<Medico> leerDatosMedicos() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_MEDICOS);
            if (datos != null) {
                return (LinkedList<Medico>) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando medicos: " + e.getMessage());
        }
        return new LinkedList<>();
    }

    /**
     * Método para guardar los datos de las citas
     * @param citas
     */
    public void guardarDatosCitas(LinkedList<CitaMedica> citas) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_CITAS, citas);
        } catch (IOException e) {
            System.err.println("Error guardando citas: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de las citas
     * @return citas
     */
    public LinkedList<CitaMedica> leerDatosCitas() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_CITAS);
            if (datos != null) {
                return (LinkedList<CitaMedica>) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando citas: " + e.getMessage());
        }
        return new LinkedList<>();
    }

    /**
     * Método para guardar los datos de las salas
     * @param salas
     */
    public void guardarDatosSalas(LinkedList<Sala> salas) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_SALAS, salas);
        } catch (IOException e) {
            System.err.println("Error guardando salas: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de las salas
     * @return citas
     */
    public LinkedList<Sala> leerDatosSalas() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_SALAS);
            if (datos != null) {
                return (LinkedList<Sala>) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando salas: " + e.getMessage());
        }
        return new LinkedList<>();
    }
}
