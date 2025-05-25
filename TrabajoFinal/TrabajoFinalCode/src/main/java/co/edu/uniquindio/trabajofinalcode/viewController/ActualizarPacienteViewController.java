package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.ActualizarPacienteController;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ActualizarPacienteViewController {
    
    App app;
    ActualizarPacienteController actualizarPacienteController = new ActualizarPacienteController();
    Paciente paciente;


    public void setApp(App app) {
        this.app = app;
        actualizarPacienteController.setHospital(app.getHospital());
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
        String nombre = txt_nuevoNombre.getText();
        String apellido = txt_nuevoApellido.getText();
        String eps = txt_nuevaEps.getText();
        String telefono = txt_nuevoTelefono.getText();
        String correo = txt_nuevoCorreo.getText();

        try{
            actualizarPacienteController.actualizarPaciente(paciente.getCedula(), nombre, apellido, eps, telefono, correo);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
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


