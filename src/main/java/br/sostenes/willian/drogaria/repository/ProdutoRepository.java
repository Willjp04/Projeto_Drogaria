package br.sostenes.willian.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sostenes.willian.drogaria.domain.Produto;

//A INTERFACE REPOSITORY É ONDE FICARÁ AS INSERÇÕES, DELEÇÕES E ALTERAÇÕES DO BANCO DE DADOS
//UTILIZAMOS O EXTENDS JPAREPOSITORY E REFERENCIAMOS A CLASSE, E O TIPO DA CHAVE PRIMARIA, NESTE CASO SENDO A CLASSE PRODUTO, E O TIPO DA CHAVE PRIMARIA INTEGER.

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
