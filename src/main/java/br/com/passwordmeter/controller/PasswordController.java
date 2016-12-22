package br.com.passwordmeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.passwordmeter.model.Pontuacao;
import br.com.passwordmeter.service.PasswordService;

@RestController
@RequestMapping("/passwordmeter")
public class PasswordController {

	@Autowired
	private PasswordService passwordService;

	@RequestMapping(value = "/verifica",method = RequestMethod.POST)
	public @ResponseBody Pontuacao alterar(@RequestParam String password) {

		return passwordService.verifica(password);
	}

}
