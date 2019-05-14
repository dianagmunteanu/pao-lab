package library.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import library.controller.dto.UserDto;
import library.services.UserService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchByIdController implements Initializable {

    private UserService userService = new UserService();
    private List<UserDto> filteredList = new ArrayList<>();

    @FXML
    private TextField tf_id;

    @FXML
    private TableView<UserDto> table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

    @FXML
    void displayById(ActionEvent event) {

        if (tf_id != null && !tf_id.getText().isEmpty()) {
            String user = userService.getUserNameById(tf_id.getText());
            filteredList.clear();
            filteredList.add(new UserDto(tf_id.getText(), user));
            table.getItems().clear();
            table.getItems().addAll(filteredList);
        }
    }



}
