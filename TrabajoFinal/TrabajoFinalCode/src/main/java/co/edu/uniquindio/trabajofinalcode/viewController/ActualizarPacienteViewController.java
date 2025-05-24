package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.ActualizarPacienteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ActualizarPacienteViewController {
    
    App app;
    ActualizarPacienteController actualizarPacienteController = new ActualizarPacienteController();

    public void setApp(App app) {
        this.app = app;
        actualizarPacienteController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_actualizar"
    private Button btn_actualizar; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nuevaEps"
    private TextField txt_nuevaEps; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nuevoApellido"
    private TextField txt_nuevoApellido; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nuevoCorreo"
    private TextField txt_nuevoCorreo; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nuevoNombre"
    private TextField txt_nuevoNombre; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nuevoTelefono"
    private TextField txt_nuevoTelefono; // Value injected by FXMLLoader

    @FXML
    void actualizarPacienteAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
            assert btn_actualizar != null : "fx:id=\"btn_actualizar\" was not injected: check your FXML file 'actualizarPacienteView.fxml'.";
            assert txt_nuevaEps != null : "fx:id=\"txt_nuevaEps\" was not injected: check your FXML file 'actualizarPacienteView.fxml'.";
            assert txt_nuevoApellido != null : "fx:id=\"txt_nuevoApellido\" was not injected: check your FXML file 'actualizarPacienteView.fxml'.";
            assert txt_nuevoCorreo != null : "fx:id=\"txt_nuevoCorreo\" was not injected: check your FXML file 'actualizarPacienteView.fxml'.";
            assert txt_nuevoNombre != null : "fx:id=\"txt_nuevoNombre\" was not injected: check your FXML file 'actualizarPacienteView.fxml'.";
            assert txt_nuevoTelefono != null : "fx:id=\"txt_nuevoTelefono\" was not injected: check your FXML file 'actualizarPacienteView.fxml'.";

    }

}


