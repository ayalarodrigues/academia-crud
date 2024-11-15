package com.ayala.academia.ws.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayala.academia.ws.domain.User;
import com.ayala.academia.ws.dto.UserDTO;
import com.ayala.academia.ws.services.UserService;



@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> users = userService.findAll();
		List<UserDTO> listDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO); //retorna a lista de usuário
	 }
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO>findById(@PathVariable String id) {
		
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user)); //retorna a lista de usuário
	 }


}
