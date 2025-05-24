package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.HorariosMedicoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class HorariosMedicoViewController {

    App app;
    HorariosMedicoController horariosMedicoController = new HorariosMedicoController();

    public void setApp(App app) {
        this.app = app;
        horariosMedicoController.setHospital(app.getHospital());
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_confirmar"
        private Button btn_confirmar; // Value injected by FXMLLoader

        @FXML // fx:id="cb_horarios"
        private ComboBox<?> cb_horarios; // Value injected by FXMLLoader

        @FXML
        void confirmar(ActionEvent event) {

        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            assert btn_confirmar != null : "fx:id=\"btn_confirmar\" was not injected: check your FXML file 'horariosMedicoView.fxml'.";
            assert cb_horarios != null : "fx:id=\"cb_horarios\" was not injected: check your FXML file 'horariosMedicoView.fxml'.";

        }

}
