package br.sostenes.willian.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sostenes.willian.drogaria.domain.Categoria;
import br.sostenes.willian.drogaria.repository.CategoriaRepository;

@RestController // ESTA ANOTAÇÃO INDICA QUE ESTA CLASSE SERÁ REST
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	// ESTE MÉTODO É PARA RETORNAR TODAS AS CATEGORIAS, FOI CRIADO UMA LISTA PASSANDO CATEGORIAS DENTRO
	@GetMapping("/")
	public List<Categoria> listar() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;

	}

	// ESTE MÉTODO É PARA INSERÇÃO
	@PostMapping // ESTA ANOTAÇÃO É SEMPRE PARA INSERÇÃO DE DADOS

	public Categoria inserir(@RequestBody Categoria categoria) { // ESTA ANOTAÇÃO É PARA MAPEAR ESTE OBJETO
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;

	}
	
	// ESTE MÉTODO É PARA EXCLUSÃO 
	@DeleteMapping("/{codigo}")
	public Categoria deletar(@PathVariable Integer codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
		return categoria.get();

	}
	//ESTE MÉTODO É PARA EDIÇÃO 
	@PutMapping 
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
		
			
	}
	
	// ESTE MÉTODO É PARA BUSCAR UMA CATEGORIA POR VEZ
	@GetMapping("/{codigo}")
		public Categoria buscar(@PathVariable Integer codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		Categoria categoria = resultado.get();
		return categoria;
		
	}

}
