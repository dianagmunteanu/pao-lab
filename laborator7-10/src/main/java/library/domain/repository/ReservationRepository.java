package library.domain.repository;

import library.domain.entity.Book;
import library.domain.entity.Reservation;
import library.domain.entity.User;

import java.util.Date;
import java.util.Set;

public interface ReservationRepository {
    public void addReservation(User user, Book book, Date endDate);

    public int getNumberOfReservations();

    public Set<Reservation> getReservations();
}
