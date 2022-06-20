package br.sostenes.willian.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sostenes.willian.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
