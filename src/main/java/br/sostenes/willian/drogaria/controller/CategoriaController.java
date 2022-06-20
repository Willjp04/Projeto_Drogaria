package br.sostenes.willian.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sostenes.willian.drogaria.domain.Categoria;
import br.sostenes.willian.drogaria.repository.CategoriaRepository;

@RestController // ESTA ANOTAÇÃO INDICA QUE ESTA CLASSE SERÁ REST
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	//ESTA LISTA É PARA RETORNAR TODAS AS CATEGORIAS 
	@GetMapping("/")
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaRepository.findAll(); 
		return categorias;
		
	}

}
