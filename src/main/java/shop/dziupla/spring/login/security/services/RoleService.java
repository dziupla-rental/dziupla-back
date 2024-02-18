package shop.dziupla.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.models.DAO.Role;
import shop.dziupla.spring.login.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void saveIfNotExist(Role role){
        if(!roleRepository.existsByName(role.getName())){
            roleRepository.save(role);
        }
    }
}
