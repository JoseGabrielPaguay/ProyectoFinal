package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.PacienteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PacienteViewController {

    App app;
    PacienteController pacienteController = new PacienteController();

    public void setApp(App app) {
        this.app = app;
        pacienteController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_cancelarCita"
    private Button btn_cancelarCita; // Value injected by FXMLLoader

    @FXML // fx:id="btn_solicitarCita"
    private Button btn_solicitarCita; // Value injected by FXMLLoader

        @FXML // fx:id="cbx_horaCita"
        private ComboBox<?> cbx_horaCita; // Value injected by FXMLLoader

        @FXML // fx:id="dp_fechaCita"
        private DatePicker dp_fechaCita; // Value injected by FXMLLoader

        @FXML // fx:id="tbl_listaCitas"
        private TableView<?> tbl_listaCitas; // Value injected by FXMLLoader

        @FXML // fx:id="txt_actualizarDatos"
        private Label txt_actualizarDatos; // Value injected by FXMLLoader

        @FXML // fx:id="txt_motivoCita"
        private TextField txt_motivoCita; // Value injected by FXMLLoader

        @FXML // fx:id="txt_notasPreviasCita"
        private TextField txt_notasPreviasCita; // Value injected by FXMLLoader

        @FXML
        void abrirActualizarPacienteView(MouseEvent event) {

        }

        @FXML
        void agregarCitaAction(ActionEvent event) {

        }

        @FXML
        void borrarCitaAction(ActionEvent event) {

        }

        @FXML
        void cb_horaCita(ActionEvent event) {

        }

        @FXML
        void dp_fechaCita(ActionEvent event) {

        }

        @FXML
        void tv_listaCitas(ActionEvent event) {

        }

        @FXML
        void txt_moticoCIta(ActionEvent event) {

        }

        @FXML
        void txt_notasPrevias(ActionEvent event) {

        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btn_cancelarCita != null : "fx:id=\"btn_cancelarCita\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert btn_solicitarCita != null : "fx:id=\"btn_solicitarCita\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert cbx_horaCita != null : "fx:id=\"cbx_horaCita\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert dp_fechaCita != null : "fx:id=\"dp_fechaCita\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert tbl_listaCitas != null : "fx:id=\"tbl_listaCitas\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert txt_actualizarDatos != null : "fx:id=\"txt_actualizarDatos\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert txt_motivoCita != null : "fx:id=\"txt_motivoCita\" was not injected: check your FXML file 'pacienteView.fxml'.";
            assert txt_notasPreviasCita != null : "fx:id=\"txt_notasPreviasCita\" was not injected: check your FXML file 'pacienteView.fxml'.";

    }

}


