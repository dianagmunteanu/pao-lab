package library;

public class UserService {
    private LibraryService libraryService;

    public int getNumberOfReservationsOfUser(int idUser){
        int counter = 0;
        Reservation[] reservations = libraryService.getReservations();
        for(int i=0; i<reservations.length;i++){
            if(reservations[i] != null
                    && reservations[i].getUser().getId() == idUser){
                counter ++;
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
}
