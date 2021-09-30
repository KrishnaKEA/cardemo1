package cardemo1.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    @Column(nullable = false, unique = true)
    String email;
    boolean approved;
    int ranking = -1;
    @CreationTimestamp
    LocalDateTime dateCreated;
    @UpdateTimestamp
    LocalDateTime dateUpdated;

    public Member(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setMember(this);
    }


}
