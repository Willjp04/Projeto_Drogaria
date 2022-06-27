package br.sostenes.willian.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sostenes.willian.drogaria.domain.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
