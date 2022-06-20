package br.sostenes.willian.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//PODEMOS UTILIZAR AS ANOTAÇÕES SEPARADAS TAMBÉM

// ABAIXO TODAS AS ANOTAÇÕES SÃO DO LOMBOK

@Data //ESTA ANOTAÇÃO DATA É DO LOMBOK QUE CRIA OS MÉTODOS CONSTRUTOR, GETTERS, SETTERS, HASH, EQUALS.
@NoArgsConstructor // ESTA ANOTAÇÃO É PARA UTILIZAR O CONSTRUTOR PADRÃO
@AllArgsConstructor // ESTA ANOTAÇÃO É PARA UTILIZAR O CONSTRUTOR COM TODOS OS ATRIBUTOS.
public class Produto {

	
	private Integer codigo;
	private String nome;
	private Integer quantidade;
	private BigDecimal preco;

	private LocalDate dataDeValidade;

}
