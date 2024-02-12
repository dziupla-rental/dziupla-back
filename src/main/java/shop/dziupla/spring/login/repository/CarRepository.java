package shop.dziupla.spring.login.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    long countAllByAvailable(@NotNull boolean available);
    long countAllByTechnicalStatus(@NotNull boolean technicalStatus);
}