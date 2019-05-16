package library.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import library.controller.dto.UserDto;
import library.services.UserService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchByIdController implements Initializable {

    private UserService userService = new UserService();
    private List<UserDto> filteredList = new ArrayList<>();
    public static UserDto selectedUser = null;

    @FXML
    private TextField searchByIdInput;

    @FXML
    private TableView<UserDto> table;

    @FXML
    private Pane edit_pane;

    @FXML
    private TextField address;

    @FXML
    private TableColumn<UserDto, Boolean> editButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filteredList.clear();
        filteredList.addAll(userService.getAllUsers());
        table.getItems().clear();
        table.getItems().addAll(filteredList);
        edit_pane.setVisible(false);
        editButton.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<UserDto, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<UserDto, Boolean> p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });

        //Adding the Button to the cell
        editButton.setCellFactory(
                new Callback<TableColumn<UserDto, Boolean>, TableCell<UserDto, Boolean>>() {

                    @Override
                    public TableCell<UserDto, Boolean> call(TableColumn<UserDto, Boolean> p) {
                        return new ButtonCell();
                    }

                });

    }

    @FXML
    void displayById(ActionEvent event) {
        if (searchByIdInput != null && !searchByIdInput.getText().isEmpty()) {
            UserDto user = userService.getUserById(searchByIdInput.getText());
            if (user != null) {
                filteredList.clear();
                filteredList.add(user);
                table.getItems().clear();
                table.getItems().addAll(filteredList);
            } else {
                clearTable();
            }
        } else {
            clearTable();
        }
    }

    private void clearTable() {
        filteredList.clear();
        filteredList.addAll(userService.getAllUsers());
        table.getItems().clear();
        table.getItems().addAll(filteredList);
    }

    @FXML
    void saveNewAddress(ActionEvent event) {
        String newAddress = address.getText();
        userService.updateUser(selectedUser.id.getValue(), newAddress);
        filteredList.clear();
        filteredList.addAll(userService.getAllUsers());
        table.getItems().clear();
        table.getItems().addAll(filteredList);
        edit_pane.setVisible(false);
    }

}
