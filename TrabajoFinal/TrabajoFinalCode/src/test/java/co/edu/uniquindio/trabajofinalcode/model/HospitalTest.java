package co.edu.uniquindio.trabajofinalcode.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {
    /**
     * Clase para probar los metodos relizados en la clase hospital
     */
    private static final Logger LOG = Logger.getLogger(HospitalTest.class.getName());

    @Test
    @DisplayName("prueba del método registrar un Administrador")
    void testRegistrarAdmin() throws Exception {
        LOG.info("inicio del metodo testRegistrarAdmin");
        Hospital hospital = new Hospital("Hospital Test");  
        hospital.registrarAdmin("Admin", "Test", "123", "admin@test.com", "123456", LocalDate.now(), "pass");
        assertNotNull(hospital.administrador);
        LOG.info("fin del metodo testRegistrarAdmin");
    }

    @Test
    @DisplayName("Prueba del método para registrar un paciente")
    void testRegistrarPaciente() throws Exception {
        LOG.info("inicio del metodo testRegistrarPaciente");
        Hospital hospital = new Hospital("Hospital Test");
        assertDoesNotThrow(( )->hospital.registrarPaciente("Paciente", "Test", "11243", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass"));
        LOG.info("fin del metodo testRegistrarPaciente");
    }

    @Test
    @DisplayName("Prueba del método para eliminar un paciente")
    void testEliminarPaciente() throws Exception {
        LOG.info("inicio del metodo testEliminarPaciente");
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS",
                LocalDate.now(), GrupoSanguineo.A_POSITIVO,
                "paciente@test.com", "pass");
        assertDoesNotThrow(() -> hospital.eliminarPaciente("123"));
        LOG.info("fin del metodo testEliminarPaciente");
    }

    @Test
    void testActualizarPaciente() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.actualizarPaciente("123", "Nuevo", "Test", "EPS", "654321", "nuevo@test.com");
        assertEquals("Nuevo", hospital.listPacientes.getFirst().getNombre());
    }

    @Test
    void testRegistrarMedico() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        assertDoesNotThrow(( )->hospital.registrarMedico("Medico", "perez", "11242343", "123456", "B114", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "paciente@test.com", "pass"));
    }

    @Test
    @DisplayName("Prueba del método para eliminar un medico")
    void testEliminarMedico() throws Exception {
        LOG.info("inicio del metodo testEliminarMedico");
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarMedico("juan", "peña", "12433", "1234562112", "121243", LocalDate.now(), EspecialidadMedica.DERMATOLOGIA, "holaa","aksjdjas");
        assertDoesNotThrow(() -> hospital.eliminarMedico("12433"));
        LOG.info("fin del metodo testEliminarMedico");
    }
    @Test
    void testActualizarMedico() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarMedico("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), EspecialidadMedica.NEUROLOGIA, "paciente@test.com", "pass");
        hospital.actualizarMedico("Juan", "perez", "124532","32165021983",LocalDate.now(),EspecialidadMedica.PEDIATRIA,"1212","1234531");
        assertEquals("Nuevo", hospital.listMedicos.getFirst().getNombre());
    }

    @Test
    void testRegistrarSala() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        assertDoesNotThrow(( )->hospital.registrarSala("28"));
    }

    @Test
    void testRegistrarCitaMedica() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.registrarMedico("Médico", "Test", "456", "123456", "LIC123", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "medico@test.com", "pass");
        hospital.registrarSala("101");
        hospital.setHorarioMedico(Horario.HORARIO_MANANA, "456");
        hospital.registrarCitaMedica(LocalDate.now(), Horario.HORARIO_MANANA, "Consulta", "Notas", "123");
        assertDoesNotThrow(( )->hospital.registrarCitaMedica(LocalDate.now(),Horario.HORARIO_MANANA,"Me moché una pata con la peinilla","hola","123456789"));
    }

    @Test
    void testEliminarCitaMedica() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.registrarMedico("Médico", "Test", "456", "123456", "LIC123", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "medico@test.com", "pass");
        hospital.registrarSala("101");
        hospital.setHorarioMedico(Horario.HORARIO_MANANA, "456");
        hospital.registrarCitaMedica(LocalDate.now(), Horario.HORARIO_MANANA, "Consulta", "Notas", "123");
        String idCita = hospital.listCitasMedicas.getFirst().getIdCita();
        hospital.eliminarCitaMedica(idCita);
        assertDoesNotThrow(() -> hospital.eliminarCitaMedica("12433"));
    }

    @Test
    void testRegistrarDiagnostico() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.registrarMedico("Médico", "Test", "456", "123456", "LIC123", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "medico@test.com", "pass");
        hospital.registrarDiagnostico("456", "123", "Diagnóstico de prueba");
        assertEquals(1, hospital.listDiagnosticos.size());
    }

    @Test
    void testObtenerPacienteCedula() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        assertNotNull(hospital.obtenerPacienteCedula("123"));
    }

    @Test
    void testObtenerMedicoCedula() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarMedico("Médico", "Test", "123", "123456", "LIC123", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "medico@test.com", "pass");
        assertNotNull(hospital.obtenerMedicoCedula("123"));
    }

    @Test
    void testIniciarSesion() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        assertTrue(hospital.iniciarSesion("paciente@test.com", "pass"));
    }

    @Test
    void testObtenerUsuarioCorreo() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        assertNotNull(hospital.obtenerUsuarioCorreo("paciente@test.com"));
    }

    @Test
    void testCambiarContrasena() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.cambiarContrasena("123", "newpass", "paciente@test.com");
        assertEquals("newpass", hospital.listPacientes.getFirst().getContrasena());
    }

    @Test
    void testObtenerCitasPaciente() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.registrarMedico("Médico", "Test", "456", "123456", "LIC123", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "medico@test.com", "pass");
        hospital.registrarSala("101");
        hospital.setHorarioMedico(Horario.HORARIO_MANANA, "456");
        hospital.registrarCitaMedica(LocalDate.now(), Horario.HORARIO_MANANA, "Consulta", "Notas", "123");
        assertEquals(1, hospital.obtenerCitasPaciente("123").size());
    }

    @Test
    void testObtenerListaPacientesMedico() throws Exception {
        Hospital hospital = new Hospital("Hospital Test");
        hospital.registrarPaciente("Paciente", "Test", "123", "123456", "EPS", LocalDate.now(), GrupoSanguineo.A_POSITIVO, "paciente@test.com", "pass");
        hospital.registrarMedico("Médico", "Test", "456", "123456", "LIC123", LocalDate.now(), EspecialidadMedica.CARDIOLOGIA, "medico@test.com", "pass");
        hospital.registrarSala("101");
        hospital.setHorarioMedico(Horario.HORARIO_MANANA, "456");
        hospital.registrarCitaMedica(LocalDate.now(), Horario.HORARIO_MANANA, "Consulta", "Notas", "123");
        assertEquals(1, hospital.obtenerListaPacientesMedico("456").size());
    }

    @Test
    void testGenerarIdCita() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.generarIdCita());
    }

    @Test
    void testListarMedicosHospital() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.listarMedicosHospital());
    }

    @Test
    void testListarPacientesHospital() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.listarPacientesHospital());
    }

    @Test
    void testListarCitasHospital() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.listarCitasHospital());
    }

    @Test
    void testListarSalasHospital() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.listarSalasHospital());
    }

    @Test
    void testListarGruposSanguineos() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.listarGruposSanguineos());
    }

    @Test
    void testListarEspecialidadesMedicas() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.listarEspecialidadesMedicas());
    }

    @Test
    void testHorariosDisponiblesCita() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.horariosDisponiblesCita());
    }

    @Test
    void testHorariosAElegirMedico() {
        Hospital hospital = new Hospital("Hospital Test");
        assertNotNull(hospital.horariosAElegirMedico());
    }
}

