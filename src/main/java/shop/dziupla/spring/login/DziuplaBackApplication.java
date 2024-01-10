package shop.dziupla.spring.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shop.dziupla.spring.login.models.*;
import shop.dziupla.spring.login.repository.EmployeeRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;

import java.time.LocalTime;

@SpringBootApplication
public class DziuplaBackApplication  implements CommandLineRunner {

	@Autowired EmployeeRepository er;
	@Autowired
	OfficeRepository or;
	public static void main(String[] args) {
		SpringApplication.run(DziuplaBackApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var office = new Office("Nowy Sacz");
		var user = new User("Wika1", "wika1@gmail.com", "wika11234WWWsika");
		var role = new Role(ERole.ROLE_EMPLOYEE);
		var employee = new Employee(office, role, 1000, LocalTime.of(8,0), LocalTime.of(16,0));
		employee.setUser(user);
		er.save(employee);
		or.save(office);
	}
}
