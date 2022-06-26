package br.sostenes.willian.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.sostenes.willian.drogaria.domain.Produto;
import br.sostenes.willian.drogaria.exception.ProdutoNaoEncontradoException;
import br.sostenes.willian.drogaria.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{codigo}")
	public Produto buscaporCodigo(@PathVariable Integer codigo) {
		try {
			Produto produto = produtoService.buscarPorCodigo(codigo);
			return produto;
		} catch (ProdutoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", excecao);
		}
	}

	@PostMapping("/add")
	public Produto inserir(@RequestBody Produto produto) {
		Produto produtoSalva = produtoService.inserirProduto(produto);
		return produtoSalva;

	}

	@DeleteMapping("/{codigo}")
	public Produto deletar(@PathVariable Integer codigo) {
		Produto produtoDeleta = produtoService.deletarProduto(codigo);
		return produtoDeleta;
	}

	@GetMapping
	public List<Produto> listar() {
		List<Produto> resultado = produtoService.buscarTudo();
		return resultado;

	}
}
