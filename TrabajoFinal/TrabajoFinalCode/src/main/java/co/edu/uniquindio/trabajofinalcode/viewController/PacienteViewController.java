package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.PacienteController;
import co.edu.uniquindio.trabajofinalcode.model.CitaMedica;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PacienteViewController {

    App app;
    PacienteController pacienteController = new PacienteController();
    Paciente paciente;
    CitaMedica selectedCita;

    public void setApp(App app) {
        this.app = app;
        pacienteController.setHospital(app.getHospital());
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_cancelarCita"
        private Button btn_cancelarCita; // Value injected by FXMLLoader

        @FXML // fx:id="btn_solicitarCita"
        private Button btn_solicitarCita; // Value injected by FXMLLoader

        @FXML // fx:id="cbx_horaCita"
        private ComboBox<String> cbx_horaCita; // Value injected by FXMLLoader

        @FXML // fx:id="column_fecha"
        private TableColumn<CitaMedica, String> column_fecha; // Value injected by FXMLLoader

        @FXML // fx:id="column_hora"
        private TableColumn<CitaMedica, String> column_hora; // Value injected by FXMLLoader

        @FXML // fx:id="column_id"
        private TableColumn<CitaMedica, String> column_id; // Value injected by FXMLLoader

        @FXML // fx:id="column_motivo"
        private TableColumn<CitaMedica, String> column_motivo; // Value injected by FXMLLoader

        @FXML // fx:id="column_notasPrevias"
        private TableColumn<CitaMedica, String> column_notasPrevias; // Value injected by FXMLLoader

        @FXML // fx:id="column_sala"
        private TableColumn<CitaMedica, String> column_sala; // Value injected by FXMLLoader

        @FXML // fx:id="dp_fechaCita"
        private DatePicker dp_fechaCita; // Value injected by FXMLLoader

        @FXML // fx:id="rootPane"
        private AnchorPane rootPane; // Value injected by FXMLLoader

        @FXML // fx:id="tbl_listaCitas"
        private TableView<CitaMedica> tbl_listaCitas; // Value injected by FXMLLoader

        @FXML // fx:id="txt_actualizarDatos"
        private Label txt_actualizarDatos; // Value injected by FXMLLoader

        @FXML // fx:id="txt_bienvenido"
        private Label txt_bienvenido; // Value injected by FXMLLoader

        @FXML // fx:id="txt_motivoCita"
        private TextField txt_motivoCita; // Value injected by FXMLLoader

        @FXML // fx:id="txt_notasPreviasCita"
        private TextField txt_notasPreviasCita; // Value injected by FXMLLoader

        @FXML // fx:id="txt_verDiagnosticos"
        private Label txt_verDiagnosticos; // Value injected by FXMLLoader

    private ObservableList<CitaMedica> observableList;

    public void inicializarVista(){
        if(paciente != null){
            cargarCitas(paciente);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        column_fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        column_hora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora()));
        column_id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCita()));
        column_motivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivo()));
        column_sala.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSala().getNumeroSala()));
        column_notasPrevias.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNotasPrevias()));

        observableList = FXCollections.observableArrayList();
        tbl_listaCitas.setItems(observableList);
        
        LinkedList<String> horas = pacienteController.getHorarios();
        cbx_horaCita.getItems().addAll(horas);

    }

    @FXML
    void abrirActualizarPacienteView(MouseEvent event) {

        app.openViewActualizarPacienteView(paciente);

    }

    @FXML
    void abrirDiagnosticosView(MouseEvent event) {

        app.openViewDiagnosticosView(paciente);

    }

    @FXML
    void agregarCitaAction(ActionEvent event) {
        LocalDate fecha = dp_fechaCita.getValue();
        String hora = cbx_horaCita.getValue();
        String notasPrevias = txt_notasPreviasCita.getText();
        String motivo = txt_motivoCita.getText();
        try{
            pacienteController.registrarCita(fecha, hora, motivo, notasPrevias, paciente.getCedula());
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }
    }

    // Método para obtener el objeto seleccionado de la tabla
    public void obtenerCitaSeleccionada() {
        CitaMedica selectedItem = tbl_listaCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.selectedCita = selectedItem;
        }
    }

        @FXML
        void borrarCitaAction(ActionEvent event) throws Exception{
            if (selectedCita == null){
                throw new Exception("Seleccione una cita valida");
            }
            pacienteController.eliminarCita(selectedCita.getIdCita());
        }

        public void cargarCitas(Paciente paciente){
            LinkedList<CitaMedica> citasMedicas = pacienteController.obtenerListaCitasPacinete(paciente.getCedula());

            tbl_listaCitas.getItems().clear();
            observableList.setAll(citasMedicas);
        }

        public void cargarHorasCitas(){
        pacienteController.getHorarios();
        }


    // Método para mostrar alertas
    public void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    }




