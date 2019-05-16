package library.controller.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import library.domain.entity.User;



public class UserDto {
    public StringProperty id;
    public StringProperty userFullName;
    public StringProperty address;
    public StringProperty email;

    public UserDto() {
    }

    public UserDto(User user) {
        if (user == null){
            return;
        }
        this.id = new SimpleStringProperty(user.getId() +"");
        this.userFullName = new SimpleStringProperty(user.getName());
        this.address = new SimpleStringProperty(user.getAddress());
        this.email = new SimpleStringProperty(user.getEmail());
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty fullNameProperty() {
        return userFullName;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public StringProperty emailProperty() {
        return email;
    }

}