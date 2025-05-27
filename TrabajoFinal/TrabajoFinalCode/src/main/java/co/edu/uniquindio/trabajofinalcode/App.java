package co.edu.uniquindio.trabajofinalcode;

import co.edu.uniquindio.trabajofinalcode.model.*;
import co.edu.uniquindio.trabajofinalcode.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {

    private Stage primaryStage;
    Hospital hospital = new Hospital("UQ");


    public Hospital getHospital() {
        return hospital;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("InicioSesion");
        openViewIniciarSeision();

    }


    public void openViewIniciarSeision() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("iniciarSesionView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            InicioSesionViewController inicioSesionViewController = loader.getController();
            inicioSesionViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewRegistrarseView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("registrarseView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            RegistrarseViewController registrarseViewController = loader.getController();
            registrarseViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewPacienteView(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("pacienteView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            PacienteViewController pacienteViewController = loader.getController();
            pacienteViewController.setApp(this);
            pacienteViewController.setPaciente(paciente);
            pacienteViewController.inicializarVista();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewMedicoView(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("medicoView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            MedicoViewController medicoViewController = loader.getController();
            medicoViewController.setApp(this);
            medicoViewController.setMedico(medico);
            medicoViewController.inicializarVista();


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewCambiarContrasenaView(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("cambiarContrasenaView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            CambiarContrasenaViewController cambiarContrasenaViewController = loader.getController();
            cambiarContrasenaViewController.setApp(this);
            cambiarContrasenaViewController.setUsuario(usuario);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewHorariosMedicoView(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("horariosMedicoView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            HorariosMedicoViewController horariosMedicoViewController = loader.getController();
            horariosMedicoViewController.setApp(this);
            horariosMedicoViewController.setMedico(medico);
            horariosMedicoViewController.inicializar();


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewActualizarPacienteView(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("actualizarPacienteView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            ActualizarPacienteViewController actualizarPacienteViewController = loader.getController();
            actualizarPacienteViewController.setApp(this);
            actualizarPacienteViewController.setPaciente(paciente);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewAdministradorView(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("administradorView.fxml"));
            Parent rootLayout = loader.load();

            AdministradorViewController administradorViewController = loader.getController();
            administradorViewController.setApp(this);
            administradorViewController.setAdministrador(administrador);
            administradorViewController.inicializarVista();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openViewDiagnosticosView(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("diagnosticosView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            DiagnosticosViewController diagnosticosViewController = loader.getController();
            diagnosticosViewController.setApp(this);
            diagnosticosViewController.setPaciente(paciente);
            diagnosticosViewController.inicializarVista();


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewHistorialPacientesView(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("historialPacientelView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            HistorialPacientesViewController historialPacientesViewController = loader.getController();
            historialPacientesViewController.setApp(this);
            historialPacientesViewController.setPaciente(paciente);
            historialPacientesViewController.inicializarVista();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openViewEnviarCodigoContrasenaView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("enviarCodigoContrasenaView.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            EnviarCodigoContrasenaViewController enviarCodigoContrasenaViewController = loader.getController();
            enviarCodigoContrasenaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch();
    }

}