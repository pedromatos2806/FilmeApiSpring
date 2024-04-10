package com.example.springboot.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
		Long id,
		@NotBlank  String nome,
		@NotBlank  String login,
		@NotBlank  String senha,
		@NotBlank List<RoleDto> roles) {

	
//	public UsuarioDTO (Usuario usuario) {
//		this( usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
//	}
}
