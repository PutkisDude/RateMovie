package lp.putkonen.rateMovie;
// import java.util.ArrayList;
// import java.util.List;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lp.putkonen.rateMovie.web.UserDetailsServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
    private UserDetailsServiceImpl userDetailsService;	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("*").permitAll()
			.antMatchers("/h2-console/**").permitAll();
		
        http.csrf().disable();
        http.headers().frameOptions().disable();
        
        // POISTA H2 ja 2 vikaa riviä ennen julkaisua
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
	
	
	