package shop.dziupla.spring.login.models;

import jakarta.persistence.*;

@Entity
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
