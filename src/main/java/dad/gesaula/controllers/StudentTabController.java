package dad.gesaula.controllers;

import dad.gesaula.ui.model.Alumno;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentTabController implements Initializable {

    private ListProperty<Alumno> alumnos = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ObjectProperty<Alumno> selectedAlumno = new SimpleObjectProperty<>();

    public StudentTabController() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/studentTabView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentTableView.itemsProperty().bind(alumnos);
        nameColumn.setCellValueFactory(v -> v.getValue().nombreProperty());
        surnameColumn.setCellValueFactory(v -> v.getValue().apellidosProperty());
        birthdareColumn.setCellValueFactory(v -> v.getValue().fechaNacimientoProperty());
        selectedAlumno.bind(studentTableView.getSelectionModel().selectedItemProperty());
    }

    @FXML
    private TableColumn<Alumno, LocalDate> birthdareColumn;

    @FXML
    private TableColumn<Alumno, String> nameColumn;

    @FXML
    private SplitPane root;

    @FXML
    private BorderPane studentSelectionPane;

    @FXML
    private TableView<Alumno> studentTableView;

    @FXML
    private TableColumn<Alumno, String> surnameColumn;

    @FXML
    void onDeleteAction(ActionEvent event) {

        alumnos.remove(selectedAlumno.get());
    }

    @FXML
    void onNewAction(ActionEvent event) {
        Alumno alumno = new Alumno();
        alumno.setNombre("Sin nombre");
        alumno.setApellidos("Sin apellidos");
        alumnos.add(alumno);



    }

    public SplitPane getRoot() {
        return root;
    }



}
