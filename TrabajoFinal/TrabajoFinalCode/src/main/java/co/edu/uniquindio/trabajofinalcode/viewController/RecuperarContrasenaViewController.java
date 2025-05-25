package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.RecuperarContrasenaController;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class RecuperarContrasenaViewController {

        App app;
        RecuperarContrasenaController recuperarContrasenaController = new RecuperarContrasenaController();

        public void setApp(App app) {
                this.app = app;
                recuperarContrasenaController.setHospital(app.getHospital());
        }

        @FXML
        private AnchorPane rootPane;

        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_correoRecuperacion"
        private Button btn_correoRecuperacion; // Value injected by FXMLLoader

        @FXML // fx:id="txt_correo"
        private TextField txt_correo; // Value injected by FXMLLoader

        @FXML
        void openViewIngresoCodigo(ActionEvent event) {
                String correo = txt_correo.getText();
                Usuario usuario = recuperarContrasenaController.obtenerUsuarioCorreo(correo);
                String codigoValidacion = UUID.randomUUID().toString();
                recuperarContrasenaController.enviarCorreo(correo, "Codigo de verificación", "Este es su codigo de verificación: " + codigoValidacion);
                usuario.setCodigoValidacion(codigoValidacion);
                app.openViewIngresarCodigoView(usuario);
                cerrarVentana();
        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
                assert btn_correoRecuperacion != null : "fx:id=\"btn_correoRecuperacion\" was not injected: check your FXML file 'recuperarContraseniaView.fxml'.";
                assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'recuperarContraseniaView.fxml'.";

        }

        private void cerrarVentana() {
                Stage stage = (Stage) rootPane.getScene().getWindow();
                stage.close();
        }

}
