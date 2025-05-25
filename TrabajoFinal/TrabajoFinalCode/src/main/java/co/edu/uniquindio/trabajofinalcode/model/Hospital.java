package co.edu.uniquindio.trabajofinalcode.model;

import co.edu.uniquindio.trabajofinalcode.util.Constantes;
import co.edu.uniquindio.trabajofinalcode.util.Persistencia;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
     * Metodo que elige una sala al azar
     * @return
     */
    public Sala elegirSalaRandom(){
        Random random = new Random();
        int numeroRandom = random.nextInt(listSalas.size());
        int contador = 0;
        for(Sala sala : listSalas){
            contador += 1;
            if(numeroRandom == contador){
                return sala;
            }
        }
        return null;
    }

    public void setHorarioMedico(String horarioMedico, String cedulaMedico) throws Exception{
        for(Medico medico : listMedicos){
            if(medico.getCedula().equals(cedulaMedico)){
                medico.setHorario(horarioMedico);
            }
        }
        throw new Exception("No se encontró un medico valido");
    }

    /**
     * Método que genera una id para una cita
     * @return
     */
    public String generarIdCita() {
        return UUID.randomUUID().toString();
    }

    /**
     * Método para el inicio de sesión
     * @param correo
     * @param contrasena
     * @return
     * @throws Exception
     */
    public boolean iniciarSesion(String correo, String contrasena) throws Exception{
        if(correo == null || correo.isEmpty()){
            throw new Exception("El correo es obligatorio");
        }
        if(contrasena == null || contrasena.isEmpty()){
            throw new Exception("El correo es obligatorio");
        }
        for(Paciente paciente : listPacientes){
            if(paciente.getCorreo().equals(correo) && paciente.getContrasena().equals(contrasena)){
                return true;
            }
        }
        for(Medico medico : listMedicos){
            if(medico.getCorreo().equals(correo) && medico.getContrasena().equals(contrasena)){
                return true;
            }
        }
        if(adminstrador.getCorreo().equals(correo) && adminstrador.getContrasena().equals(contrasena)){
            return true;
        }
        throw new Exception("Los datos no coinciden con ninguna cuenta");
    }

    /**
     * Método que obteniene usuario de un correo
     * @param correo
     * @return usuario
     * @throws Exception
     */
    public Usuario obtenerUsuarioCorreo(String correo) throws Exception{
        if(correo == null || correo.isEmpty()){
            throw new Exception("El correo es obligatorio");
        }
        for(Medico medico : listMedicos){
            if(medico.getCorreo().equals(correo)){
                return medico;
            }
        }
        for(Paciente paciente : listPacientes){
            if(paciente.getCorreo().equals(correo)){
                return paciente;
            }
        }
        if(adminstrador.getCorreo().equals(correo)){
            return adminstrador;
        }
        throw new Exception("No hay nigun usuario asociado a este correo");
    }

    /**
     * Método que permite cambia una contraseña
     * @param codigo
     * @param contrasenaNueva
     * @param correo
     * @throws Exception
     */
    public void cambiarContrasena(String codigo, String contrasenaNueva, String correo) throws Exception{
        if(codigo == null){
            throw new Exception("El codigo es obligatorio");
        }
        if(contrasenaNueva == null){
            throw new Exception("Ingrese una nueva contraseña");
        }
        if(correo == null){
            throw new Exception("Correo no encontrado");
        }
        Usuario usuario = obtenerUsuarioCorreo(correo);
        if(usuario == null){
            throw new Exception("Usuario no encontrado");
        }
        if(usuario instanceof Paciente){
            usuario.setContrasena(contrasenaNueva);
            guardarDatosPacientes(listPacientes);
        }
        if(usuario instanceof Administrador){
            usuario.setContrasena(contrasenaNueva);
            guardarDatosAdmin(adminstrador);
        }
        if(usuario instanceof Medico){
            usuario.setContrasena(contrasenaNueva);
            guardarDatosMedicos(listMedicos);
        }


    }

    /**
     * Método que guarda el código de activación
     * @param codigo
     * @param cedula
     */
    public void guardarCodigoActivacion(String codigo, String cedula){
        for(Paciente paciente : listPacientes){
            if(paciente.getCedula().equals(cedula)){
                paciente.setCodigoValidacion(codigo);
                guardarDatosPacientes(listPacientes);
                break;
            }
        }
        for(Medico medico : listMedicos){
            if(medico.getCedula().equals(cedula)){
                medico.setCodigoValidacion(codigo);
                guardarDatosMedicos(listMedicos);
                break;
            }
        }
        if(adminstrador.getCedula().equals(cedula)){
            adminstrador.setCodigoValidacion(codigo);
            guardarDatosAdmin(adminstrador);
        }

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

    /**
     * Método que registra un nuevo diagnóstico
     * @param cedulaPaciente
     * @param nombrePaciente
     * @param tratamiento
     * @param descripcion
     * @throws Exception
     */
    public void registrarDiagnostico(String cedulaPaciente, String nombrePaciente, String tratamiento, String descripcion) throws Exception {

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

    /**
     * Método que registra un nuevo paciente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param telefono
     * @param eps
     * @param fechaNacimiento
     * @param grupoSanguineo
     * @param correo
     * @param contrasena
     * @throws Exception
     */
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

    /**
     * Método que elimina los datos de un paciente
     * @param cedula
     * @throws Exception
     */
    public void eliminarPaciente(String cedula) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del paciente es necesaria");
        }
        boolean eliminado = false;
        for (Paciente paciente : listPacientes) {
            if (paciente.getCedula().equals(cedula)) {
                listPacientes.remove(paciente);
                eliminado = true;
                guardarDatosPacientes(listPacientes);
                break;
            }
        }
        if (!eliminado) {
            throw new Exception("No se encontró un paciente con la cédula proporcionada");
        }
    }

    /**
     * método que actualiza un paciente
     * @param cedula
     * @param nombre
     * @param apellido
     * @param eps
     * @param telefono
     * @param correo
     * @throws Exception
     */
    public void actualizarPaciente(String cedula, String nombre, String apellido, String eps,String telefono, String correo) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (eps == null || eps.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        boolean actualizado = false;
        for (Paciente paciente : listPacientes) {
            if (paciente.getCedula().equals(cedula)) {
                paciente.setNombre(nombre);
                paciente.setApellido(apellido);
                paciente.setEps(eps);
                paciente.setTelefono(telefono);
                paciente.setCorreo(correo);
                actualizado = true;
                guardarDatosPacientes(listPacientes);
                break;
            }
        }
        if (!actualizado) {
            throw new Exception("No se encontró un paciente con la cédula proporcionada para actualizar");
        }
    }

    /**
     * Método que registra los datos de un médico
     * @param nombre
     * @param apellido
     * @param cedula
     * @param telefono
     * @param numeroLicencia
     * @param fechaNacimiento
     * @param especialidadMedica
     * @param correo
     * @param contrasena
     * @throws Exception
     */
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

    /**
     * Método que elimina los datos de un médico
     * @param cedula
     * @throws Exception
     */
    public void eliminarMedico(String cedula) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del médico es necesaria");
        }
        boolean eliminado = false;
        for (Medico medico : listMedicos) {
            if (medico.getCedula().equals(cedula)) {
                listMedicos.remove(medico);
                eliminado = true;
                guardarDatosMedicos(listMedicos);
                break;
            }
        }
        if (!eliminado) {
            throw new Exception("No se encontró un médico con la cédula proporcionada");
        }

    }

    /**
     * Método que actuliza los dátos de un médico
     * @param cedula
     * @param medicoActualizado
     * @throws Exception
     */
    public void actualizarMedico(String cedula, Medico medicoActualizado) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del medico es obligatoria");
        }
        if (medicoActualizado == null) {
            throw new Exception("El médico actualizado no puede ser nulo");
        }
        boolean actualizado = false;
        for (Medico medico : listMedicos) {
            if (medico.getCedula().equals(cedula)) {
                medico.setNombre(medicoActualizado.getNombre());
                medico.setApellido(medicoActualizado.getApellido());
                medico.setCorreo(medico.getCorreo());
                medico.setTelefono(medico.getTelefono());
                medico.setEspecialidad(medicoActualizado.getEspecialidad());
                medico.setContrasena(medicoActualizado.getContrasena());
                actualizado = true;
                guardarDatosPacientes(listPacientes);
                break;
            }
        }
        if (!actualizado) {
            throw new Exception("No se encontró un médico con la cédula proporcionada para actualizar");
        }
    }

    /**
     * Método que registra una sala
     * @param numeroSala
     * @throws Exception
     */
    public void registrarSala(String numeroSala) throws Exception {
        if (numeroSala == null || numeroSala.isBlank()) {
            throw new Exception("El numero de sala es necesario");
        }
        Sala sala = new Sala(numeroSala);
        listSalas.add(sala);
        guardarDatosSalas(listSalas);
    }


    /**
     * método que registra una cita médica
     * @param fecha
     * @param hora
     * @param motivo
     * @param notasPrevias
     * @throws Exception
     */
    public void registrarCitaMedica(LocalDate fecha, String hora, String motivo, String notasPrevias, String idPaciente) throws Exception {

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
        String id = UUID.randomUUID().toString();
        Sala sala = elegirSalaRandom();
        Paciente paciente =buscarPacienteCedula(idPaciente);
        Medico medico= obtenerMedicoDisponible(String hora);
        CitaMedica citaMedica = new CitaMedica(id, fecha, hora, motivo, notasPrevias, sala, paciente, medico);
        listCitasMedicas.add(citaMedica);
        guardarDatosCitas(listCitasMedicas);
    }

    public Paciente buscarPacienteCedula(String cedula) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria.");
        }
        for (Paciente paciente : listPacientes) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        throw new Exception("No se encontró un paciente con la cédula: " + cedula);
    }
    /**
     * Método que elimina una cita médica
     * @param idCita
     * @throws Exception
     */
    public void eliminarCitaMedica(String idCita) throws Exception {
        if (idCita == null) {
            throw new Exception("El  id de la cita Medica no es valido");
        }
        boolean eliminado = false;
        for (CitaMedica citaMedica : listCitasMedicas) {
            if (citaMedica.getIdCita().equals(idCita)) {
                listCitasMedicas.remove(citaMedica);
                eliminado = true;
                break;
            }
        }
        if (!eliminado) {
            throw new Exception("No se encontro una cita medica para eliminar con ese id");
        }
    }

    /**
     * método que actualiza una cita Médica
     * @param idCita
     * @param citaActualizada
     * @throws Exception
     */
    public void actualizarCita(String idCita, CitaMedica citaActualizada) throws Exception {
        if (idCita == null || idCita.isBlank()) {
            throw new Exception("La id de la cita es nula");
        }
        if (citaActualizada == null) {
            throw new Exception("La cita actualizada no puede ser nulo");
        }
        boolean actualizado = false;
        for (CitaMedica citaMedica : listCitasMedicas) {
            if (citaMedica.getIdCita().equals(idCita)) {
                citaMedica.setFecha(citaActualizada.getFecha());
                citaMedica.setHora(citaActualizada.getHora());
                citaMedica.setMotivo(citaActualizada.getMotivo());
                citaMedica.setNotasPrevias(citaActualizada.getNotasPrevias());
                actualizado = true;
                guardarDatosPacientes(listPacientes);
                break;
            }
        }
        if (!actualizado) {
            throw new Exception("No se encontró un médico con la cédula proporcionada para actualizar");
        }
    }

    /**
     * Método que retorna las citas medicas
     * @return
     * @throws Exception
     */
    public LinkedList<CitaMedica> generarReporteCitas() throws Exception {
        if (listCitasMedicas == null || listCitasMedicas.isEmpty()) {
            throw new Exception("No hay citas médicas registradas.");
        }

        return listCitasMedicas;
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
     * Método que obtiene las citas de un solo paciente
     * @param cedulaPaciente
     * @return
     * @throws Exception
     */
    public LinkedList<CitaMedica> obtenerHistorialMedicoPaciente(String cedulaPaciente) throws Exception{
        LinkedList<CitaMedica> lista = new LinkedList<>();
        for(CitaMedica citaMedica : listCitasMedicas){
            if(citaMedica.getPaciente().getCedula().equals(cedulaPaciente)){
                lista.add(citaMedica);
            }
        }
        if(lista.isEmpty()){
            throw new Exception("El paciente no tiene citas qus mostrar");
        }
        return lista;
    }

    /**
     * método que dá los horarios que puede tener un médico
     * @return
     */
    public LinkedList<String> horariosAElegirMedico(){
        LinkedList<String> listaHorariosMedico= new LinkedList<>();
        listaHorariosMedico.add("6:00am-2:00pm");
        listaHorariosMedico.add("2:00pm-10:00pm");
        listaHorariosMedico.add("10:00pm-6:00am");
        return listaHorariosMedico;
    }

  public Medico obtenerMedicoDisponible(String Cedula){

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

    /**
     * Método que guarda los datos de los diagnosticos
     * @param diagnosticos
     */
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