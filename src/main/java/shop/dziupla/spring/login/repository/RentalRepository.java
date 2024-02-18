package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Rental;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findAllByClientId(Long id);

    List<Rental> getAllByEndDateBetween(LocalDate endDate, LocalDate endDate2);

    @Query("SELECT CASE WHEN COUNT(r) = 0 THEN true ELSE false END " +
            "FROM Rental r " +
            "WHERE :date BETWEEN r.startDate AND r.endDate AND r.car.id = :carId")
    boolean existsByDateBetweenStartAndEnd(@Param("carId") Long carId, @Param("date") LocalDate date);
}
