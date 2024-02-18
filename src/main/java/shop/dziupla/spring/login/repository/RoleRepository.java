package shop.dziupla.spring.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.dziupla.spring.login.models.Enums.ERole;
import shop.dziupla.spring.login.models.DAO.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    Boolean existsByName(ERole name);
}
