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
	
	//ESTE MÉTODO FAZ O TRATAMENTO PARA EXCEPTION QUANDO BUSCAR UMA CATEGORIA
	public Categoria buscarPorCodigo(Integer codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);

		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();

		}
		Categoria categoria = resultado.get();
		return categoria;

	}

	public List<Categoria> buscarTudo() {
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}

	public Categoria inserirCategoria(Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	public Categoria deletarCategoria(Integer codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
				return categoria.get();
		
	}

}
