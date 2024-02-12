package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Rental;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    public List<Rental> findAllByClientId(Long id);
}
