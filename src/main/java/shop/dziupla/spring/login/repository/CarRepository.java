package shop.dziupla.spring.login.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Office;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    //long countAllByAvailable(@NotNull boolean available);
    long countAllByTechnicalStatus(@NotNull boolean technicalStatus);

    List<Car> getCarsByOffice(Office office);
}
