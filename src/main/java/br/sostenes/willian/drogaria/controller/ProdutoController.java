package br.sostenes.willian.drogaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sostenes.willian.drogaria.domain.Produto;
import br.sostenes.willian.drogaria.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{codigo}")
	public Produto buscaporCodigo(@PathVariable Integer codigo) {
		Produto produto = produtoService.buscarPorCodigo(codigo);
		return produto;
		
	}
	
	@PostMapping("/adicionar")
	public Produto inserir(@RequestBody Produto produto) {
		Produto produtoSalva = produtoService.inserirProduto(produto);
		return produtoSalva;
		
	}
}
