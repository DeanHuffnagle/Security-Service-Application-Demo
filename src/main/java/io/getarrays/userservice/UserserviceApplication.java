package io.getarrays.userservice;

import io.getarrays.userservice.domain.AppUser;
import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_OWNER"));

			userService.saveUser(new AppUser(null, "Dean Huffnagle", "Deebo", "password", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Regina Gavagan", "Geebo", "password", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Alaska Huffigan", "Dapsky", "password", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "John Thomson", "Hacker_not_john", "password", new ArrayList<>()));

			userService.assignRoleToUser("Deebo", "ROLE_USER");
			userService.assignRoleToUser("Geebo", "ROLE_USER");
			userService.assignRoleToUser("Dapsky", "ROLE_USER");
			userService.assignRoleToUser("Hacker_not_john", "ROLE_USER");
			userService.assignRoleToUser("Deebo", "ROLE_ADMIN");
			userService.assignRoleToUser("Deebo", "ROLE_OWNER");


		};
	}

}
