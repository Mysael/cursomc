package com.nelioalves.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	//adicionei o /{id} para fazer com que o endpoint vai ser /categorias/algum id que eu queira entrar
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	//adicionei a anotação @PathVariable para que o spring saiba que o id da url (/{id}) vai ter que vir como parametro para o find
	//O ResponseEntity armazena informações de uma resposta http para um serviço REST
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
