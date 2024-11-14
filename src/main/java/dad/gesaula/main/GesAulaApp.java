package dad.gesaula.main;

import dad.gesaula.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GesAulaApp extends Application {
    private final RootController rootController = new RootController();

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(rootController.getRoot());
        stage.setScene(scene);
        stage.setTitle("GesAula");
        stage.getIcons().add(new Image("/images/app-icon-64x64.png"));
        stage.show();
    }



}
