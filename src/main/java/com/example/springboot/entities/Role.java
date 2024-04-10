package com.example.springboot.entities;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name ="roles")
public class Role  implements Serializable,GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String role;
	
	public Role() {
		super();
	}
	
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public String getAuthority() {
		return role;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
