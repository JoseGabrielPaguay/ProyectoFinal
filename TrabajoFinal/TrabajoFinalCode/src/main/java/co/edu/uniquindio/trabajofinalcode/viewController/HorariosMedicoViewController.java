package co.edu.uniquindio.trabajofinalcode.viewController;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.HorariosMedicoController;
import co.edu.uniquindio.trabajofinalcode.model.Horario;
import co.edu.uniquindio.trabajofinalcode.model.Hospital;
import co.edu.uniquindio.trabajofinalcode.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class HorariosMedicoViewController {

    App app;
    HorariosMedicoController horariosMedicoController = new HorariosMedicoController();
    Medico medico;

    public void setApp(App app) {
        this.app = app;
        horariosMedicoController.setHospital(app.getHospital());
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="btn_confirmar"
        private Button btn_confirmar; // Value injected by FXMLLoader

        @FXML // fx:id="cb_horarios"
        private ComboBox<Horario> cb_horarios; // Value injected by FXMLLoader

        @FXML
        void confirmar(ActionEvent event) {
            Horario horario = cb_horarios.getValue();
            try{
                horariosMedicoController.setHorarioMedico(horario, medico.getCedula());
            } catch (Exception e) {
                mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
                throw new RuntimeException(e);
            }
        }

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
            //LinkedList<String> horarios = horariosMedicoController.HorariosAElegirMedico();
            //cb_horarios.getItems().addAll(horarios);
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
