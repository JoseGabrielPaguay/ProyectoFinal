package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.CambiarContrasenaController;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class CambiarContrasenaViewController {

        App app;
        CambiarContrasenaController cambiarContrasenaController = new CambiarContrasenaController();
        Usuario usuario;

        public void setApp(App app) {
        this.app = app;
        cambiarContrasenaController.setHospital(app.getHospital());
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }

        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_aceptar"
        private Button btn_aceptar; // Value injected by FXMLLoader

        @FXML // fx:id="rootPane"
        private AnchorPane rootPane; // Value injected by FXMLLoader

        @FXML // fx:id="txt_codigoVerificacion"
        private TextField txt_codigoVerificacion; // Value injected by FXMLLoader

        @FXML // fx:id="txt_contrasenaNueva"
        private TextField txt_contrasenaNueva; // Value injected by FXMLLoader

        @FXML
        void cambiarContrasenaAction(ActionEvent event) {
                String contrasenaNueva = txt_contrasenaNueva.getText();
                String codigoActivacion = txt_codigoVerificacion.getText();
                try{
                        cambiarContrasenaController.cambiarContrasena(codigoActivacion, contrasenaNueva, usuario.getCorreo());
                        mostrarAlerta("Contraseña cambiada exitosamente", Alert.AlertType.CONFIRMATION);
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



