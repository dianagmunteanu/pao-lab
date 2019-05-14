package library.controller.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserDto {
        public StringProperty id;
        public StringProperty userFullName;

        public UserDto(String id, String userFullName) {
            this.id = new SimpleStringProperty(id);
            this.userFullName = new SimpleStringProperty(userFullName);
        }

        public StringProperty idProperty() {
            return id;
        }

        public StringProperty fullNameProperty() {
            return userFullName;
        }

    }