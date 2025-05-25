package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdministradorViewController {

        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_actualizarCita"
        private Button btn_actualizarCita; // Value injected by FXMLLoader

        @FXML // fx:id="btn_actualizarMedico"
        private Button btn_actualizarMedico; // Value injected by FXMLLoader

        @FXML // fx:id="btn_actualizarPaciente"
        private Button btn_actualizarPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="btn_actualizarSala"
        private Button btn_actualizarSala; // Value injected by FXMLLoader

        @FXML // fx:id="btn_crearMedico"
        private Button btn_crearMedico; // Value injected by FXMLLoader

        @FXML // fx:id="btn_crearPaciente"
        private Button btn_crearPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="btn_crearSala"
        private Button btn_crearSala; // Value injected by FXMLLoader

        @FXML // fx:id="btn_eliminarCita"
        private Button btn_eliminarCita; // Value injected by FXMLLoader

        @FXML // fx:id="btn_eliminarMedico"
        private Button btn_eliminarMedico; // Value injected by FXMLLoader

        @FXML // fx:id="btn_eliminarPaciente"
        private Button btn_eliminarPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="btn_eliminarSala"
        private Button btn_eliminarSala; // Value injected by FXMLLoader

        @FXML // fx:id="cb_especialidadMedica"
        private ComboBox<?> cb_especialidadMedica; // Value injected by FXMLLoader

        @FXML // fx:id="cb_tipoSangre"
        private ComboBox<?> cb_tipoSangre; // Value injected by FXMLLoader

        @FXML // fx:id="column_"
        private TableColumn<?, ?> column_; // Value injected by FXMLLoader

        @FXML // fx:id="column_SalaCita"
        private TableColumn<?, ?> column_SalaCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_apellidoMedico"
        private TableColumn<?, ?> column_apellidoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_apellidoPaciente"
        private TableColumn<?, ?> column_apellidoPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_cedulaMedico"
        private TableColumn<?, ?> column_cedulaMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_cedulaPaciente"
        private TableColumn<?, ?> column_cedulaPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_correoMedico"
        private TableColumn<?, ?> column_correoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_correoPaciente"
        private TableColumn<?, ?> column_correoPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_epsPaciente"
        private TableColumn<?, ?> column_epsPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_especialidadMedico"
        private TableColumn<?, ?> column_especialidadMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_fechaCita"
        private TableColumn<?, ?> column_fechaCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_fechaNacimientoMedico"
        private TableColumn<?, ?> column_fechaNacimientoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_fechaNacimientoPaciente"
        private TableColumn<?, ?> column_fechaNacimientoPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_horaCita"
        private TableColumn<?, ?> column_horaCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_idCita"
        private TableColumn<?, ?> column_idCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_motivoCita"
        private TableColumn<?, ?> column_motivoCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_nombreMedico"
        private TableColumn<?, ?> column_nombreMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_nombrePaciente"
        private TableColumn<?, ?> column_nombrePaciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_notasPreviasCita"
        private TableColumn<?, ?> column_notasPreviasCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_numeroLicenciaMedico"
        private TableColumn<?, ?> column_numeroLicenciaMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_telefonoMedico"
        private TableColumn<?, ?> column_telefonoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="column_telefonoPäciente"
        private TableColumn<?, ?> column_telefonoPäciente; // Value injected by FXMLLoader

        @FXML // fx:id="column_tipoSangrePaciente"
        private TableColumn<?, ?> column_tipoSangrePaciente; // Value injected by FXMLLoader

        @FXML // fx:id="dp_fechaNacimiento"
        private DatePicker dp_fechaNacimiento; // Value injected by FXMLLoader

        @FXML // fx:id="dp_fechaNacimientoMedico"
        private DatePicker dp_fechaNacimientoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="tbl_listaCitas"
        private TableView<?> tbl_listaCitas; // Value injected by FXMLLoader

        @FXML // fx:id="tbl_listaMedicos"
        private TableView<?> tbl_listaMedicos; // Value injected by FXMLLoader

        @FXML // fx:id="tbl_listaPacientes"
        private TableView<?> tbl_listaPacientes; // Value injected by FXMLLoader

        @FXML // fx:id="tbl_salas"
        private TableView<?> tbl_salas; // Value injected by FXMLLoader

        @FXML // fx:id="txt_apellidoMedico"
        private TextField txt_apellidoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="txt_apellidoPaciente"
        private TextField txt_apellidoPaciente; // Value injected by FXMLLoader

        @FXML // fx:id="txt_cedula"
        private TextField txt_cedula; // Value injected by FXMLLoader

        @FXML // fx:id="txt_cedulaMedico"
        private TextField txt_cedulaMedico; // Value injected by FXMLLoader

        @FXML // fx:id="txt_contrasena"
        private TextField txt_contrasena; // Value injected by FXMLLoader

        @FXML // fx:id="txt_contrasenaMedico"
        private TextField txt_contrasenaMedico; // Value injected by FXMLLoader

        @FXML // fx:id="txt_correo"
        private TextField txt_correo; // Value injected by FXMLLoader

        @FXML // fx:id="txt_correoMedico"
        private TextField txt_correoMedico; // Value injected by FXMLLoader

        @FXML // fx:id="txt_eps"
        private TextField txt_eps; // Value injected by FXMLLoader

        @FXML // fx:id="txt_nombreMedico"
        private TextField txt_nombreMedico; // Value injected by FXMLLoader

        @FXML // fx:id="txt_nombrePaciente"
        private TextField txt_nombrePaciente; // Value injected by FXMLLoader

        @FXML // fx:id="txt_numeroLicenciaMedico"
        private TextField txt_numeroLicenciaMedico; // Value injected by FXMLLoader

        @FXML // fx:id="txt_numeroSala"
        private TextField txt_numeroSala; // Value injected by FXMLLoader

        @FXML // fx:id="txt_telefono"
        private TextField txt_telefono; // Value injected by FXMLLoader

        @FXML // fx:id="txt_telefonoMedico"
        private TextField txt_telefonoMedico; // Value injected by FXMLLoader

        @FXML
        void actualizarCitaAction(ActionEvent event) {

        }

        @FXML
        void actualizarMedicoAction(ActionEvent event) {

        }

        @FXML
        void actualizarPacienteAction(ActionEvent event) {

        }

        @FXML
        void actualizarSalaAction(ActionEvent event) {

        }

        @FXML
        void crearMedicoAction(ActionEvent event) {

        }

        @FXML
        void crearPacienteAction(ActionEvent event) {

        }

        @FXML
        void crearSalaAction(ActionEvent event) {

        }

        @FXML
        void eliminarCitaAction(ActionEvent event) {

        }

        @FXML
        void eliminarMedicoAction(ActionEvent event) {

        }

        @FXML
        void eliminarPacienteAction(ActionEvent event) {

        }

        @FXML
        void eliminarSalaAction(ActionEvent event) {

        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btn_actualizarCita != null : "fx:id=\"btn_actualizarCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_actualizarMedico != null : "fx:id=\"btn_actualizarMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_actualizarPaciente != null : "fx:id=\"btn_actualizarPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_actualizarSala != null : "fx:id=\"btn_actualizarSala\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_crearMedico != null : "fx:id=\"btn_crearMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_crearPaciente != null : "fx:id=\"btn_crearPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_crearSala != null : "fx:id=\"btn_crearSala\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_eliminarCita != null : "fx:id=\"btn_eliminarCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_eliminarMedico != null : "fx:id=\"btn_eliminarMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_eliminarPaciente != null : "fx:id=\"btn_eliminarPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert btn_eliminarSala != null : "fx:id=\"btn_eliminarSala\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert cb_especialidadMedica != null : "fx:id=\"cb_especialidadMedica\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert cb_tipoSangre != null : "fx:id=\"cb_tipoSangre\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_ != null : "fx:id=\"column_\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_SalaCita != null : "fx:id=\"column_SalaCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_apellidoMedico != null : "fx:id=\"column_apellidoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_apellidoPaciente != null : "fx:id=\"column_apellidoPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_cedulaMedico != null : "fx:id=\"column_cedulaMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_cedulaPaciente != null : "fx:id=\"column_cedulaPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_correoMedico != null : "fx:id=\"column_correoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_correoPaciente != null : "fx:id=\"column_correoPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_epsPaciente != null : "fx:id=\"column_epsPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_especialidadMedico != null : "fx:id=\"column_especialidadMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_fechaCita != null : "fx:id=\"column_fechaCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_fechaNacimientoMedico != null : "fx:id=\"column_fechaNacimientoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_fechaNacimientoPaciente != null : "fx:id=\"column_fechaNacimientoPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_horaCita != null : "fx:id=\"column_horaCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_idCita != null : "fx:id=\"column_idCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_motivoCita != null : "fx:id=\"column_motivoCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_nombreMedico != null : "fx:id=\"column_nombreMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_nombrePaciente != null : "fx:id=\"column_nombrePaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_notasPreviasCita != null : "fx:id=\"column_notasPreviasCita\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_numeroLicenciaMedico != null : "fx:id=\"column_numeroLicenciaMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_telefonoMedico != null : "fx:id=\"column_telefonoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_telefonoPäciente != null : "fx:id=\"column_telefonoPäciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert column_tipoSangrePaciente != null : "fx:id=\"column_tipoSangrePaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert dp_fechaNacimiento != null : "fx:id=\"dp_fechaNacimiento\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert dp_fechaNacimientoMedico != null : "fx:id=\"dp_fechaNacimientoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert tbl_listaCitas != null : "fx:id=\"tbl_listaCitas\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert tbl_listaMedicos != null : "fx:id=\"tbl_listaMedicos\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert tbl_listaPacientes != null : "fx:id=\"tbl_listaPacientes\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert tbl_salas != null : "fx:id=\"tbl_salas\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_apellidoMedico != null : "fx:id=\"txt_apellidoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_apellidoPaciente != null : "fx:id=\"txt_apellidoPaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_cedula != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_cedulaMedico != null : "fx:id=\"txt_cedulaMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_contrasena != null : "fx:id=\"txt_contrasena\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_contrasenaMedico != null : "fx:id=\"txt_contrasenaMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_correoMedico != null : "fx:id=\"txt_correoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_eps != null : "fx:id=\"txt_eps\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_nombreMedico != null : "fx:id=\"txt_nombreMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_nombrePaciente != null : "fx:id=\"txt_nombrePaciente\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_numeroLicenciaMedico != null : "fx:id=\"txt_numeroLicenciaMedico\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_numeroSala != null : "fx:id=\"txt_numeroSala\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'administradorView.fxml'.";
            assert txt_telefonoMedico != null : "fx:id=\"txt_telefonoMedico\" was not injected: check your FXML file 'administradorView.fxml'.";

        }

}


