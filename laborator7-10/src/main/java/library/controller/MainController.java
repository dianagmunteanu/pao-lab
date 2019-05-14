package library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {

    @FXML
    private MenuItem mi_byName;

    @FXML
    private MenuItem mi_byId;

    @FXML
    private Pane mainPane;

    @FXML
    void searchById(ActionEvent event) {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add((Pane) FXMLLoader.load(getClass().getResource("/views/search_by_id.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchByName(ActionEvent event) {
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add((Pane) FXMLLoader.load(getClass().getResource("/views/search_by_name.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
