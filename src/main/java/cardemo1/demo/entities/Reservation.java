package cardemo1.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    LocalDate reservationDate;
    LocalDate rentalDate;
    @ManyToOne
    Car car;
    @ManyToOne
    Member member;
    public Reservation(LocalDate rentalDate){
        this.rentalDate = rentalDate;
    }
    public Reservation(LocalDate rentalDate, Car car, Member member){
        this.rentalDate = rentalDate;
        this.car = car;


    }



}
