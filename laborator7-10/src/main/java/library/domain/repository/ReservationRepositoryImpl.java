package library.domain.repository;

import library.domain.entity.Book;
import library.domain.entity.Reservation;
import library.domain.entity.User;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class ReservationRepositoryImpl implements ReservationRepository {

    Set<Reservation> reservations = new TreeSet<Reservation>(new Comparator<Reservation>() {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            return o1.getEndDate().compareTo(o2.getEndDate());
        }
    });

    @Override
    public void addReservation(User user, Book book, Date endDate) {
        Date startDate = new Date();
        Reservation newReservation = new Reservation(user, book, startDate, endDate);
        reservations.add(newReservation);
    }

    @Override
    public int getNumberOfReservations() {
        System.out.println("Numarul de rezervari din acest serviciu este: " + reservations.size());
        return reservations.size();
    }


    @Override
    public Set<Reservation> getReservations() {
        return reservations;
    }


}
