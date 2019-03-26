package library.services;

import library.configuration.RepositoryConfig;
import library.domain.entity.Book;
import library.domain.entity.Reservation;
import library.domain.entity.User;
import library.domain.repository.ReservationRepository;
import library.domain.repository.ReservationRepositoryImpl;
import library.domain.repository.UserRepository;

import java.util.Date;

public class UserService {

    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    private UserRepository userRepository = RepositoryConfig.getInstance().getUserRepository();

    public UserService(){
        System.out.println("Creating instance of UserService");
    }

    public int getNumberOfReservationsOfUser(int idUser) {
        int counter = 0;
        Reservation[] reservations = reservationRepository.getReservations();
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null
                    && reservations[i].getUser().getId() == idUser) {
                counter++;
            }
        }
        return counter;
    }

    public String[] searchUsersByASpecificPattern(String partialUserName) {
        User[] usersInLibraryService = userRepository.getUsers();
        String[] result = new String[usersInLibraryService.length];
        int counter = 0;
        String pattern = createPattern(partialUserName);
        System.out.println(pattern);

        for (int i = 0; i < usersInLibraryService.length; i++) {
            if (usersInLibraryService[i] != null && usersInLibraryService[i].getName().matches(pattern)) {
                result[counter++] = usersInLibraryService[i].getName();
            }
        }
        return result;
    }

    private String createPattern(String partialUserName) { // example JDo, JoD, JoDo -> for John Doe
        String[] splitedPartialName = partialUserName.split("(?=[A-Z])"); //Split partial user name: {J, Do} {Jo D}
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < splitedPartialName.length; i++) {
            resultBuilder.append(splitedPartialName[i]);
            resultBuilder.append("[a-z]*"); //append any number of lower case characters

            resultBuilder.append("[[A-z]{1}[a-z]+\\s]*"); //any number of other names
            if (!(i == splitedPartialName.length - 1)) { //if it's not the last part
                resultBuilder.append("\\s"); //append one space
            }
        }
        return resultBuilder.toString();
    }

    private User getUserById(int userId) {
        User selectedUser = null;
        User[] users = userRepository.getUsers();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == userId) {
                selectedUser = users[i];
            }
        }
        if (selectedUser == null) {
            System.out.println("Nu a fost gasit un user cu id-ul: " + userId);
        }
        return selectedUser;
    }

    private void printUsers(User[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null) {
                System.out.println("--------------------------");
                break;
            }
            System.out.println(result[i].getId() + ": " + result[i].getName());
        }
    }

    public void printAllUsers() {
        printUsers(userRepository.getUsers());
    }
}
