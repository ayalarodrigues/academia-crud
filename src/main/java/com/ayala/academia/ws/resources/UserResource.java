package com.ayala.academia.ws.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayala.academia.ws.domain.User;
import com.ayala.academia.ws.services.UserService;



@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll() {
		
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users); //retorna a lista de usuário
	 }


}
