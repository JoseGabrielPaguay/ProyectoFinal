package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.EnviarCodigoContrasenaController;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EnviarCodigoContrasenaViewController {

    App app;
    EnviarCodigoContrasenaController enviarCodigoContrasenaController = new EnviarCodigoContrasenaController();

    public void setApp(App app) {
        this.app = app;
        enviarCodigoContrasenaController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_correoRecuperacion"
    private Button btn_correoRecuperacion; // Value injected by FXMLLoader

    @FXML // fx:id="rootPane"
    private AnchorPane rootPane; // Value injected by FXMLLoader

    @FXML // fx:id="txt_correo"
    private TextField txt_correo; // Value injected by FXMLLoader

    @FXML
    void openViewIngresoCodigo(ActionEvent event) {
        String correo = txt_correo.getText();
        try{
            enviarCodigoContrasenaController.mandarCodigoCorreo(correo);
            mostrarAlerta("Su codigo de validación fue enviado correctamente", Alert.AlertType.CONFIRMATION);
            enviarCodigoContrasenaController.obtenerUsuario(correo);
            Usuario usuario = enviarCodigoContrasenaController.obtenerUsuario(correo);
            app.openViewCambiarContrasenaView(usuario);
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


