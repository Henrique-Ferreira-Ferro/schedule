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
	
	//Atualizar usuario PUT (Preciso consertar)
	public UsuarioEntity updateUser(Long id, UsuarioEntity user) {
		
		Optional<UsuarioEntity> usuario = repository.findById(id);
		if(usuario.isPresent()) {
			UsuarioEntity usuarioModif = usuario.get();
			usuarioModif.setNome(user.getNome());
			
			repository.save(usuarioModif);
			return usuarioModif;
		}else {
			System.out.println("Usuario não encontrado");
			return null;
		}
	}
	
	//Deleta usuario
	public List<UsuarioEntity> deleteUser(Long id){
		 repository.deleteById(id);
		 return findUsers();
	}
	
}
