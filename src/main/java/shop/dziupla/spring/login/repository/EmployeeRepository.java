package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
