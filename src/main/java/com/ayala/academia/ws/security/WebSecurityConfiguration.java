package com.ayala.academia.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ayala.academia.ws.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Autowired
	CustomUserDetailsService userDetailsService;	
	
	@Bean //todas as classes são escaneadas 
	public BCryptPasswordEncoder bCryptPasswordEncoder() { //criptografa a senha dos usuários
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		provider.setUserDetailsService(userDetailsService);
        return provider;
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth){
		auth.authenticationProvider(authenticationProvider());
	}


}
