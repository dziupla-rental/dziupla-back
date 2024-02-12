package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Rental;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    public List<Rental> findAllByClientId(Long id);

    Float countByEndDateBetween(LocalDate endDate, LocalDate endDate2);

    List<Rental> getAllByEndDateBetween(LocalDate endDate, LocalDate endDate2);



}
