package br.sostenes.willian.drogaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.sostenes.willian.drogaria.domain.Categoria;
import br.sostenes.willian.drogaria.exception.RecursoNaoEncontradoException;
import br.sostenes.willian.drogaria.service.CategoriaService;

@RestController // ESTA ANOTAÇÃO INDICA QUE ESTA CLASSE SERÁ REST
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

// ESTE MÉTODO É PARA RETORNAR TODAS AS CATEGORIAS, FOI CRIADO UMA LISTA PASSANDO CATEGORIAS DENTRO
	@GetMapping
	public List<Categoria> listar() {
		List<Categoria> resultado = categoriaService.buscarTudo();
		return resultado;

	}

	// ESTE MÉTODO É PARA INSERÇÃO
	@PostMapping("/adicionar") // ESTA ANOTAÇÃO É SEMPRE PARA INSERÇÃO DE DADOS
	public Categoria inserir(@RequestBody Categoria categoria) { // ESTA ANOTAÇÃO É PARA MAPEAR ESTE OBJETO
		Categoria categoriaSalva = categoriaService.inserirCategoria(categoria);
		return categoriaSalva;

	}

	// ESTE MÉTODO É PARA EXCLUSÃO
	 @DeleteMapping("/{codigo}") 
	 public Categoria excluir(@PathVariable Integer codigo) {
		 Categoria categoriaDeleta = categoriaService.deletarCategoria(codigo);
		 return categoriaDeleta;
		 
	 }
		
		 
		 
		
	 
//ESTE MÉTODO É PARA EDIÇÃO DE CATEGORIAS
	@PutMapping 
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaService.editaCategoria(categoria);
		return categoriaEditada;
	
			
	}

	// ESTE MÉTODO É PARA BUSCAR UMA CATEGORIA POR VEZ
	@GetMapping("/{codigo}")
	public Categoria buscaPorCodigo(@PathVariable Integer codigo) {
		try {
			Categoria categoria = categoriaService.buscarPorCodigo(codigo);
			return categoria;
		} catch (RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não encontrada", excecao);
		}
	}
	
	

}
