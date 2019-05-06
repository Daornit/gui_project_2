package project;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXUtil {
    private FXMLLoader loader;
    private Scene scene;
    private Stage stage;

    public JavaFXUtil(java.net.URL location) {
        this.loader = new FXMLLoader();
        loader.setLocation(location);
    }

    public void openNewStage(Parent parent, String title, int width, int height) {
        scene = new Scene(parent, width, height);
        stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public static void alertError(Stage stage, String title, String header, String context) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);

        alert.showAndWait();
    }

    public static void loadUI(BorderPane borderPane, FXMLLoader loader) {
        Parent root;
        try {
            loader.setRoot(null);
            loader.setController(null);
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            alertError((Stage) borderPane.getScene().getWindow(), "Location Error", "Set Location", "Location is wrong");
        }
    }
}