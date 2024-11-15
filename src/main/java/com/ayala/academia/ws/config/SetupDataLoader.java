package com.ayala.academia.ws.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.ayala.academia.ws.domain.User;
import com.ayala.academia.ws.repository.UserRepository;

@Configuration
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		// TODO Auto-generated method stub
		
		userRepository.deleteAll();
		User jose = new User ("José", "Viana", "joseviana@example");
		User joao = new User ("João", "Souza", "joaosilva@example");
		
		createUserIfNotFound(jose);
		createUserIfNotFound(joao);
	}
	
	private User createUserIfNotFound(final User user) {
		Optional<User> obj = userRepository.findByEmail(user.getEmail());
		if(obj.isPresent()) {
			return obj.get();
		}
		return userRepository.save(user);
	}

}
