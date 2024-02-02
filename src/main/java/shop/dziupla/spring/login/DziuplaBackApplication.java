package shop.dziupla.spring.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.repository.EmployeeRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;
import shop.dziupla.spring.login.repository.RoleRepository;
import shop.dziupla.spring.login.security.services.EmployeeService;

@SpringBootApplication
public class DziuplaBackApplication  implements CommandLineRunner {

	@Autowired EmployeeRepository er;
	@Autowired
	OfficeRepository or;
	@Autowired EmployeeService service;
	@Autowired
	RoleRepository rr;
	public static void main(String[] args) {
		SpringApplication.run(DziuplaBackApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var office = new Office("Nowy Sacz");
//		var user = new User("Wika2", "wika2@gmail.com", "wika21234WWWsika");
//		var role = new Role(ERole.ROLE_EMPLOYEE);
//		var roleSet = new HashSet<Role>();
//		roleSet.add(role);
//		user.setRoles(roleSet);
//		var employee = new Employee(office, 1000, LocalTime.of(8,0), LocalTime.of(16,0), user);
//		er.save(employee);
//		rr.save(new Role(ERole.ROLE_EMPLOYEE));
//		rr.save(new Role(ERole.ROLE_USER));
//		rr.save(new Role(ERole.ROLE_ADMIN));
//		rr.save(new Role(ERole.ROLE_EMPLOYEE_HR));
//		rr.save(new Role(ERole.ROLE_EMPLOYEE_MECHANIC));
		or.save(office);





	}
}
