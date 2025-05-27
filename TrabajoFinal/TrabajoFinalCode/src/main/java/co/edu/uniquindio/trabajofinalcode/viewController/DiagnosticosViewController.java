package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;


import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.DiagnosticosController;
import co.edu.uniquindio.trabajofinalcode.model.Diagnostico;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class DiagnosticosViewController {

    App app;
    DiagnosticosController diagnosticosController = new DiagnosticosController();
    Paciente paciente;

    public void setApp(App app) {
        this.app = app;
        diagnosticosController.setHospital(app.getHospital());
    }

    private ObservableList<Diagnostico> observableList;

    public void inicializarVista(){
        if(paciente != null){
            cargarDiagnosticosPaciente(paciente);
        }
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="column_descripcionDiagnostico"
    private TableColumn<Diagnostico, String> column_descripcionDiagnostico; // Value injected by FXMLLoader

    @FXML // fx:id="column_nombreMedico"
    private TableColumn<Diagnostico, String> column_nombreMedico; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_diagnostico"
    private TableView<Diagnostico> tbl_diagnostico; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        column_nombreMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedico().getNombre()));
        column_descripcionDiagnostico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));

        observableList = FXCollections.observableArrayList();
        tbl_diagnostico.setItems(observableList);
    }

    public void cargarDiagnosticosPaciente(Paciente paciente){
        LinkedList<Diagnostico> diagnosticos = diagnosticosController.obtenerDiagnosticoPaciente(paciente);

        tbl_diagnostico.getItems().clear();
        observableList.setAll(diagnosticos);
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


