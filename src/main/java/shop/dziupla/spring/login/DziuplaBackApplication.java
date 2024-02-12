package shop.dziupla.spring.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import shop.dziupla.spring.login.mappers.ClientMapper;
import shop.dziupla.spring.login.models.DAO.*;
import shop.dziupla.spring.login.models.Enums.EDriverLicenseCategory;
import shop.dziupla.spring.login.models.Enums.ERole;
import shop.dziupla.spring.login.payload.response.DriverLicenseDTO;
import shop.dziupla.spring.login.repository.*;
import shop.dziupla.spring.login.security.services.EmployeeService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DziuplaBackApplication  implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CompanyInfoRepository companyInfoRepository;
	@Autowired
	EmployeeRepository er;
	@Autowired
	OfficeRepository or;
	@Autowired
	EmployeeService service;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	DriverLicenseRepository driverLicenseRepository;
	@Autowired
	ClientMapper clientMapper;

	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(DziuplaBackApplication.class, args);

	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
//		DriverLicenseDTO dto = new DriverLicenseDTO();
//		dto.setLicenseCategory("A");
//		DriverLicense driverLicense = new DriverLicense();
//		driverLicense.setLicenseCategory( Enum.valueOf( EDriverLicenseCategory.class, dto.getLicenseCategory() ) );
//		EDriverLicenseCategory e = null;
//		e = Enum.valueOf(EDriverLicenseCategory.class, "A");

//		var user = new User("pudzian420", "pudzian@gmail.com", "haslo123", "Mariusz", "Pudzianowski");
//		user.setId(10L);
//		Client client = new Client(user, null, null);
//		client.setId(10L);
//		DriverLicense driverLicense = new DriverLicense(client, EDriverLicenseCategory.B, 123L, LocalDate.of(2024, 4, 20));
//		client.setLicenses(List.of(driverLicense));
//		driverLicense.setId(10L);
//		var clientDTO = clientMapper.clientToClientDTO(client);


//		var user = new User("pudzian420", "pudzian@gmail.com", "haslo123", "Mariusz", "Pudzianowski");
//		var role = roleRepository.findByName(ERole.ROLE_USER);
//		user.setRole(role.get());
//		userRepository.save(user);
//
//		Client client = new Client(user, null, null);
//
//		DriverLicense driverLicense = new DriverLicense(client, EDriverLicenseCategory.B, 123L, LocalDate.of(2024, 4, 20));
//
//		client.setLicenses(List.of(driverLicense));
//		clientRepository.save(client);

//		var car = new Car();
//		car.setCost(1200);
//		car.setDeposit(200);
//		car.setInsuranceNumber(12345);
//		car.setAvailable(true);
//		car.setModel("ABC");
//		car.setSeatNumber(4);
//		car.setTechnicalStatus(true);
//
//		carRepository.save(car);

//		var user = userRepository.findById(4L);
//		CompanyInfo companyInfo = new CompanyInfo("biedronka SA", 2222);
//		companyInfoRepository.save(companyInfo);
//
//		/*User user = new User("biedronkaCEO", "biedra@gmail", "adasda", "Maciej", "Lopian");
//		var role = roleRepository.findByName(ERole.ROLE_USER);
//		user.setRole(role.get());
//		userRepository.save(user);*/
//
//		Client client = new Client(user.get(), companyInfo);
//		clientRepository.save(client);
//		companyInfoRepository.save(companyInfo);

		//Client client = clientRepository.getReferenceById(1L);
		//client.setCompanyInfo(companyInfo);
		//clientRepository.save(client);

//		rr.save(new Role(ERole.ROLE_EMPLOYEE));
        //rr.save(new Role(ERole.ROLE_USER));
//        rr.save(new Role(ERole.ROLE_ADMIN));
//        rr.save(new Role(ERole.ROLE_EMPLOYEE_HR));
//        rr.save(new Role(ERole.ROLE_EMPLOYEE_MECHANIC));

		//CompanyInfo companyInfo = new CompanyInfo("firma2", 22241232);
		//companyInfoRepository.save(companyInfo);

//		User user = new User("user2", "user2@gmail", "asdaddsa", "user2name", "user2lastnaem");
//		Role role = new Role(ERole.ROLE_USER);
//
//		user.setRole(role);
//		//rr.save(role);
//		userRepository.save(user);
//		Client client = new Client(user, null);
//		clientRepository.save(client);
	}
}
