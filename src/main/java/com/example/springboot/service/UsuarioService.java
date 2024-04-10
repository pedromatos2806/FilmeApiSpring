package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot.dtos.UsuarioDto;
import com.example.springboot.entities.Usuario;
import com.example.springboot.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario>listarTodos() {
		return usuarioRepository.findAll();
	}
	
	public ResponseEntity<Usuario> criarUsuario(UsuarioDto usuarioDTO) {
		var usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDTO,usuario);
		
		return ResponseEntity.ok(usuarioRepository.save(usuario));
	}
	
	public ResponseEntity<Usuario> atualizarUsuario(UsuarioDto usuarioDTO, Long id){
		var usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			Usuario usuarioAtualizado = usuario.get();
			usuarioAtualizado.setNome(usuarioDTO.nome());
			usuarioAtualizado.setLogin(usuarioDTO.login());
			usuarioAtualizado.setSenha(usuarioDTO.senha());
			return ResponseEntity.ok((Usuario)usuarioRepository.save(usuarioAtualizado));
		}
		return ResponseEntity.notFound().build();
	}
}
