package library;

public class UserService {
    private LibraryService libraryService;

    public int getNumberOfReservationsOfUser(int idUser) {
        int counter = 0;
        Reservation[] reservations = libraryService.getReservations();
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null
                    && reservations[i].getUser().getId() == idUser) {
                counter++;
            }
        }
        return counter;
    }

    public LibraryService getLibraryService() {
        return libraryService;
    }

    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    public User[] searchUsersByASpecificPattern(String partialUserName) {
        User[] usersInLibraryService = libraryService.getUsers();
        User[] result = new User[usersInLibraryService.length];
        int counter = 0;
        String pattern = createPattern(partialUserName);
        System.out.println(pattern);

        for (int i = 0; i < usersInLibraryService.length; i++) {
            if (usersInLibraryService[i] != null && usersInLibraryService[i].getName().matches(pattern)) {
                result[counter++] = usersInLibraryService[i];
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
}
