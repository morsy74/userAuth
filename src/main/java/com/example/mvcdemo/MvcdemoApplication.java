package com.example.mvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcdemoApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner insertTestUser (UserRepository userRepository, PasswordEncoder passwordEncoder){
	// 	return args -> {
  //     User admin = new User();
  //     admin.setUsername("admin");
  //     admin.setPassword(passwordEncoder.encode("admin"));
	// 		admin.setEnabled(true);
	// 		admin.setAccountNonExpired(true);
	// 		admin.setCredentialsNonExpired(true);
	// 		admin.setAccountNonLocked(true);
	// 		admin.setRoles(List.of("ADMIN"));
  //     userRepository.save(admin);

	// 		User user = new User();
  //     user.setUsername("user");
  //     user.setPassword(passwordEncoder.encode("user"));
	// 		user.setEnabled(true);
	// 		user.setAccountNonExpired(true);
	// 		user.setCredentialsNonExpired(true);
	// 		user.setAccountNonLocked(true);
	// 		user.setRoles(List.of("USER"));
  //     userRepository.save(user);
  //   };
	// }
}
