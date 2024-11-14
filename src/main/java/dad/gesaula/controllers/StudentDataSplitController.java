package dad.gesaula.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentDataSplitController implements Initializable {


    public StudentDataSplitController() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/studentDataSplitView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private DatePicker birthStudentDatePicker;

    @FXML
    private CheckBox retakeYearCheckBox;

    @FXML
    private GridPane root;

    @FXML
    private ComboBox<?> sexComboBox;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField studentSurnameTextField;

    public GridPane getRoot() {
        return root;
    }
}
