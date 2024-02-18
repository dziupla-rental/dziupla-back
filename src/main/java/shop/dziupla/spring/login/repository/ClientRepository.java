package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByUserId(Long userId);
}
