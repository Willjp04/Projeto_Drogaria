package br.sostenes.willian.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sostenes.willian.drogaria.domain.Categoria;
import br.sostenes.willian.drogaria.exception.RecursoNaoEncontradoException;
import br.sostenes.willian.drogaria.repository.CategoriaRepository;

//ESTA CLASSE É PARA OS SERVIÇOS

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//ESTE MÉTODO BUSCA UMA CATEGORIA CADASTRADA E CASO NÃO EXISTA RETORNA A EXCEPTION
	public Categoria buscarPorCodigo(Integer codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);

		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();

		}
		Categoria categoria = resultado.get();
		return categoria;

	}
// ESTE MÉTODO BUSCA TODAS AS CATEGORIAS
	public List<Categoria> buscarTudo() {
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}
// ESTE MÉTODO FAZ A INSERÇÃO DAS CATEGORIAS
	public Categoria inserirCategoria(Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	// ESTE MÉTODO DELETA A CATEGORIA REFERENCIANDO O CÓDIGO PARA DELEÇÃO
	public Categoria deletarCategoria(Integer codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
				return categoria.get();
		
	}
	//ESTE MÉTODO É PARA EDIÇÃO DE CATEGORIAS
	public Categoria editaCategoria(Categoria categoria) {
		Categoria categoriaEdita = categoriaRepository.save(categoria);
		return categoriaEdita;
	}

}
