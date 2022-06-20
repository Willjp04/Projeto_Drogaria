package br.sostenes.willian.drogaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ESTA É MINHA CLASSE PARA CONTROLE
//ENTRE PARENTESES EU VOU COLOCAR O CAMINHO QUANOD EU QUISER CHAMAR ESTE CONTROLADOR

@RestController("/drogaria")
public class DrogariaController {

	@RequestMapping("/ola")
	public String retornaMensagem() {
		return "Olá Drigaria";
	}

}
