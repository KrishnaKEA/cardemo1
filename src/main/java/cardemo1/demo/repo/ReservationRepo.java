package cardemo1.demo.repo;

import cardemo1.demo.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
    Reservation findReservationByCar_IdAndRentalDate(int id, LocalDate date);

}
