package br.sostenes.willian.drogaria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sostenes.willian.drogaria.domain.Produto;

//A INTERFACE REPOSITORY É ONDE FICARÁ AS INSERÇÕES, DELEÇÕES E ALTERAÇÕES DO BANCO DE DADOS
//UTILIZAMOS O EXTENDS JPAREPOSITORY E REFERENCIAMOS A CLASSE, E O TIPO DA CHAVE PRIMARIA, NESTE CASO SENDO A CLASSE PRODUTO, E O TIPO DA CHAVE PRIMARIA INTEGER.
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	
	@Query(value = "select u from Produto u where u.nome like %?1%")
	List<Produto> buscarPorNome(String nome);

	
	
	
}
