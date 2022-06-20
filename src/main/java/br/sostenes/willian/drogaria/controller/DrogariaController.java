package br.sostenes.willian.drogaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ESTA É MINHA CLASSE PARA CONTROLE

// A ANOTAÇÃO RESTCONTROLLER É PARA INFORMAR QUE ESSA CLASSE É UM CONTROLADOR
//ENTRE PARENTESES EU VOU COLOCAR O CAMINHO QUANOD EU QUISER CHAMAR ESTE CONTROLADOR
@RestController
@RequestMapping("/drogaria")
public class DrogariaController {

	// A ANOTAÇÃO REQUESTMAPPING SERVE PARA TRANSFORMAR UM MÉTODO EM SERVIÇO
	// E TAMBÉM PRECISA DE UMA ANOTAÇÃO
	@RequestMapping("/ola")
	public String retornaMensagem() {
		return "Olá drogaria";
	}

}
