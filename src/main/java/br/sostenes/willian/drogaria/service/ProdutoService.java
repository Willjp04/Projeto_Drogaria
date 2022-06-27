package br.sostenes.willian.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import br.sostenes.willian.drogaria.domain.Produto;

import br.sostenes.willian.drogaria.exception.RecursoNaoEncontradoException;

import br.sostenes.willian.drogaria.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// ESTE MÉTODO É PARA BUSCAR UM PRODUTO POR CÓDIGO
	public Produto buscarPorCodigo(Integer codigo) {
		Optional<Produto> resultado = produtoRepository.findById(codigo);

		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}

		Produto produto = resultado.get();
		return produto;

	}

	// ESTE MÉTODO É PARA INSERIR PRODUTOS
	public Produto inserirProduto(Produto produto) {
		Produto produtoSalva = produtoRepository.save(produto);
		return produtoSalva;
	}

	// ESTE MÉTODO É PARA DELETAR PRODUTOS

	public Produto deletarProduto(Integer codigo) {
		Optional<Produto> resultado = produtoRepository.findById(codigo);
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}

		produtoRepository.delete(resultado.get());
		return resultado.get();
	}

	// ESTE MÉTODO É PARA LISTAR TODOS OS PRODUTOS CADASTRADOS
	public List<Produto> buscarTudo() {
		List<Produto> resultado = produtoRepository.findAll();
		return resultado;
	}

	public Produto editar(Produto produto) {

		Produto editaProduto = produtoRepository.saveAndFlush(produto);
		if (produto.getCodigo() == null) {
			throw new RecursoNaoEncontradoException();
		}

		return editaProduto;

	}

}
