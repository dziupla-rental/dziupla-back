package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.CompanyInfo;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
}
