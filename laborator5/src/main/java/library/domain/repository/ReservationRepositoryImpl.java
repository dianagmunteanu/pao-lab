package library.domain.repository;

import library.domain.entity.Book;
import library.domain.entity.Reservation;
import library.domain.entity.User;

import java.util.Date;

public class ReservationRepositoryImpl implements ReservationRepository {

    Reservation[] reservations = new Reservation[50];
    int currentIndex = 0;


    @Override
    public void addReservation(User user, Book book, Date endDate) {
        Date startDate = new Date();
        Reservation newReservation = new Reservation(user, book, startDate, endDate);
        reservations[currentIndex] = newReservation;
        currentIndex++;
    }

    @Override
    public int getNumberOfReservations() {
        System.out.println("Numarul de rezervari din acest serviciu este: " + currentIndex);
        return currentIndex;
    }


    @Override
    public Reservation[] getReservations() {
        return reservations;
    }


}
