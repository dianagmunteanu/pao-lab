package library.services;

import library.configuration.RepositoryConfig;
import library.domain.LibraryException;
import library.domain.entity.User;
import library.domain.repository.ReservationRepository;
import library.domain.repository.UserRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static library.domain.ErrorCode.*;

public class UserService {

    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    private UserRepository userRepository = RepositoryConfig.getInstance().getUserRepository();

    public UserService() {
        System.out.println("Creating instance of UserService");
    }

    public String getUserNameById(int userId) {
        User selectedUser = null;
        User[] users = userRepository.getUsers();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == userId) {
                selectedUser = users[i];
            }
        }
        if (selectedUser == null) {
            throw new LibraryException(USER_NOT_FOUND, "Could not find the user with id: " + userId);
        }
        return selectedUser.getName();
    }

    public String getUserNameById(String userId) {
        try {
            int id = new Integer(userId);
            return getUserNameById(id);
        } catch (NumberFormatException e) {
            throw new LibraryException(INCORRECT_USER_ID, "Could not convert to int the following userId: " + userId);
        }
    }

    private void printUsers(User[] result) {
        PrintWriter printWriter = null;
        try (FileOutputStream outputStream = new FileOutputStream("all-users.txt")) {
            /*FileWriter fileWriter = new FileWriter("all-users.txt");
            printWriter = new PrintWriter(fileWriter);*/
            printWriter = new PrintWriter(outputStream);
            for (int i = 0; i < result.length; i++) {
                if (result[i] == null) {
                    break;
                }
                //System.out.println(result[i].getId() + ": " + result[i].getName());
                printWriter.printf("%d: %s \n", result[i].getId(), result[i].getName());
            }
        } catch (IOException e) {
            throw new LibraryException(PRINT_ALL_USERS_ERROR, e.getMessage());
        }
    }

    public void printAllUsers() {
        printUsers(userRepository.getUsers());
    }
}
