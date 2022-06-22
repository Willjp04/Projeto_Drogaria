package br.sostenes.willian.drogaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sostenes.willian.drogaria.domain.Produto;
import br.sostenes.willian.drogaria.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// ESTE MÉTODO É PARA BUSCAR UM PRODUTO POR CÓDIGO
	public Produto buscarPorCodigo(Integer codigo) {
		Optional<Produto> resultado = produtoRepository.findById(codigo);

		Produto produto = resultado.get();
		return produto;

	}

	// ESTE MÉTODO É PARA INSERIR PRODUTOS
	public Produto inserirProduto(Produto produto) {
		Produto produtoSalva = produtoRepository.save(produto);
		return produtoSalva;
	}

}
