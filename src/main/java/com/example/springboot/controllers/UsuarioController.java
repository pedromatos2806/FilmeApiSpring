package com.example.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.UsuarioDto;
import com.example.springboot.entities.Usuario;
import com.example.springboot.service.UsuarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarTodos();
	}
	
	@Transactional
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid UsuarioDto usuarioDTO) {
		return usuarioService.criarUsuario(usuarioDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid UsuarioDto usuarioDTO,@PathVariable Long id){		
		return usuarioService.atualizarUsuario(usuarioDTO,id);
	}
}