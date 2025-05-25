package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.model.Diagnostico;
import co.edu.uniquindio.trabajofinalcode.controller.DiagnosticosController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DiagnosticosViewController {
    App app;
    DiagnosticosController diagnosticosController = new DiagnosticosController();

    public void setApp(App app) {
        this.app = app;
        diagnosticosController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="column_descripcionDiagnostico"
    private TableColumn<?, ?> column_descripcionDiagnostico; // Value injected by FXMLLoader

    @FXML // fx:id="column_nombrePaciente"
    private TableColumn<?, ?> column_nombrePaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_tratamientoPaciente"
    private TableColumn<?, ?> column_tratamientoPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_diagnostico"
    private TableView<?> tbl_diagnostico; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    assert column_descripcionDiagnostico != null : "fx:id=\"column_descripcionDiagnostico\" was not injected: check your FXML file 'diagnosticosView.fxml'.";
    assert column_nombrePaciente != null : "fx:id=\"column_nombrePaciente\" was not injected: check your FXML file 'diagnosticosView.fxml'.";
    assert column_tratamientoPaciente != null : "fx:id=\"column_tratamientoPaciente\" was not injected: check your FXML file 'diagnosticosView.fxml'.";
    assert tbl_diagnostico != null : "fx:id=\"tbl_diagnostico\" was not injected: check your FXML file 'diagnosticosView.fxml'.";
    }

}
