package cardemo1.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 60)
    String brand;

    String model;

    double pricePrDay;
    @CreationTimestamp
    LocalDateTime dateCreated;
    @UpdateTimestamp
    LocalDateTime dateUpdated;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(String brand, String model, double pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }
    @OneToMany(mappedBy = "car", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    List<Reservation> reservations = new ArrayList<>();
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setCar(this);
    }




}
