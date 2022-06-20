package br.sostenes.willian.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {

	private Integer codigo;
	private String nome;
	private Integer quantidade;
	private BigDecimal preco;

	private LocalDate dataDeValidade;

}
