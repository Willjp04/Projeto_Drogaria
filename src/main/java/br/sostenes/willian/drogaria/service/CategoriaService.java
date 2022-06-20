package br.sostenes.willian.drogaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sostenes.willian.drogaria.domain.Categoria;
import br.sostenes.willian.drogaria.exception.RecursoNaoEncontradoException;
import br.sostenes.willian.drogaria.repository.CategoriaRepository;

//ESTA CLASSE 

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscarPorCodigo(Integer codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);

		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();

		}
		Categoria categoria = resultado.get();
		return categoria;

	}
}
