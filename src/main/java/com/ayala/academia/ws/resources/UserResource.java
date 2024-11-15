package com.ayala.academia.ws.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayala.academia.ws.domain.User;

@RestController
@RequestMapping("/api")

public class UserResource {
	
	@GetMapping("/users")
	 public ResponseEntity<List<User>> findAll() {
	 List<User> users = new ArrayList<>();
	 User joao = new User("João", "Souza", "joao@gmail.com");
	 User maria = new User("Maria", "Teixeira", "maria@gmail.com");
	 users.addAll(Arrays.asList(joao, maria)); //permite adicionar todos os usuários à lista
	 return ResponseEntity.ok().body(users); //retorna a lista de usuário
	 }


}
