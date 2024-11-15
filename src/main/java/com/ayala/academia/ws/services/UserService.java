package com.ayala.academia.ws.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayala.academia.ws.domain.User;
import com.ayala.academia.ws.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired //instancia objetos automaticamente
	private UserRepository userRepository;
	public List <User> findAll (){
		return userRepository.findAll();
	}
	

}
