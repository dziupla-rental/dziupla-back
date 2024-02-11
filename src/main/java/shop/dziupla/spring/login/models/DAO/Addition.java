package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import shop.dziupla.spring.login.models.Enums.EAddition;

@Entity
@Table(name = "additions")
public class Addition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "rental_id", referencedColumnName = "id")
//    private Rental rental;

    @Enumerated(EnumType.STRING)
    private EAddition addition;

}
