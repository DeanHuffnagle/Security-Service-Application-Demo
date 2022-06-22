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
			userService.saveRole(new Role(null, "ROLE_QUARTERMASTER"));
			userService.saveRole(new Role(null, "ROLE_HEAD_OF_MISSIONS"));
			userService.saveRole(new Role(null, "ROLE_DOUBLE_0_AGENT"));
			userService.saveRole(new Role(null, "ROLE_VILLAIN"));

			userService.saveUser(new AppUser(null, "James Bond", "007", "shaken_not_stirred", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Olivia Mansfield", "M", "the_best_we_have", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Ben Whishaw", "Q", "dont_touch_that", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Auric", "Goldfinger", "J4m3sB0ndSux", new ArrayList<>()));

			userService.assignRoleToUser("007", "ROLE_DOUBLE_0_AGENT");
			userService.assignRoleToUser("M", "ROLE_HEAD_OF_MISSIONS");
			userService.assignRoleToUser("Q", "ROLE_QUARTERMASTER");
			userService.assignRoleToUser("Goldfinger", "ROLE_VILLAIN");

		};
	}

}
