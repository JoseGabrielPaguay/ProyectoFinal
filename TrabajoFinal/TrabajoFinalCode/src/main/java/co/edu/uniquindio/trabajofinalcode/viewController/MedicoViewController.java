package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.MedicoController;
import co.edu.uniquindio.trabajofinalcode.model.Medico;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MedicoViewController {

    App app;
    MedicoController medicoController = new MedicoController();
    Medico medico;
    Paciente selectedPaciente;

    public void setApp(App app) {
        this.app = app;
        medicoController.setHospital(app.getHospital());
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


    @FXML // fx:id="lbl_archivoDiagnostico"
    private Label lbl_archivoDiagnostico; // Value injected by FXMLLoader

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_generarDiagnostico"
    private Button btn_generarDiagnostico; // Value injected by FXMLLoader

    @FXML // fx:id="btn_historialPacientes"
    private Button btn_historialPacientes; // Value injected by FXMLLoader

    @FXML // fx:id="column_apellido"
    private TableColumn<Paciente, String> column_apellido; // Value injected by FXMLLoader

    @FXML // fx:id="column_cedula"
    private TableColumn<Paciente, String> column_cedula; // Value injected by FXMLLoader

    @FXML // fx:id="column_correo"
    private TableColumn<Paciente, String> column_correo; // Value injected by FXMLLoader

    @FXML // fx:id="column_eps"
    private TableColumn<Paciente, String> column_eps; // Value injected by FXMLLoader

    @FXML // fx:id="column_fechaNacimiento"
    private TableColumn<Paciente, String> column_fechaNacimiento; // Value injected by FXMLLoader

    @FXML // fx:id="column_nombre"
    private TableColumn<Paciente, String> column_nombre; // Value injected by FXMLLoader

    @FXML // fx:id="column_telefono"
    private TableColumn<Paciente, String> column_telefono; // Value injected by FXMLLoader

    @FXML // fx:id="column_tipoSangre"
    private TableColumn<Paciente, String> column_tipoSangre; // Value injected by FXMLLoader

    @FXML // fx:id="lbl_gestionarHorariosMedico"
    private Label lbl_gestionarHorariosMedico; // Value injected by FXMLLoader

    @FXML // fx:id="rootPane"
    private AnchorPane rootPane; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_listaPacientes"
    private TableView<Paciente> tbl_listaPacientes; // Value injected by FXMLLoader

    @FXML // fx:id="txt_bienvenida"
    private Label txt_bienvenida; // Value injected by FXMLLoader

    @FXML // fx:id="txt_cedulaPaciente"
    private TextField txt_cedulaPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="txt_diagnosticoPaciente"
    private TextField txt_diagnosticoPaciente; // Value injected by FXMLLoader

    private ObservableList<Paciente> observableList;

    public void inicializarVista(){
        if(medico != null){
            cargarPacientes(medico);
            txt_bienvenida.setText("Bienvenido, Dr. " + medico.getNombre());

        }
    }

    @FXML
    void abrirViewHistorialPacientes(ActionEvent event) {
        obtenerPacienteSeleccionado();
        app.openViewHistorialPacientesView(selectedPaciente);
    }

    @FXML
    void abrirgestionHorariosView(MouseEvent event) {
        app.openViewHorariosMedicoView(medico);
    }

    @FXML
    void crearDiagnostico(ActionEvent event) {
        String cedulaMedico = medico.getCedula();
        String cedulaPaciente = txt_cedulaPaciente.getText();
        String diagnostico = txt_diagnosticoPaciente.getText();
        try{
            medicoController.registrarDiagnostico(cedulaMedico, cedulaPaciente, diagnostico);
            mostrarAlerta("Diagnostico creado con exito", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        column_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        column_apellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        column_cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        column_correo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        column_telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        column_eps.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEps()));
        column_fechaNacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
        column_tipoSangre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));


        observableList = FXCollections.observableArrayList();
        tbl_listaPacientes.setItems(observableList);
    }

    public void cargarPacientes(Medico medico){
        LinkedList<Paciente> pacientes = medicoController.cargarListaPacientes(medico.getCedula());

        tbl_listaPacientes.getItems().clear();
        observableList.setAll(pacientes);
    }

    // Método para mostrar alertas
    public void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void obtenerPacienteSeleccionado() {
        Paciente selectedItem = tbl_listaPacientes.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.selectedPaciente = selectedItem;
        }
    }


    @FXML
    void abrirEnviarDiagnosticoView(MouseEvent event) {
        mostrarAlerta("Función no implementada", Alert.AlertType.INFORMATION);
    }
}

