package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.InicioSesionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InicioSesionViewController {

    App app;
    InicioSesionController inicioSesionController = new InicioSesionController();

    public void setApp(App app){
        this.app = app;
        inicioSesionController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_iniciarSesion"
    private Button btn_iniciarSesion; // Value injected by FXMLLoader

    @FXML // fx:id="label_olvidasteLaContrasenia"
    private Label label_olvidasteLaContrasenia; // Value injected by FXMLLoader

    @FXML // fx:id="txt_contrasenia"
    private PasswordField txt_contrasenia; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nombreUsuario"
    private TextField txt_nombreUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="txt_registarse"
    private Label txt_registarse; // Value injected by FXMLLoader

    @FXML
    void abrirOlvidasteContraseniaView(MouseEvent event) {

    }

    @FXML
    void abrirRegistrarseView(MouseEvent event) {

    }

    @FXML
    void iniciarSesioAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_iniciarSesion != null : "fx:id=\"btn_iniciarSesion\" was not injected: check your FXML file 'iniciarSesionView.fxml'.";
        assert label_olvidasteLaContrasenia != null : "fx:id=\"label_olvidasteLaContrasenia\" was not injected: check your FXML file 'iniciarSesionView.fxml'.";
        assert txt_contrasenia != null : "fx:id=\"txt_contrasenia\" was not injected: check your FXML file 'iniciarSesionView.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'iniciarSesionView.fxml'.";
        assert txt_registarse != null : "fx:id=\"txt_registarse\" was not injected: check your FXML file 'iniciarSesionView.fxml'.";

    }

}



