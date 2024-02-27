package com.example.sampleserucrityapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//public class SampleSecurityConfig {
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) 
//			throws Exception {
//		http.csrf().disable();
//		http.authorizeHttpRequests(authorize -> {
//			authorize
//				.requestMatchers("/").permitAll()
//				.requestMatchers("/js/**").permitAll()
//				.requestMatchers("/css/**").permitAll()
//				.requestMatchers("/img/**").permitAll()
//				.requestMatchers("/admin").hasRole("ADMIN")
//				.anyRequest().authenticated();
//		});
//		http.formLogin(form -> {
//			form.defaultSuccessUrl("/secret");
//		});
//		return http.build();
//	}
////	@Bean
////	public InMemoryUserDetailsManager userDetailsManager() {
////		String username = "user";
////		String password = "pass";
////		UserDetails user = 
////				User.withUsername(username)
////					.password(
////						PasswordEncoderFactories
////							.createDelegatingPasswordEncoder()
////							.encode(password))
////					.roles("USER")
////					.build();
////		return new InMemoryUserDetailsManager(user);
////	}
//	@Autowired
//	private DataSource dataSource;
//	@Bean
//	public UserDetailsManager userDetailManager() {
//		JdbcUserDetailsManager users = new JdbcUserDetailsManager(this.dataSource);
////		users.createUser(makeUser("taro", "yamada", "USER"));
////		users.createUser(makeUser("hanako", "flower", "USER"));
////		users.createUser(makeUser("sachiko", "happy", "USER"));
////		users.createUser(makeUser("admin", "kanri", "ADMIN"));
//		return users;
//	}
//	private UserDetails makeUser(String user, String pass, String role) {
//		return User.withUsername(user)
//				.password(
//				PasswordEncoderFactories
//					.createDelegatingPasswordEncoder()
//					.encode(pass))
//				.roles(role)
//				.build();
//	}
//}

@Configuration
@EnableMethodSecurity
public class SampleSecurityConfig {
	@Autowired
	private DataSource dataSource;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests(authorize -> {
			authorize
				.anyRequest().permitAll();
		});
		http.formLogin(form -> {
			form.defaultSuccessUrl("/secret");
		});
		return http.build();
	}
	@Bean
	public UserDetailsManager userDetailManager() {
		return new JdbcUserDetailsManager(this.dataSource);
	}
}
