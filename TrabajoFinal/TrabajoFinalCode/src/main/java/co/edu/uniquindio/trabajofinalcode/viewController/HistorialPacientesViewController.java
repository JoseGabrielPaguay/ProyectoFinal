package co.edu.uniquindio.trabajofinalcode.viewController;


import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.HistorialPacientesController;
import co.edu.uniquindio.trabajofinalcode.model.CitaMedica;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistorialPacientesViewController {

    App app;
    HistorialPacientesController historialPacientesController = new HistorialPacientesController();
    Paciente paciente;

    public void setApp(App app) {
        this.app = app;
        historialPacientesController.setHospital(app.getHospital());
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="column_diCita"
    private TableColumn<CitaMedica, String> column_diCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_fecha"
    private TableColumn<CitaMedica, String> column_fecha; // Value injected by FXMLLoader

    @FXML // fx:id="column_hora"
    private TableColumn<CitaMedica, String> column_hora; // Value injected by FXMLLoader

    @FXML // fx:id="column_medico"
    private TableColumn<CitaMedica, String> column_medico; // Value injected by FXMLLoader

    @FXML // fx:id="column_motivo"
    private TableColumn<CitaMedica, String> column_motivo; // Value injected by FXMLLoader

    @FXML // fx:id="column_notasPrevias"
    private TableColumn<CitaMedica, String> column_notasPrevias; // Value injected by FXMLLoader

    @FXML // fx:id="column_paciente"
    private TableColumn<CitaMedica, String> column_paciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_sala"
    private TableColumn<CitaMedica, String> column_sala; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_historialCitas"
    private TableView<CitaMedica> tbl_historialCitas; // Value injected by FXMLLoader

    private ObservableList<CitaMedica> observableList;

    public void inicializarVista(){
        if(paciente != null){
            cargarCitas(paciente);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        column_diCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCita()));
        column_fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        column_hora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora().toString()));
        column_motivo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivo()));
        column_sala.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSala().getNumeroSala()));
        column_medico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedico().getNombre()));
        column_notasPrevias.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNotasPrevias()));

        observableList = FXCollections.observableArrayList();
        tbl_historialCitas.setItems(observableList);
    }

    public void cargarCitas(Paciente paciente){
        LinkedList<CitaMedica> citas = historialPacientesController.obtenerCitasPaciente(paciente.getCedula());

        tbl_historialCitas.getItems().clear();
        observableList.setAll(citas);
    }


}
