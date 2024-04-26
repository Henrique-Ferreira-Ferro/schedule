package com.schedule.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.UsuarioEntity;
import com.schedule.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioEntity createUser(UsuarioEntity user) {
		return repository.save(user);

	}

	// git merge origin main (puxar codigos da main) - Colocar no Obsidin para
	// estudar

	// Optional usado para validações
	/*
	 * Evita exceções de ponteiro nulo. Torna o código mais claro, legível e livre
	 * de erros. É uma alternativa moderna ao uso excessivo de exceções.
	 */
	public Optional<UsuarioEntity> getUser(Long id) {
		return repository.findById(id);
	}

	// Criar funcionalidade para listar todos usuários.
	public List<UsuarioEntity> findUsers() {
		return repository.findAll();
	}

	
	public UsuarioEntity updateUser(Long id, UsuarioEntity user) {

		Optional<UsuarioEntity> usuario = repository.findById(id);
		return logicUpdateUser(user, usuario);
	}

	// Deleta usuario
	public String deleteUser(Long id) {
		Optional<UsuarioEntity> usuario = repository.findById(id);
		return logicDeleteUser(id, usuario);

	}

	/*---------------------------------------------------------------------------------------------*/
	//Logica do Service!
	
	
	
	//Update User
	private UsuarioEntity logicUpdateUser(UsuarioEntity user, Optional<UsuarioEntity> usuario) {
		if (usuario.isPresent()) {
			UsuarioEntity usuarioModif = usuario.get();
			usuarioModif.setNome(user.getNome());

			repository.save(usuarioModif);
			return usuarioModif;
		} else {
			throw new RuntimeException("Usuario não encontrado");
		}
	}
	
	
	//Delete user
	private String logicDeleteUser(Long id, Optional<UsuarioEntity> usuario) {
		if (usuario.isPresent()) {
			UsuarioEntity user = usuario.get();
			repository.deleteById(id);
			return "Usuario " + user.getNome() + " deletado com sucesso!!!";
		} else {
			return "Usuario não encontrado!";
		}
	}
	

}