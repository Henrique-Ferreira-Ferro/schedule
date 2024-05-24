package com.schedule.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.demo.entity.UserEntity;
import com.schedule.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserEntity createUser(UserEntity user) {
		return repository.save(user);

	}

	// git merge origin main (puxar codigos da main) - Colocar no Obsidin para
	// estudar

	// Optional usado para validações
	/*
	 * Evita exceções de ponteiro nulo. Torna o código mais claro, legível e livre
	 * de erros. É uma alternativa moderna ao uso excessivo de exceções.
	 */
	public Optional<UserEntity> getUser(Long id) {
		return repository.findById(id);
	}

	// Criar funcionalidade para listar todos usuários.
	public List<UserEntity> findUsers() {
		return repository.findAll();
	}

	
	public UserEntity updateUser(Long id, UserEntity user) {

		var usuario = repository.findById(id);
		return updateUserById(user, usuario);
	}

	// Deleta usuario
	public String deleteUser(Long id) {
		var usuario = repository.findById(id);
		return deleteUserById(id, usuario);

	}

	/*---------------------------------------------------------------------------------------------*/
	//Logica do Service!
	
	
	
	//Update User
	private UserEntity updateUserById(UserEntity user, Optional<UserEntity> usuario) {
		if (usuario.isPresent()) {
			var usuarioModif = usuario.get();
			usuarioModif.setName(user.getName());

			repository.save(usuarioModif);
			return usuarioModif;
		} else {
			throw new RuntimeException("Usuario não encontrado");
		}
	}
	
	
	//Delete user
	private String deleteUserById(Long id, Optional<UserEntity> usuario) {
		if (usuario.isPresent()) {
			var user = usuario.get();
			repository.deleteById(id);
			return "Usuario " + user.getName() + " deletado com sucesso!!!";
		} else {
			return "Usuario não encontrado!";
		}
	}
	

}