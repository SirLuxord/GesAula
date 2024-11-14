package dad.gesaula.controllers;

import dad.gesaula.ui.model.Grupo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private GroupTabController groupTabController = new GroupTabController();
    private StudentTabController studentTabController = new StudentTabController();
    private StringProperty groupfile = new SimpleStringProperty();

    public RootController() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupTab.setContent(groupTabController.getRoot());
        studentTab.setContent(studentTabController.getRoot());
        groupfile.bind(fileNameTextField.textProperty().concat(".xml"));


    }

    // View

    @FXML
    private BorderPane Root;

    @FXML
    private TextField fileNameTextField;

    @FXML
    private Tab groupTab;

    @FXML
    private Tab studentTab;

    @FXML
    void onNewAction(ActionEvent event) {
        groupTabController.setGrupo(new Grupo());

    }

    @FXML
    void onSaveButton(ActionEvent event) {
        try {
            groupTabController.getGrupo().save(new File(groupfile.get()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BorderPane getRoot() {
        return Root;
    }



}
