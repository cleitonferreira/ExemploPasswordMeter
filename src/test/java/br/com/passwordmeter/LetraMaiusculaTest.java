package br.com.passwordmeter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.passwordmeter.model.Pontuacao;
import br.com.passwordmeter.service.PasswordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PasswordService.class, Pontuacao.class})
public class LetraMaiusculaTest {

	@Autowired
	private PasswordService passwordService;

	public static String senha = "!@s3curity";

	@Test
	public void verificaLetraMaiuscula() {

		Pontuacao p = passwordService.verifica(senha);

		assertEquals(0, p.getQuantMaiuscula());
	}

	@Test
	public void verificaBonusLetraMaiuscula() {

		Pontuacao p = passwordService.verifica(senha);

		assertEquals(0, p.getValorMaiuscula());
	}
	
}
