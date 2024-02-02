package shop.dziupla.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.dziupla.spring.login.models.DAO.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Photo getPhotoByUrl(String url);
}
