import library.LibraryService;
import library.User;
import library.UserService;

import java.util.Date;

public class Start {

    public static void main(String[] args) {

        System.out.println("Welcome to Diana's library");


        LibraryService libraryService = LibraryService.getInstance();

        /*libraryService.addReservation(1, 1, new Date());
        libraryService.getNumberOfReservations();
        System.out.println("- Serviciul 2 -");
        LibraryService libraryService2 = LibraryService.getInstance();
        libraryService2.getNumberOfReservations();*/


        UserService userService = new UserService();
        userService.setLibraryService(LibraryService.getInstance());
        //System.out.println("Numarul de rezervari ale lui 1 este:" + userService.getNumberOfReservationsOfUser(1));

        User[] usersInUserService = libraryService.getUsers();
        printUsers(usersInUserService);

        String[] partialName = {"JDo","JoHDo","JoDo","JoDMa","Gigel"};
        System.out.println("Trying to search in our user list all users that match the partial name: " + partialName);
        for(int i =0;i<partialName.length;i++) {
            User[] result = userService.searchUsersByASpecificPattern(partialName[i]);
            printUsers(result);
        }
    }

    private static void printUsers(User[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null) {
                System.out.println("--------------------------");
                break;
            }
            System.out.println(result[i].getId()+": "+result[i].getName());
        }
    }
}
