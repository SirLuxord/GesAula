package dad.gesaula.controllers;

import dad.gesaula.ui.model.Grupo;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GroupTabController implements Initializable {

    private ObjectProperty<Grupo> grupo = new SimpleObjectProperty<>();

    public GroupTabController() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/groupTabView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        examLabel.textProperty().bind(examSlider.valueProperty().asString("%.0f").concat("%"));
        practiceLabel.textProperty().bind(practiceSlider.valueProperty().asString("%.0f").concat("%"));
        attitudeLabel.textProperty().bind(attitudeSlider.valueProperty().asString("%.0f").concat("%"));

        grupo.addListener((ObservableValue<? extends Grupo> o, Grupo ov, Grupo nv) -> {
            if (ov != null){
                denominationTextField.textProperty().unbindBidirectional(ov.denominacionProperty());
                schoolBeginsDatePicker.valueProperty().unbindBidirectional(ov.iniCursoProperty());
                schoolEndsDatePicker.valueProperty().unbindBidirectional(ov.finCursoProperty());
                examSlider.valueProperty().unbindBidirectional(ov.getPesos().examenesProperty());
                practiceSlider.valueProperty().unbindBidirectional(ov.getPesos().practicasProperty());
                attitudeSlider.valueProperty().unbindBidirectional(ov.getPesos().actitudProperty());
            }

            if (nv != null){
                denominationTextField.textProperty().bindBidirectional(nv.denominacionProperty());
                schoolBeginsDatePicker.valueProperty().bindBidirectional(nv.iniCursoProperty());
                schoolEndsDatePicker.valueProperty().bindBidirectional(nv.finCursoProperty());
                examSlider.valueProperty().bindBidirectional(nv.getPesos().examenesProperty());
                practiceSlider.valueProperty().bindBidirectional(nv.getPesos().practicasProperty());
                attitudeSlider.valueProperty().bindBidirectional(nv.getPesos().actitudProperty());
            }
        });
    }

    @FXML
    private Label attitudeLabel;

    @FXML
    private Slider attitudeSlider;

    @FXML
    private TextField denominationTextField;

    @FXML
    private Label examLabel;

    @FXML
    private Slider examSlider;

    @FXML
    private Label practiceLabel;

    @FXML
    private Slider practiceSlider;

    @FXML
    private GridPane root;

    @FXML
    private DatePicker schoolBeginsDatePicker;

    @FXML
    private DatePicker schoolEndsDatePicker;

    public GridPane getRoot() {
        return root;
    }

    public Grupo getGrupo() {
        return grupo.get();
    }

    public ObjectProperty<Grupo> grupoProperty() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo.set(grupo);
    }
}
