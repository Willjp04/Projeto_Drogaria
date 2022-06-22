package br.sostenes.willian.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.sostenes.willian.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	@Autowired // O AUTOWIRED SERVE PARA O SPRING GERENCIAR O OBJETO, ELE VAI INJETAR UMA
				// INSTANCIA NESTE OBJETO
	private ProdutoRepository produtoRepository;

	@Test
	public void inserir() {
		Produto p1 = new Produto(null, "Coca-cola", 5, BigDecimal.valueOf(10.50), LocalDate.of(2022, 9, 20));

		Produto p2 = new Produto(null, "Fanta", 4, BigDecimal.valueOf(8.50), LocalDate.of(2022, 10, 20));
		
		Produto p3 = new Produto(null, "Sukita", 2, BigDecimal.valueOf(6.50), LocalDate.of(2022, 12, 15));

		
		//AQUI EU CHAMEI A INTERFACE PARA SALVAR AS ENTIDADES CRIADAS.
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
	}

}
