package com.poolcarz.security;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
	
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.requestMatchers("/users").permitAll()
			.and()
			.authorizeHttpRequests()
			.requestMatchers("/rides/**")
			.authenticated()
			.and()
			.formLogin()
			;
//				(requests)->{
//					try {
//						requests
//							.requestMatchers("/","/user")
//							.permitAll()
//							.anyRequest()
//							.authenticated()
//							.and()
//							.sessionManagement()
//							.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//							.and()
//							.authenticationProvider(authenticationProvider());
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						System.out.println(e.getMessage());
////						e.printStackTrace();
//					}
//				}
//				).formLogin(
//						(form)->form
//						.loginPage("/login")
//						.permitAll()
//						).logout(
//								(logout)->logout
//									.permitAll()
//								);
		
		return httpSecurity.build();
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
				
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider();
	}

	
}
