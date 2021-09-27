package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {  // PasswordEncoder
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "박상우1 정보", "박상우1", "1", new ArrayList<>()));
			userService.saveUser(new User(null, "박상우2 정보", "박상우2", "2", new ArrayList<>()));
			userService.saveUser(new User(null, "박상우3 정보", "박상우3", "3", new ArrayList<>()));
			userService.saveUser(new User(null, "박상우4 정보", "박상우4", "4", new ArrayList<>()));

			userService.addRoleToUser("박상우1", "ROLE_USER");
			userService.addRoleToUser("박상우1", "ROLE_MANAGER");
			userService.addRoleToUser("박상우2", "ROLE_MANAGER");
			userService.addRoleToUser("박상우3", "ROLE_ADMIN");
			userService.addRoleToUser("박상우4", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("박상우4", "ROLE_ADMIN");
			userService.addRoleToUser("박상우4", "ROLE_USER");

		};
	}
}
