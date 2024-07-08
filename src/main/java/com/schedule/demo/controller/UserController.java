package com.schedule.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.demo.entity.UserEntity;
import com.schedule.demo.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@Operation(summary = "Busca de usuario por id", description = "Essa funcionalidade busca os usuarios pelo seu id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario encontrado",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = UserEntity.class))),
				@ApiResponse(responseCode = "400",description="Não foi possivel encontrar")
	})
	@GetMapping("/{id}")
	public Optional<UserEntity> getUser(@Parameter(description = "id do usuario", required = true) @PathVariable Long id) {
		return service.getUser(id);
	}

	@Operation(summary = "Cria um novo usuario :D", description = "Essa funcionalidade cria um usuario")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario Criado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = UserEntity.class))),
					@ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos")
	})
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return service.createUser(user);

	}
	
	@Operation(summary = "Busca por usuarios", description = "Essa funcionalidade pesquisa por usuarios")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuarios encontrados ",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = UserEntity.class)))
	})
	@GetMapping
	public List<UserEntity> listUsers() {
		return service.findUsers();
	}
	
	@Operation(summary = "Atualizar usuario", description = "Essa funcionalidade atualiza usuarios atraves do ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = UserEntity.class)
				)
			),
			@ApiResponse(responseCode = "400", description = "Usuario não encontrado")
	})
	@PutMapping("/update/{id}")
	public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		return service.updateUser(id, user);
	}
	
	@Operation(summary = "Deletar usuario", description = "Essa funcionalidade deleta um usuario atraves do ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso")
	})
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}

}
