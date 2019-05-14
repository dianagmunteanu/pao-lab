package library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import library.services.UserService;

public class SearchByNameController {

    private UserService userService = new UserService();

    @FXML
    private TextField tf_name;

    @FXML
    public void searchByName(ActionEvent actionEvent) {
        System.out.println(tf_name.getText());
    }
}
