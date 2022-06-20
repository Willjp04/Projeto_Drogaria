package br.sostenes.willian.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//PODEMOS UTILIZAR AS ANOTAÇÕES SEPARADAS TAMBÉM

// ABAIXO TODAS AS ANOTAÇÕES SÃO DO LOMBOK

@Data // ESTA ANOTAÇÃO DATA É DO LOMBOK QUE CRIA OS MÉTODOS CONSTRUTOR, GETTERS,
		// SETTERS, HASH, EQUALS.
@NoArgsConstructor // ESTA ANOTAÇÃO É PARA UTILIZAR O CONSTRUTOR PADRÃO
@AllArgsConstructor // ESTA ANOTAÇÃO É PARA UTILIZAR O CONSTRUTOR COM TODOS OS ATRIBUTOS.
@Entity // ESTA ANOTAÇÃO INFORMA QUE ESSA CLASSE É UMA TABELA NO BANCO DE DADOS
public class Produto {

	@Id // ESTA ANOTAÇÃO SERVE PARA INFORMAR QUE ESTE ATRIBUTO É A CHAVE PRIMÁRIA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ESTA ANOTAÇÃO VAI ATRIBUIR UMA CHAVE PRIMÁRIA AUTOMÁTICA PARA O ATRIBUTO
	private Integer codigo;

	
	@Column(length = 50, nullable = false,unique = true) // ESTA ANOTAÇÃO SERVE PARA INDICAR QUE ESTE ATRIBUTO SERÁ UMA COLUNA 
	//O LENGTH É PARA INDICAR O TAMANHO MÁXIMO DE CARACTERES
	//O NULLABLE COMO FALSE INDICA QUE ESTE ATRIBUTO É DE PREENCHIMENTO OBRIGATÓRIO
	//O UNIQUE COMO TRUE É PARA INDICAR QUE O NOME NÃO PODE SE REPETIR
	private String nome;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false, precision = 5,scale = 2)
	//O PRECISION INDICA A QUANTIDADE DE NÚMEROS TOTAIS
	//O SCALE INDICA A QUANTIDADE DE NÚMEROS TOTAIS DEPOIS DA VIRGULA
	// NO CASO ACIMA FICARÁ NO MÁXIMO DE 999,99 REAIS
	private BigDecimal preco;
	
	@Column
	private LocalDate dataDeValidade;
	
	@ManyToOne // ESTA ANOTAÇÃO É A CHAVE ESTRANGEIRA QUE LIGA A CLASSE PRODUTO NA CLASSE CATEGORIA SENDO MUITOS PARA UM MUITOS PRODUTOS LIGAM PARA UMA CATEGORIA
	@JoinColumn(nullable = false) //ESTA ANOTAÇÃO É COMO O COLUNM MAS PARA CHAVE ESTRANGEIRA.
	private Categoria categoria;

}
