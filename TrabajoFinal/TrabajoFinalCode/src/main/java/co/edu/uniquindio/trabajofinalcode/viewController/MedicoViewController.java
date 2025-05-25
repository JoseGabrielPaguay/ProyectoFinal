package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.MedicoController;
import co.edu.uniquindio.trabajofinalcode.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MedicoViewController {

    App app;
    MedicoController medicoController = new MedicoController();
    Medico medico;

    public void setApp(App app) {
        this.app = app;
        medicoController.setHospital(app.getHospital());
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_generarDiagnostico"
    private Button btn_generarDiagnostico; // Value injected by FXMLLoader

    @FXML // fx:id="btn_historialPacientes"
    private Button btn_historialPacientes; // Value injected by FXMLLoader

    @FXML // fx:id="column_apellido"
    private TableColumn<?, ?> column_apellido; // Value injected by FXMLLoader

    @FXML // fx:id="column_cedula"
    private TableColumn<?, ?> column_cedula; // Value injected by FXMLLoader

    @FXML // fx:id="column_correo"
    private TableColumn<?, ?> column_correo; // Value injected by FXMLLoader

    @FXML // fx:id="column_eps"
    private TableColumn<?, ?> column_eps; // Value injected by FXMLLoader

    @FXML // fx:id="column_fechaNacimiento"
    private TableColumn<?, ?> column_fechaNacimiento; // Value injected by FXMLLoader

    @FXML // fx:id="column_nombre"
    private TableColumn<?, ?> column_nombre; // Value injected by FXMLLoader

    @FXML // fx:id="column_telefono"
    private TableColumn<?, ?> column_telefono; // Value injected by FXMLLoader

    @FXML // fx:id="column_tipoSangre"
    private TableColumn<?, ?> column_tipoSangre; // Value injected by FXMLLoader

    @FXML // fx:id="lbl_gestionarHorariosMedico"
    private Label lbl_gestionarHorariosMedico; // Value injected by FXMLLoader

    @FXML // fx:id="rootPane"
    private AnchorPane rootPane; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_listaPacientes"
    private TableView<?> tbl_listaPacientes; // Value injected by FXMLLoader

    @FXML // fx:id="txt_bienvenida"
    private Label txt_bienvenida; // Value injected by FXMLLoader

    @FXML // fx:id="txt_cedulaPaciente"
    private TextField txt_cedulaPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="txt_diagnosticoPaciente"
    private TextField txt_diagnosticoPaciente; // Value injected by FXMLLoader

    @FXML
    void abrirVIewHisotiralPacientes(ActionEvent event) {

    }

    @FXML
    void abrirgestionHorariosView(MouseEvent event) {

    }

    @FXML
    void crearDiagnostico(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_generarDiagnostico != null : "fx:id=\"btn_generarDiagnostico\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert btn_historialPacientes != null : "fx:id=\"btn_historialPacientes\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_apellido != null : "fx:id=\"column_apellido\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_cedula != null : "fx:id=\"column_cedula\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_correo != null : "fx:id=\"column_correo\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_eps != null : "fx:id=\"column_eps\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_fechaNacimiento != null : "fx:id=\"column_fechaNacimiento\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_nombre != null : "fx:id=\"column_nombre\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_telefono != null : "fx:id=\"column_telefono\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert column_tipoSangre != null : "fx:id=\"column_tipoSangre\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert lbl_gestionarHorariosMedico != null : "fx:id=\"lbl_gestionarHorariosMedico\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert tbl_listaPacientes != null : "fx:id=\"tbl_listaPacientes\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert txt_bienvenida != null : "fx:id=\"txt_bienvenida\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert txt_cedulaPaciente != null : "fx:id=\"txt_cedulaPaciente\" was not injected: check your FXML file 'medicoView.fxml'.";
        assert txt_diagnosticoPaciente != null : "fx:id=\"txt_diagnosticoPaciente\" was not injected: check your FXML file 'medicoView.fxml'.";

    }

}

