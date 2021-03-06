package library.services;

import library.configuration.RepositoryConfig;
import library.controller.dto.UserDto;
import library.domain.LibraryException;
import library.domain.entity.User;
import library.domain.repository.ReservationRepository;
import library.domain.repository.UserRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static library.domain.ErrorCode.*;

public class UserService {

    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    private UserRepository userRepository = RepositoryConfig.getInstance().getUserRepository();

    public UserService() {
        System.out.println("Creating instance of UserService");
    }

    public String getUserNameById(int userId) {
        User selectedUser = userRepository.getUserBy(userId);

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

    public int getNumberOfUsers() {
        return userRepository.getUsers().size();
    }

    public void printAllUsers() {
        printUsers(userRepository.getUsers());
    }

    private void printUsers(Set<User> result) {
        PrintWriter printWriter = null;
        try (FileOutputStream outputStream = new FileOutputStream("all-users.txt")) {
            /*
            FileWriter fileWriter = new FileWriter("all-users.txt");
            printWriter = new PrintWriter(fileWriter);
            */
            printWriter = new PrintWriter(outputStream);
            for (User user : result) {
                System.out.println(user.getId() + ": " + user.getName());
                printWriter.printf("%d: %s \n", user.getId(), user.getName());
            }
            printWriter.close();
        } catch (IOException e) {
            throw new LibraryException(PRINT_ALL_USERS_ERROR, e.getMessage());
        }
    }


    public void createNewUser(String name, String address, String email) {
        User user = new User();
        user.setId(userRepository.getNextId());
        user.setName(name);
        user.setAddress(address);
        user.setEmail(email);
        userRepository.insertUser(user);
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> resultedList = new ArrayList<>();
        for(User u : userRepository.getUsers()){
            resultedList.add(new UserDto(u));
        }
        return resultedList;
    }

    public UserDto getUserById(String text) {
        User result = userRepository.getUserBy(new Integer(text));
        if(result == null){
            return null;
        }
        return new UserDto(result);
    }

    public void updateUser(String text, String newAddress) {
        userRepository.updateUser(text,newAddress);
    }
}
