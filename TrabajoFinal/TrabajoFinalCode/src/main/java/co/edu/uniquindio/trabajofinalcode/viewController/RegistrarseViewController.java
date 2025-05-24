package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class RegistrarseViewController {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_registrar"
    private Button btn_registrar; // Value injected by FXMLLoader

    @FXML // fx:id="dp_fechaNacimiento"
    private DatePicker dp_fechaNacimiento; // Value injected by FXMLLoader

    @FXML // fx:id="txt_apellidos"
    private TextField txt_apellidos; // Value injected by FXMLLoader

    @FXML // fx:id="txt_cedula"
    private TextField txt_cedula; // Value injected by FXMLLoader

    @FXML // fx:id="txt_contraseña"
    private PasswordField txt_contraseña; // Value injected by FXMLLoader

    @FXML // fx:id="txt_correo"
    private TextField txt_correo; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nombre"
    private TextField txt_nombre; // Value injected by FXMLLoader

    @FXML // fx:id="txt_telefono"
    private TextField txt_telefono; // Value injected by FXMLLoader

    @FXML
    void registrarAdmin(ActionEvent event) {

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_registrar != null : "fx:id=\"btn_registrar\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert dp_fechaNacimiento != null : "fx:id=\"dp_fechaNacimiento\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_apellidos != null : "fx:id=\"txt_apellidos\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_cedula != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_contraseña != null : "fx:id=\"txt_contraseña\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'registarseView.fxml'.";

    }
}

