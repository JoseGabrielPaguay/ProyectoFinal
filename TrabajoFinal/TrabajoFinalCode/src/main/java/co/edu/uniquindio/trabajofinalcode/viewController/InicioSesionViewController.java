package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.InicioSesionController;
import co.edu.uniquindio.trabajofinalcode.model.Administrador;
import co.edu.uniquindio.trabajofinalcode.model.Medico;
import co.edu.uniquindio.trabajofinalcode.model.Paciente;
import co.edu.uniquindio.trabajofinalcode.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    @FXML // fx:id="txt_correo"
    private TextField txt_correo; // Value injected by FXMLLoader

    @FXML // fx:id="txt_registarse"
    private Label txt_registarse; // Value injected by FXMLLoader

    @FXML
    void abrirOlvidasteContraseniaView(MouseEvent event) {
        app.openViewRecuperarContrasenaView();
    }

    @FXML
    void abrirRegistrarseView(MouseEvent event) {
        app.openViewRegistrarseView();
    }

    @FXML
    void iniciarSesioAction(ActionEvent event) {
        String contrasena = txt_contrasenia.getText();
        String correo = txt_correo.getText();
        Usuario usuario = inicioSesionController.obtenerUsuarioCorreo(correo);
        if(usuario instanceof Paciente){
            try{
                if(inicioSesionController.iniciarSesion(correo, contrasena)){
                    app.openViewPacienteView((Paciente) usuario);
                }
            } catch (Exception e) {
                mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
                throw new RuntimeException(e);
            }
        }
        if(usuario instanceof Medico){
            try{
                if(inicioSesionController.iniciarSesion(correo, contrasena)){
                    app.openViewMedicoView((Medico) usuario);
                }
            } catch (Exception e) {
                mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
                throw new RuntimeException(e);
            }
        }
        if(usuario instanceof Administrador){
            try{
                if(inicioSesionController.iniciarSesion(correo, contrasena)){
                    app.openViewAdministradorView((Administrador) usuario);
                }
            } catch (Exception e) {
                mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
                throw new RuntimeException(e);
            }
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



