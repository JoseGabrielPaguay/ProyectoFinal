package co.edu.uniquindio.trabajofinalcode.viewController;
import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.trabajofinalcode.App;
import co.edu.uniquindio.trabajofinalcode.controller.AdministradorController;
import co.edu.uniquindio.trabajofinalcode.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AdministradorViewController {

    App app;
    AdministradorController administradorController = new AdministradorController();
    Administrador administrador;

    Paciente pacienteSeleccionado;
    Medico medicoSeleccionado;
    CitaMedica citaSeleccionada;

    public void setApp(App app) {
        this.app = app;
        administradorController.setHospital(app.getHospital());
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_acctualizarPaciente"
    private Button btn_acctualizarPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="btn_actualizarMedico"
    private Button btn_actualizarMedico; // Value injected by FXMLLoader

    @FXML // fx:id="btn_crearMedico"
    private Button btn_crearMedico; // Value injected by FXMLLoader

    @FXML // fx:id="btn_crearPaciente"
    private Button btn_crearPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="btn_crearSala"
    private Button btn_crearSala; // Value injected by FXMLLoader

    @FXML // fx:id="btn_eliminarCita"
    private Button btn_eliminarCita; // Value injected by FXMLLoader

    @FXML // fx:id="btn_eliminarMedico"
    private Button btn_eliminarMedico; // Value injected by FXMLLoader

    @FXML // fx:id="btn_eliminarPaciente"
    private Button btn_eliminarPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="cb_especialidadMedica"
    private ComboBox<EspecialidadMedica> cb_especialidadMedica; // Value injected by FXMLLoader

    @FXML // fx:id="cb_tipoSangreP"
    private ComboBox<GrupoSanguineo> cb_tipoSangreP; // Value injected by FXMLLoader

    @FXML // fx:id="column_SalaCita"
    private TableColumn<CitaMedica, String> column_SalaCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_apellidoMedico"
    private TableColumn<Medico, String> column_apellidoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_apellidoPaciente"
    private TableColumn<Paciente, String> column_apellidoPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_cedulaMedico"
    private TableColumn<Medico, String> column_cedulaMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_cedulaPaciente"
    private TableColumn<Paciente, String> column_cedulaPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_correoMedico"
    private TableColumn<Medico, String> column_correoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_correoPaciente"
    private TableColumn<Paciente, String> column_correoPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_epsPaciente"
    private TableColumn<Paciente, String> column_epsPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_especialidadMedico"
    private TableColumn<Medico, String> column_especialidadMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_fechaCita"
    private TableColumn<CitaMedica, String> column_fechaCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_fechaNacimientoMedico"
    private TableColumn<Medico, String> column_fechaNacimientoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_fechaNacimientoPaciente"
    private TableColumn<Paciente, String> column_fechaNacimientoPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_horaCita"
    private TableColumn<CitaMedica, String> column_horaCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_idCita"
    private TableColumn<CitaMedica, String> column_idCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_motivoCita"
    private TableColumn<CitaMedica, String> column_motivoCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_nombreMedico"
    private TableColumn<Medico, String> column_nombreMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_nombrePaciente"
    private TableColumn<Paciente, String> column_nombrePaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_notasPreviasCita"
    private TableColumn<CitaMedica, String> column_notasPreviasCita; // Value injected by FXMLLoader

    @FXML // fx:id="column_numeroLicenciaMedico"
    private TableColumn<Medico, String> column_numeroLicenciaMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_numeroSala"
    private TableColumn<Sala, String> column_numeroSala; // Value injected by FXMLLoader

    @FXML // fx:id="column_telefonoMedico"
    private TableColumn<Medico, String> column_telefonoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="column_telefonoPaciente"
    private TableColumn<Paciente, String> column_telefonoPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="column_tipoSangrePaciente"
    private TableColumn<Paciente, String> column_tipoSangrePaciente; // Value injected by FXMLLoader

    @FXML // fx:id="dp_fechaNacimientoMedico"
    private DatePicker dp_fechaNacimientoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="dp_fechaNacimientoP"
    private DatePicker dp_fechaNacimientoP; // Value injected by FXMLLoader

    @FXML // fx:id="rootPane"
    private TabPane rootPane; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_listaCitas"
    private TableView<CitaMedica> tbl_listaCitas; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_listaMedicos"
    private TableView<Medico> tbl_listaMedicos; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_listaPacientes"
    private TableView<Paciente> tbl_listaPacientes; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_salas"
    private TableView<Sala> tbl_salas; // Value injected by FXMLLoader

    @FXML // fx:id="txt_apellidoMedico"
    private TextField txt_apellidoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_apellidoPaciente"
    private TextField txt_apellidoPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="txt_cedulaMedico"
    private TextField txt_cedulaMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_cedulaP"
    private TextField txt_cedulaP; // Value injected by FXMLLoader

    @FXML // fx:id="txt_contrasenaMedico"
    private TextField txt_contrasenaMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_contrasenaP"
    private TextField txt_contrasenaP; // Value injected by FXMLLoader

    @FXML // fx:id="txt_correoMedico"
    private TextField txt_correoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_correoP"
    private TextField txt_correoP; // Value injected by FXMLLoader

    @FXML // fx:id="txt_epsP"
    private TextField txt_epsP; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nombreMedico"
    private TextField txt_nombreMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_nombrePaciente"
    private TextField txt_nombrePaciente; // Value injected by FXMLLoader

    @FXML // fx:id="txt_numeroLicenciaMedico"
    private TextField txt_numeroLicenciaMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_numeroSala"
    private TextField txt_numeroSala; // Value injected by FXMLLoader

    @FXML // fx:id="txt_telefonoMedico"
    private TextField txt_telefonoMedico; // Value injected by FXMLLoader

    @FXML // fx:id="txt_telefonoP"
    private TextField txt_telefonoP; // Value injected by FXMLLoader

    @FXML
    void actualizarMedicoAction(ActionEvent event) {

        String nombreNuevo = txt_nombreMedico.getText();
        String apellidoNuevo = txt_apellidoMedico.getText();
        String cedula = txt_cedulaMedico.getText();
        String correoNuevo = txt_correoMedico.getText();
        String telefonoNuevo = txt_telefonoMedico.getText();
        LocalDate fechaNacimientoNueva = dp_fechaNacimientoMedico.getValue();
        EspecialidadMedica especialidadMedicaNueva = cb_especialidadMedica.getValue();
        String numeroLicenciaNueva = txt_numeroLicenciaMedico.getText();

        try{
            administradorController.actualizarMedico(nombreNuevo, apellidoNuevo, cedula, telefonoNuevo,
                    fechaNacimientoNueva, especialidadMedicaNueva, correoNuevo, numeroLicenciaNueva);
            cargarMedicos();
            mostrarAlerta("Medico actualizado exitosamente", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }

    }

    private void listenerSelectionMedico() {
        tbl_listaMedicos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            medicoSeleccionado = newSelection;
            llenarDatosmedico();
        });
    }

    public void llenarDatosmedico(){
        obtenerMedicoSeleccionado();

        if(medicoSeleccionado != null){
            txt_nombreMedico.setText(medicoSeleccionado.getNombre());
            txt_apellidoMedico.setText(medicoSeleccionado.getApellido());
            txt_cedulaMedico.setText(medicoSeleccionado.getCedula());
            txt_correoMedico.setText(medicoSeleccionado.getCorreo());
            txt_telefonoMedico.setText(medicoSeleccionado.getTelefono());
            dp_fechaNacimientoMedico.setValue(medicoSeleccionado.getFechaNacimiento());
            cb_especialidadMedica.setValue(medicoSeleccionado.getEspecialidad());
            txt_numeroLicenciaMedico.setText(medicoSeleccionado.getNumeroLicencia());
        }
    }

    @FXML
    void actualizarPacienteAction(ActionEvent event) {

        String nombreNuevo = txt_nombrePaciente.getText();
        String apellidoNuevo = txt_apellidoPaciente.getText();
        String cedula = pacienteSeleccionado.getCedula();
        String telefonoNuevo = txt_telefonoP.getText();
        String epsNueva = txt_epsP.getText();
        LocalDate fechaNacimientoNueva = dp_fechaNacimientoP.getValue();
        GrupoSanguineo nuevoTipoSangre = cb_tipoSangreP.getValue();
        String correoNuevo = txt_correoP.getText();

        try{
            administradorController.actualizarPacienteAdmin(cedula, nombreNuevo, apellidoNuevo, epsNueva,
                    telefonoNuevo, correoNuevo, fechaNacimientoNueva, nuevoTipoSangre);
            cargarPacientes();
            mostrarAlerta("Paciente actualizado con exito", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }

    }

    private void listenerSelectionPaciente() {
        tbl_listaPacientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pacienteSeleccionado = newSelection;
            llenarDatosPaciente();
        });
    }

    public void llenarDatosPaciente(){
        obtenerPacienteSeleccionado();

        if(pacienteSeleccionado != null){
            txt_nombrePaciente.setText(pacienteSeleccionado.getNombre());
            txt_apellidoPaciente.setText(pacienteSeleccionado.getApellido());
            txt_cedulaP.setText(pacienteSeleccionado.getCedula());
            txt_correoP.setText(pacienteSeleccionado.getCorreo());
            txt_telefonoP.setText(pacienteSeleccionado.getTelefono());
            dp_fechaNacimientoP.setValue(pacienteSeleccionado.getFechaNacimiento());
            cb_tipoSangreP.setValue(pacienteSeleccionado.getTipoSangre());
        }
    }

    @FXML
    void crearMedicoAction(ActionEvent event) {

        String nombre = txt_nombreMedico.getText();
        String apellido = txt_apellidoMedico.getText();
        String cedula = txt_cedulaMedico.getText();
        String correo = txt_correoMedico.getText();
        String telefono = txt_telefonoMedico.getText();
        LocalDate fechaNacimiento = dp_fechaNacimientoMedico.getValue();
        EspecialidadMedica especialidadMedica = cb_especialidadMedica.getValue();
        String numeroLicencia = txt_numeroLicenciaMedico.getText();
        String contrasena = txt_contrasenaMedico.getText();

        try{
            administradorController.crearMedico(nombre, apellido, cedula, telefono, numeroLicencia, fechaNacimiento, especialidadMedica, correo, contrasena);
            cargarMedicos();
            mostrarAlerta("Medico creado correctamente", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }

    }

    @FXML
    void crearPacienteAction(ActionEvent event) {

        String nombre = txt_nombrePaciente.getText();
        String apellido = txt_apellidoPaciente.getText();
        String cedula = txt_cedulaP.getText();
        String correo = txt_correoP.getText();
        String telefono = txt_telefonoP.getText();
        LocalDate fechaNacimiento = dp_fechaNacimientoP.getValue();
        GrupoSanguineo grupoSanguineo = cb_tipoSangreP.getValue();
        String eps= txt_epsP.getText();
        String contrasena = txt_contrasenaP.getText();

        try{
            administradorController.crearPaciente(nombre,apellido,cedula,telefono, eps, fechaNacimiento, grupoSanguineo, correo, contrasena);
            observableListPacientes.setAll(administradorController.listaPacientes());
            mostrarAlerta("Paciente creado", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }
    }

    @FXML
    void crearSalaAction(ActionEvent event) {
        String numeroSala = txt_numeroSala.getText();
        try{
            administradorController.crearSala(numeroSala);
            cargarSalas();
            mostrarAlerta("Sala creada correctamente", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }
    }

    @FXML
    void eliminarCitaAction(ActionEvent event) {

        obtenerCitaSeleccionada();

        try{
            administradorController.eliminarCita(citaSeleccionada.getIdCita());
            cargarCitas();
            mostrarAlerta("Cita eliminada con exito", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }

    }

    @FXML
    void eliminarMedicoAction(ActionEvent event) {
        obtenerMedicoSeleccionado();
        try{
            administradorController.eliminarMedico(medicoSeleccionado.getCedula());
            cargarMedicos();
            mostrarAlerta("Medico eliminado extitosamente", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }

    }

    @FXML
    void eliminarPacienteAction(ActionEvent event) {
        obtenerPacienteSeleccionado();
        try{
            administradorController.eliminarPaciente(pacienteSeleccionado.getCedula());
            cargarPacientes();
            mostrarAlerta("Paciente eliminado correctamente", Alert.AlertType.CONFIRMATION);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        //Tabla pacientes
        column_nombrePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        column_apellidoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        column_cedulaPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        column_telefonoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        column_correoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        column_fechaNacimientoPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
        column_tipoSangrePaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoSangre().toString()));
        column_epsPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEps()));

        //Tabla citas
        column_idCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCita()));
        column_fechaCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        column_horaCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora().toString()));
        column_motivoCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivo()));
        column_notasPreviasCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNotasPrevias()));
        column_SalaCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSala().getNumeroSala()));

        //Tabla salas
        column_numeroSala.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroSala()));

        //Tabla medicos
        column_nombreMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        column_apellidoMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        column_cedulaMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        column_telefonoMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        column_fechaNacimientoMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaNacimiento().toString()));
        column_especialidadMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecialidad().toString()));
        column_numeroLicenciaMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroLicencia()));
        column_correoMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));


        observableListPacientes = FXCollections.observableArrayList();
        tbl_listaPacientes.setItems(observableListPacientes);
        observableListMedicos = FXCollections.observableArrayList();
        tbl_listaMedicos.setItems(observableListMedicos);
        observableListCitas = FXCollections.observableArrayList();
        tbl_listaCitas.setItems(observableListCitas);
        observableListSalas = FXCollections.observableArrayList();
        tbl_salas.setItems(observableListSalas);

        observableListGrupoSanguineo = FXCollections.observableArrayList();
        cb_tipoSangreP.setItems(observableListGrupoSanguineo);

        observableListEspecialidadMedica = FXCollections.observableArrayList();
        cb_especialidadMedica.setItems(observableListEspecialidadMedica);

        listenerSelectionPaciente();
        listenerSelectionMedico();

    }

    private ObservableList<GrupoSanguineo> observableListGrupoSanguineo;

    private ObservableList<EspecialidadMedica> observableListEspecialidadMedica;


    public void cargarComboBoxGrupoSanguineo(){
        LinkedList<GrupoSanguineo> lista = administradorController.obtenerGruposSanguineos();

        cb_tipoSangreP.getItems().clear();
        observableListGrupoSanguineo.setAll(lista);
    }

    public void cargarComboBoxEspecialidadMedica(){
        LinkedList<EspecialidadMedica> lista = administradorController.obtenerEspecialidadesMedicas();

        cb_especialidadMedica.getItems().clear();
        observableListEspecialidadMedica.setAll(lista);
    }

    // Método para obtener el objeto seleccionado de la tabla de pacientes
    public void obtenerPacienteSeleccionado() {
        Paciente selectedItem = tbl_listaPacientes.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.pacienteSeleccionado = selectedItem;
        }
    }

    // Método para obtener el objeto seleccionado de la tabla de medicos
    public void obtenerMedicoSeleccionado() {
        Medico selectedItem = tbl_listaMedicos.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.medicoSeleccionado = selectedItem;
        }
    }

    // Método para obtener el objeto seleccionado de la tabla de citas
    public void obtenerCitaSeleccionada() {
        CitaMedica selectedItem = tbl_listaCitas.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.citaSeleccionada = selectedItem;
        }
    }

    // Método para mostrar alertas
    public void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void inicializarVista(){
        cargarCitas();
        cargarMedicos();
        cargarSalas();
        cargarPacientes();
        cargarComboBoxGrupoSanguineo();
        cargarComboBoxEspecialidadMedica();

    }

    private ObservableList<CitaMedica> observableListCitas;
    private ObservableList<Medico> observableListMedicos;
    private ObservableList<Paciente> observableListPacientes;
    private ObservableList<Sala> observableListSalas;

    public void cargarCitas(){
        LinkedList<CitaMedica> citasMedicas = administradorController.listaCitas();

        tbl_listaCitas.getItems().clear();
        observableListCitas.setAll(citasMedicas);
    }

    public void cargarMedicos(){
        LinkedList<Medico> medicos = administradorController.listaMedicos();

        tbl_listaMedicos.getItems().clear();
        observableListMedicos.setAll(medicos);
    }

    public void cargarPacientes(){
        LinkedList<Paciente> pacientes = administradorController.listaPacientes();

        tbl_listaPacientes.getItems().clear();
        observableListPacientes.setAll(pacientes);
    }

    public void cargarSalas(){
        LinkedList<Sala> salas = administradorController.listaSala();

        tbl_salas.getItems().clear();
        observableListSalas.setAll(salas);
    }


}





