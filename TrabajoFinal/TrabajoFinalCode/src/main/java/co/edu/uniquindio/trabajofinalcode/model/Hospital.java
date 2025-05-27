package co.edu.uniquindio.trabajofinalcode.model;

import co.edu.uniquindio.trabajofinalcode.util.Constantes;
import co.edu.uniquindio.trabajofinalcode.util.EnvioEmail;
import co.edu.uniquindio.trabajofinalcode.util.GeneradorCodigos;
import co.edu.uniquindio.trabajofinalcode.util.Persistencia;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Hospital {
    public String nombre;
    public Administrador administrador;
    public LinkedList<Paciente> listPacientes;
    public LinkedList<Medico> listMedicos;
    public LinkedList<CitaMedica> listCitasMedicas;
    public LinkedList<Sala> listSalas;
    public LinkedList<Diagnostico> listDiagnosticos;
    public GeneradorCodigos generadorCodigos;

    public Hospital(String nombre) {
        this.administrador = leerDatosAdministrador();
        this.nombre = nombre;
        this.listPacientes = leerDatosPacientes();
        this.listMedicos = leerDatosMedicos();
        this.listCitasMedicas = leerDatosCitas();
        this.listSalas = leerDatosSalas();
        this.generadorCodigos = new GeneradorCodigos();
        this.listDiagnosticos = leerDatosDiagnosticos();
    }

    /**
     * método que envía un correo electrónico con el codigo de verificación
     * @param correo
     * @throws Exception
     */
    public void enviarCodigoCorreo(String correo) throws Exception{
        Usuario usuario = obtenerUsuarioCorreo(correo);
        if(usuario == null){
            throw new Exception("No hay un usuario asignado a esta cuenta");
        }
        String codigo = generarCodigo();
        guardarCodigoActivacion(codigo, correo);
        EnvioEmail.enviarNotificacion(correo, "Codigo de verificación",
                "señor/a " + usuario.getNombre() +
                        ", su codigo de verificación es el siguiente: " + codigo);
    }

    public String generarCodigo(){
        return generadorCodigos.generarCodigoHexadecimalStr(4);
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

    public LinkedList<Medico> listarMedicosHospital() {
        return listMedicos;
    }

    public LinkedList<Paciente> listarPacientesHospital() {
        return listPacientes;
    }

    public LinkedList<CitaMedica> listarCitasHospital() {
        return listCitasMedicas;
    }

    public LinkedList<Sala> listarSalasHospital() {
        return listSalas;
    }

    public LinkedList<GrupoSanguineo> listarGruposSanguineos(){
        return new LinkedList<>(Arrays.asList(GrupoSanguineo.values()));
    }

    public LinkedList<EspecialidadMedica> listarEspecialidadesMedicas(){
        return new LinkedList<>(Arrays.asList(EspecialidadMedica.values()));
    }

    public  LinkedList<Diagnostico> obtenerDiagnosticosPaciente(Paciente paciente) {
        LinkedList<Diagnostico> lista = new LinkedList<>();
        for(Diagnostico diagnostico : listDiagnosticos){
            if(diagnostico.getPaciente().getCedula().equals(paciente.getCedula())){
                lista.add(diagnostico);
            }
        }
        return lista;
    }


    /**
     * método que retorna las citas de un solo paciente
     * @param idPaciente
     * @return
     */
    public LinkedList<CitaMedica> obtenerCitasPaciente(String idPaciente) {
        LinkedList<CitaMedica> lista = new LinkedList<>();
        for(CitaMedica citaMedica : listCitasMedicas){
            if(citaMedica.getPaciente().getCedula().equals(idPaciente)){
                lista.add(citaMedica);
            }
        }
        return lista;
    }

    /**
     * metodo que obtiene la lista de pacientes que tiene un médico
     * @param idMedico
     * @return
     * @throws Exception
     */
    public LinkedList<Paciente> obtenerListaPacientesMedico(String idMedico){
        LinkedList<Paciente> lista = new LinkedList<>();
        for(CitaMedica citaMedica : listCitasMedicas){
            if(citaMedica.getMedico().getCedula().equals(idMedico)){
                lista.add(citaMedica.getPaciente());
            }
        }
        return lista;
    }

    /**
     * Metodo que elige una sala al azar
     * @return
     */
    public Sala elegirSalaRandom(){
        if (listSalas == null || listSalas.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int numeroRandom = random.nextInt(listSalas.size());
        return listSalas.get(numeroRandom);
    }

    /**
     * método que asigna el horario de un médico
     * @param horarioMedico
     * @param cedulaMedico
     * @throws Exception
     */
    public void setHorarioMedico(Horario horarioMedico, String cedulaMedico) throws Exception{
        for(Medico medico : listMedicos){
            if(medico.getCedula().equals(cedulaMedico)){
                medico.setHorario(horarioMedico);
                guardarDatosMedicos(listMedicos);
                return;
            }
        }
        throw new Exception("No se encontró un medico valido");
    }

    /**
     * Método que genera una id para una cita
     * @return
     */
    public String generarIdCita() {
        return generadorCodigos.generarCodigoHexadecimalStr(4);
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
            throw new Exception("La contraseña es obligatorio");
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
        if(administrador.getCorreo().equals(correo) && administrador.getContrasena().equals(contrasena)){
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
        if(administrador.getCorreo().equals(correo)){
            return administrador;
        }
        throw new Exception("No hay nigun usuario asociado a este correo");
    }

    /**
     * Método que permite cambiar una contraseña
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
            guardarDatosAdmin(administrador);
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
        if(administrador.getCedula().equals(cedula)){
            administrador.setCodigoValidacion(codigo);
            guardarDatosAdmin(administrador);
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
        if (administrador != null) {
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
        Administrador administrador = new Administrador(nombre, apellido, cedula, correo, telefono, fechaNacimiento, contrasena);
        this.administrador = administrador;
        guardarDatosAdmin(administrador);
    }

    /**
     * Método que registra un nuevo diagnóstico
     * @param cedulaPaciente
     * @param cedulaMedico
     * @param descripcion
     * @throws Exception
     */
        public void registrarDiagnostico(String cedulaMedico, String cedulaPaciente, String descripcion) throws Exception {
        if (cedulaPaciente == null || cedulaPaciente.isBlank()) {
            throw new Exception("la cedula del paciente es necesaria");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new Exception("La descripcion del diagnostico  es necesaria");
        }

        Paciente paciente = obtenerPacienteCedula(cedulaPaciente);
        Medico medico = obtenerMedicoCedula(cedulaMedico);

        if(medico == null){
            throw new Exception("Medico no encontrado");
        }
        if(paciente == null){
            throw new Exception("paciente no encontrado");
        }

        Diagnostico diagnostico = new Diagnostico(medico, paciente, descripcion);
        listDiagnosticos.add(diagnostico);
        guardarDatosDiagnosticos(listDiagnosticos);
    }

    /**
     * método que obtiene un paciente por su cedula
     * @param cedulaPaciente
     * @return
     */
    public Paciente obtenerPacienteCedula(String cedulaPaciente){
        for(Paciente paciente : listPacientes){
            if (paciente.getCedula().equals(cedulaPaciente)){
                return paciente;
            }
        }
        return null;
    }

    /**
     * método que obtiene un medico por su cédula
     * @param cedulaMedico
     * @return
     */
    public Medico obtenerMedicoCedula(String cedulaMedico){
        for(Medico medico : listMedicos){
            if(medico.getCedula().equals(cedulaMedico)){
                return medico;
            }
        }
        return null;
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
            throw new Exception("El nombre del paciente es necesario");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido del paciente es necesario");
        }
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cedula del paciente es necesaria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono del paciente es necesario");
        }
        if (eps == null || eps.isBlank()) {
            throw new Exception("La eps del paciente es necesaria");
        }
        if (fechaNacimiento == null ) {
            throw new Exception("La fecha de naciemiento del paciente es necesaria");
        }
        if (grupoSanguineo == null ) {
            throw new Exception("El grupo sanguineo del paciente es necesario");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo del paciente es necesario");
        }
        if (contrasena == null || contrasena.isBlank()) {
            throw new Exception("la contraseña del paciente es necesaria");
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
     * método que actualiza un paciente como Administrador
     * @param cedula
     * @param nombre
     * @param apellido
     * @param eps
     * @param telefono
     * @param correo
     * @throws Exception
     */
    public void actualizarPacienteAdmin(String cedula, String nombre, String apellido, String eps, String telefono, String correo, LocalDate fechaNacimiento, GrupoSanguineo tipoSangre) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del paciente es obligatorio");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido del paciente es obligatorio");
        }
        if (eps == null || eps.isBlank()) {
            throw new Exception("La EPS del paciente es obligatoria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono del paciente es obligatorio");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo del paciente es obligatorio");
        }
        if (tipoSangre == null) {
            throw new Exception("El tipo de sangre del paciente es obligatorio");
        }
        if (fechaNacimiento == null) {
            throw new Exception("La fecha de nacimiento del paciente es obligatoria");
        }

        boolean actualizado = false;
        for (Paciente paciente : listPacientes) {
            if (paciente.getCedula().equals(cedula)) {
                paciente.setNombre(nombre);
                paciente.setApellido(apellido);
                paciente.setEps(eps);
                paciente.setTelefono(telefono);
                paciente.setCorreo(correo);
                paciente.setFechaNacimiento(fechaNacimiento);
                paciente.setTipoSangre(tipoSangre);
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
     * método para que un paceinte se actualice a si mismo
     * @param cedula
     * @param nombre
     * @param apellido
     * @param eps
     * @param telefono
     * @param correo
     * @throws Exception
     */
    public void actualizarPaciente(String cedula, String nombre, String apellido, String eps, String telefono, String correo) throws Exception {
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cédula del paciente es obligatoria");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del paciente es obligatorio");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido del paciente es obligatorio");
        }
        if (eps == null || eps.isBlank()) {
            throw new Exception("La EPS del paciente es obligatoria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono del paciente es obligatorio");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo del paciente es obligatorio");
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
    public void registrarMedico(String nombre, String apellido, String cedula, String telefono, String numeroLicencia,
                                LocalDate fechaNacimiento, EspecialidadMedica especialidadMedica, String correo, String contrasena) throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del Medico es necesario");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido del medico es necesario");
        }
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cedula del medico es necesaria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono del medico es necesario");
        }
        if (numeroLicencia == null || numeroLicencia.isBlank()) {
            throw new Exception("El numero de licencia del medico es necesario");
        }
        if (fechaNacimiento == null ) {
            throw new Exception("La fecha de nacimiento del medico es necesaria");
        }
        if (especialidadMedica == null ) {
            throw new Exception("La especialidad Medica es necesaria");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo del Medico es necesario");
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
     * método que actuliza un médico
     * @param nombre
     * @param apellido
     * @param cedula
     * @param telefono
     * @param fechaNacimiento
     * @param especialidadMedica
     * @param correo
     * @param numeroLicencia
     * @throws Exception
     */
    public void actualizarMedico(String nombre, String apellido, String cedula, String telefono, LocalDate fechaNacimiento,EspecialidadMedica especialidadMedica, String correo, String numeroLicencia) throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre del Medico es necesario");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido del medico es neecsario");
        }
        if (cedula == null || cedula.isBlank()) {
            throw new Exception("La cedula del medico es necesaria");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El telefono del medico es necesario");
        }
        if (numeroLicencia == null || numeroLicencia.isBlank()) {
            throw new Exception("El numero de licencia del medico es necesario");
        }
        if (fechaNacimiento == null ) {
            throw new Exception("La fecha de nacimiento del medico es necesaria");
        }
        if (especialidadMedica == null ) {
            throw new Exception("La especialidad Medica es necesaria");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo del Medico es necsario");
        }
        boolean actualizado = false;
        for (Medico medico : listMedicos) {
            if (medico.getCedula().equals(cedula)) {
                medico.setNombre(nombre);
                medico.setApellido(apellido);
                medico.setCorreo(correo);
                medico.setTelefono(telefono);
                medico.setEspecialidad(especialidadMedica);
                medico.setFechaNacimiento(fechaNacimiento);
                medico.setNumeroLicencia(numeroLicencia);
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
        for(Sala sala : listSalas){
            if(sala.getNumeroSala().equals(numeroSala))
                throw new Exception("Ya existe una sala con este numero");
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
    public void registrarCitaMedica(LocalDate fecha, Horario hora, String motivo, String notasPrevias, String idPaciente) throws Exception {

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
        String id = generarIdCita();
        Sala sala = elegirSalaRandom();
        Paciente paciente =buscarPacienteCedula(idPaciente);
        Medico medico= obtenerMedicoDisponible(hora);
        CitaMedica citaMedica = new CitaMedica(id, fecha, hora, motivo, notasPrevias, sala, paciente, medico);
        listCitasMedicas.add(citaMedica);
        guardarDatosCitas(listCitasMedicas);
        EnvioEmail.enviarNotificacion(paciente.getCorreo(), "Cita agendada", "Señor/a " + paciente.getNombre() +
                ", Su cita con el id " + id + ", fue agendada correctamente para el dia  " + fecha.getDayOfMonth() + ", en el horario " + hora.toString() +
                ", con el medico " + medico.getNombre() + ", en la sala numero " + sala.getNumeroSala());
    }

    /**
     * metodo que retorna un médico que este disponible en cierto horario
     * @param horario
     * @return
     * @throws Exception
     */
    public Medico obtenerMedicoDisponible(Horario horario) throws Exception{
        List<Medico> medicosDisponibles = new ArrayList<>();

        for (Medico medico : listMedicos) {
            if (medico.getHorario().equals(horario)) {
                medicosDisponibles.add(medico);
            }
        }

        if (medicosDisponibles.isEmpty()) {
            throw new Exception("No hay médicos disponibles para este horario");
        }

        Random random = new Random();
        int indice = random.nextInt(medicosDisponibles.size());
        return medicosDisponibles.get(indice);
    }

    /**
     * método que devuelve todos los valores del ENUM Horario
     * @return
     */
    public LinkedList<Horario> horariosDisponiblesCita(){
        return new LinkedList<>(Arrays.asList(Horario.values()));
    }

    /**
     * metodo que retorna a un paciente buscado por su cedula
     * @param cedula
     * @return
     * @throws Exception
     */
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
        CitaMedica cita = obtenerCitaId(idCita);
        boolean eliminado = false;
        for (CitaMedica citaMedica : listCitasMedicas) {
            if (citaMedica.getIdCita().equals(idCita)) {
                listCitasMedicas.remove(citaMedica);
                guardarDatosCitas(listCitasMedicas);
                eliminado = true;
                EnvioEmail.enviarNotificacion(cita.getPaciente().getCorreo(), "Cancelación de cita", "Señor/a " +
                        cita.getPaciente().getNombre() + ", su cita con el id " + idCita + ", fue cancelada");
                break;
            }
        }
        if (!eliminado) {
            throw new Exception("No se encontro una cita medica para eliminar con ese id");
        }
    }

    /**
     * metodo que obtiene una cita por su id
     * @param id
     * @return
     */
    public CitaMedica obtenerCitaId(String id){
        for(CitaMedica citaMedica : listCitasMedicas){
            if(citaMedica.getIdCita().equals(id)){
                return citaMedica;
            }
        }
        return null;
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
        return lista;
    }

    /**
     * método que dá los horarios que puede tener un médico
     * @return
     */
    public LinkedList<Horario> horariosAElegirMedico(){
        return new LinkedList<>(Arrays.asList(Horario.values()));
    }


  //public Medico obtenerMedicoDisponible(String Cedula){
       // return medico;

  //}
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