package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.IngresarCodigoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class IngresarCodigoViewController {

    App app;
    IngresarCodigoController ingresarCodigoController = new IngresarCodigoController();

    public void setApp(App app) {
        this.app = app;
        ingresarCodigoController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_aceptar"
        private Button btn_aceptar; // Value injected by FXMLLoader

        @FXML // fx:id="txt_codigoVerificacion"
        private TextField txt_codigoVerificacion; // Value injected by FXMLLoader

        @FXML // fx:id="txt_contrasenaNueva"
        private TextField txt_contrasenaNueva; // Value injected by FXMLLoader

        @FXML
        void cambiarContrasenaAction(ActionEvent event) {

        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btn_aceptar != null : "fx:id=\"btn_aceptar\" was not injected: check your FXML file 'ingresarCodigoView.fxml'.";
            assert txt_codigoVerificacion != null : "fx:id=\"txt_codigoVerificacion\" was not injected: check your FXML file 'ingresarCodigoView.fxml'.";
            assert txt_contrasenaNueva != null : "fx:id=\"txt_contrasenaNueva\" was not injected: check your FXML file 'ingresarCodigoView.fxml'.";

        }

}
