package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.RegistrarseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class RegistrarseViewController {

    App app;
    RegistrarseController registrarseController = new RegistrarseController();

    public void setApp(App app) {
        this.app = app;
        registrarseController.setHospital(app.getHospital());
    }

    @FXML
    private AnchorPane rootPane;

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

    @FXML // fx:id="txt_contrasena"
    private PasswordField txt_contrasena; // Value injected by FXMLLoader

    @FXML // fx:id="txt_correo"
    private TextField txt_correo; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nombre"
    private TextField txt_nombre; // Value injected by FXMLLoader

    @FXML // fx:id="txt_telefono"
    private TextField txt_telefono; // Value injected by FXMLLoader

    @FXML
    void registrarAdmin(ActionEvent event) {
        String nombre = txt_nombre.getText();
        String apellido = txt_apellidos.getText();
        String telefono = txt_telefono.getText();
        String cedula = txt_cedula.getText();
        String correo = txt_correo.getText();
        String contrasena = txt_contrasena.getText();
        LocalDate fechaNacimiento = dp_fechaNacimiento.getValue();

        registrarseController.registrarAdmin(nombre, apellido, cedula, correo, telefono, fechaNacimiento, contrasena);
        mostrarAlerta("Admnistrador registrado correctamente", Alert.AlertType.CONFIRMATION);

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_registrar != null : "fx:id=\"btn_registrar\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert dp_fechaNacimiento != null : "fx:id=\"dp_fechaNacimiento\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_apellidos != null : "fx:id=\"txt_apellidos\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_cedula != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_contrasena != null : "fx:id=\"txt_contraseña\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'registarseView.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'registarseView.fxml'.";

    }

    // Método para mostrar alertas
    public void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}

