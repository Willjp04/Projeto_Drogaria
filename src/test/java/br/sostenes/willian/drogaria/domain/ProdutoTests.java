package br.sostenes.willian.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.sostenes.willian.drogaria.service.CategoriaService;

@SpringBootTest
public class ProdutoTests {

	@Test
	public void criar() {
		
Produto p = new Produto(1, "Coca-cola", 5, BigDecimal.valueOf(10.50), LocalDate.of(2022, 06, 20));
	}
}