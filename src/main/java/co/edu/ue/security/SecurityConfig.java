package co.edu.ue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	//http://localhost:8080/swagger-ui/index.html

	
	@Bean  //ME PERMITE VOLVERLO O INYECTARLO COMO UN OBJETO
	public InMemoryUserDetailsManager usermanager() {
		List<UserDetails> users = List.of(
				User
				.withUsername("client")
				.password("{noop}1234")
				.roles("USERS")
			    .build(),
			    User
			    .withUsername("admin")
			    .password("{noop}1234")
			    .roles("ADMINS")
			    .build()
			    );
				
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(aut->{
        aut.requestMatchers(org.springframework.http.HttpMethod.POST,"/usuarios").hasAnyRole("ADMINS")
        .requestMatchers(org.springframework.http.HttpMethod.GET,"/usuarios").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.GET,"/usuarios/{id}").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.GET,"/usuarios/email/{email}").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.PUT,"/usuarios").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.DELETE,"/{id}").hasAnyRole("ADMINS")
        .requestMatchers(org.springframework.http.HttpMethod.POST,"/perfiles").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.GET,"/perfiles").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.GET,"/perfiles/{id}").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.PUT,"/perfiles").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.DELETE,"/perfiles/{id}").hasAnyRole("ADMINS")
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/matches").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/matches/{id}").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.PUT, "/matches").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/matches/{id}").hasAnyRole("ADMINS")
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/citas").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/citas/{id}").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.POST, "/citas").hasAnyRole("USER", "ADMIN")
        .requestMatchers(org.springframework.http.HttpMethod.PUT, "/citas/{id}").hasAnyRole("USER", "ADMIN")
        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/citas/{id}").hasRole("ADMIN")
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/citas/fecha/{fecha}").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/citas/estado/{estado}").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.POST, "categorias-match").hasAnyRole("ADMIN")
        .requestMatchers(org.springframework.http.HttpMethod.GET, "categorias-match").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.GET, "categorias-match/{id}").authenticated()
        .requestMatchers(org.springframework.http.HttpMethod.PUT, "categorias-match").hasAnyRole("ADMIN", "USER")
        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "categorias-match/{id}").hasRole("ADMIN")
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/fotografias").authenticated() 
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/fotografias/{id}").authenticated() 
        .requestMatchers(org.springframework.http.HttpMethod.PUT, "/fotografias").hasAnyRole("ADMIN", "USER") 
        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/fotografias/{id}").hasRole("ADMIN") 
        .anyRequest().permitAll();

            })
            .httpBasic(Customizer.withDefaults())
            .formLogin(login -> login.permitAll());
        

        return http.build();
    }
}