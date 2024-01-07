package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
