package com.ayala.academia.ws.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
public class Role implements Serializable, GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	
	public Role() {
		
		// TODO Auto-generated constructor stub
	}

	public Role(String name) {

		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	
	
	
	

}
