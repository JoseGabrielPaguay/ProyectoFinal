package co.edu.uniquindio.trabajofinalcode.model;

import co.edu.uniquindio.trabajofinalcode.util.Constantes;
import co.edu.uniquindio.trabajofinalcode.util.Persistencia;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Hospital {
    public String nombre;
    public Administrador adminstrador;
    public LinkedList<Paciente> listPacientes;
    public LinkedList<Medico> listMedicos;
    public LinkedList<CitaMedica> listCitasMedicas;
    public LinkedList<Sala> listSalas;
    public LinkedList<Diagnostico> listDiagnosticos;

    public Hospital(String nombre) {
        this.adminstrador = leerDatosAdministrador();
        this.nombre = nombre;
        this.listPacientes = leerDatosPacientes();
        this.listMedicos = leerDatosMedicos();
        this.listCitasMedicas = leerDatosCitas();
        this.listSalas = leerDatosSalas();
        this.listDiagnosticos = leerDatosDiagnosticos();
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
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param correo
     * @param telefono
     * @param fechaNacimiento
     * @param contrasena
     * @throws Exception
     */
    public void registrarAdmin(String nombre, String apellido, String cedula, String correo, String telefono, LocalDate fechaNacimiento, String contrasena) throws Exception {
        if (adminstrador != null) {
            throw new Exception("Ya hay un admnistrador registrado");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre es necesario");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido es necesario");
        }
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cedula es necesaria");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo es necesario");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono es necesario");
        }
        if (fechaNacimiento == null) {
            throw new Exception("La fecha de nacimiento es necesaria");
        }
        if (contrasena == null || contrasena.isBlank()) {
            throw new Exception("La contraseña es necesaria");
        }
        Administrador admnistrador = new Administrador(nombre, apellido, cedula, correo, telefono, fechaNacimiento, contrasena);
        this.adminstrador = admnistrador;
        guardarDatosAdmin(admnistrador);
    }

    public void registrarDiagnosticos(String cedulaPaciente, String nombrePaciente, String tratamiento, String descripcion) throws Exception {

        if (cedulaPaciente == null || cedulaPaciente.isBlank()) {
            throw new Exception("la cedula del paciente es necesaria");
        }
        if (nombrePaciente == null || nombrePaciente.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (tratamiento == null || tratamiento.isBlank()) {
            throw new Exception("El tipo de tratamiento es necesario");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new Exception("La descripcion del diagnostico  es necesaria");
        }

        Diagnostico diagnostico = new Diagnostico(cedulaPaciente, nombrePaciente, tratamiento, descripcion);
        listDiagnosticos.add(diagnostico);
        guardarDatosDiagnosticos(listDiagnosticos);
    }

    public void registrarPaciente(String nombre, String apellido, String cedula, String telefono, String eps, LocalDate fechaNacimiento, GrupoSanguineo grupoSanguineo, String correo, String contrasena) throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (eps == null || eps.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (fechaNacimiento == null ) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (grupoSanguineo == null ) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        if (contrasena == null || contrasena.isBlank()) {
            throw new Exception("El nombre del paciente es necsario");
        }
        Paciente paciente = new Paciente(nombre, apellido, cedula,correo,telefono,fechaNacimiento,grupoSanguineo,eps,contrasena);
        listPacientes.add(paciente);
        guardarDatosPacientes(listPacientes);
    }


    public void registrarMedico(String nombre, String apellido, String cedula, String telefono, String numeroLicencia, LocalDate fechaNacimiento, EspecialidadMedica especialidadMedica, String correo, String contrasena) throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del Medico es necsario");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido del medico es necsario");
        }
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cedula del medico es necsaria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono del medico es necsario");
        }
        if (numeroLicencia == null || numeroLicencia.isBlank()) {
            throw new Exception("El numero de licencia del medico es necsario");
        }
        if (fechaNacimiento == null ) {
            throw new Exception("La fecha de nacimiento del medico es necearia");
        }
        if (especialidadMedica == null ) {
            throw new Exception("La especialidad Medica es necesaria");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo del Medico es necsario");
        }
        if (contrasena == null || contrasena.isBlank()) {
            throw new Exception("La contraseña es necesaria");
        }
        Medico medico = new Medico(nombre, apellido, cedula, correo,telefono,fechaNacimiento,especialidadMedica,numeroLicencia,contrasena);
        listMedicos.add(medico);
        guardarDatosMedicos(listMedicos);
    }

    public void registrarSala(String numeroSala) throws Exception {
        if (numeroSala == null || numeroSala.isBlank()) {
            throw new Exception("El numero de sala es necesario");
        }
        Sala sala = new Sala(numeroSala);
        listSalas.add(sala);
        guardarDatosSalas(listSalas);
    }


    public void registrarCitaMedica(LocalDate fecha, LocalTime hora, String motivo, String notasPrevias) throws Exception {

        if (fecha == null ) {
            throw new Exception("La fecha de la cita es necesaria");
        }
        if (hora == null ) {
            throw new Exception("La hora de la cita es necesaria");
        }
        if (motivo == null || motivo.isBlank()) {
            throw new Exception("El motivo del paciente es necsario");
        }
        if (notasPrevias == null || notasPrevias.isBlank()) {
            throw new Exception("Las notas previas de la cita son necesarias");
        }
        CitaMedica citaMedica = new CitaMedica(fecha, hora, motivo, notasPrevias);
        listCitasMedicas.add(citaMedica);
        guardarDatosCitas(listCitasMedicas);
    }


    public void eliminarPaciente(String cedula) throws Exception{
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cedula del paciente es necesaria");
        }
        if(cedula )
        for (Paciente paciente : listPacientes) {
            if (paciente.getCedula().equals(cedula)) {
                listPacientes.remove(paciente);
                break;
            }
        }
    }




    /**
     * Método para guardar los datos de los pacientes
     *
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
     *
     * @return pacientes guardados
     */
    public LinkedList<Paciente> leerDatosPacientes() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_PACIENTES);
            if (datos != null) {
                return (LinkedList<Paciente>) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando pacientes: " + e.getMessage());
        }
        return new LinkedList<>();
    }

    /**
     * Método para guardar los datos del admin
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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
     *
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

    public void guardarDatosDiagnosticos(LinkedList<Diagnostico> diagnosticos) {
        try {
            Persistencia.serializarObjeto(Constantes.RUTA_DIAGNOSTICOS, diagnosticos);
        } catch (IOException e) {
            System.err.println("Error guardando diagnosticos: " + e.getMessage());
        }
    }

    /**
     * Método para leer los datos de las salas
     *
     * @return citas
     */
    public LinkedList<Diagnostico> leerDatosDiagnosticos() {
        try {
            Object datos = Persistencia.deserializarObjeto(Constantes.RUTA_DIAGNOSTICOS);
            if (datos != null) {
                return (LinkedList<Diagnostico>) datos;
            }
        } catch (Exception e) {
            System.err.println("Error cargando Diagnosticos: " + e.getMessage());
        }
        return new LinkedList<>();
    }
}