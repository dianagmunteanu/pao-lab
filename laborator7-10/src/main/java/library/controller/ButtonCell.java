package library.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import library.controller.dto.UserDto;

public class ButtonCell extends TableCell<UserDto, Boolean> {
    final Button cellButton = new Button("Edit");

    public ButtonCell() {
        //Action when the button is pressed
        cellButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                UserDto currentUser = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                SearchByIdController.selectedUser = currentUser;
                ((TextField) ButtonCell.this.getScene().lookup("#address")).setText(currentUser.address.getValue());
                ButtonCell.this.getScene().lookup("#edit_pane").setVisible(true);
            }
        });
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        //TODO
        if (!empty) {
            setGraphic(cellButton);
        }
    }
}