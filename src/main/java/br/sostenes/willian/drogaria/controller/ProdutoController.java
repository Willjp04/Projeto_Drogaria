package br.sostenes.willian.drogaria.controller;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import br.sostenes.willian.drogaria.domain.Produto;
import br.sostenes.willian.drogaria.exception.RecursoNaoEncontradoException;
import br.sostenes.willian.drogaria.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("buscarproduto")
	public Produto buscaporCodigo(@RequestParam Integer codigo) {
		try {
			Produto produto = produtoService.buscarPorCodigo(codigo);
			return produto;
		} catch (RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", excecao);
		}
	}

	@PostMapping("/adicionar")
	public Produto inserir(@RequestBody Produto produto) {
		Produto produtoSalva = produtoService.inserirProduto(produto);
		return produtoSalva;

	}

	@DeleteMapping("/deletar")
	public Produto deletar(@RequestParam Integer codigo) {
		try {
			Produto produtoDeleta = produtoService.deletarProduto(codigo);
			return produtoDeleta;
		} catch (RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado para ser deletado",
					excecao);

		}

	}

	@GetMapping("/listartodos")
	@ResponseBody // ESSA ANOTAÇÃO É PARA RETORNAR O JSON COM TUDO
	public List<Produto> listar() {
		List<Produto> resultado = produtoService.buscarTudo();
		return resultado;

	}

	@PutMapping("/editarproduto")
	public Produto editar(@RequestBody Produto produto) {

		Produto produtoEdita = produtoService.editar(produto);

		return produtoEdita;

	}

}
