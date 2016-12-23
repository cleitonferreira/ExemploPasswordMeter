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
public class LetraMinusculaTest {

	@Autowired
	private PasswordService passwordService;

	public static String senha = "!@s3curity";

	@Test
	public void verificaLetraMinuscula() {

		Pontuacao p = passwordService.verifica(senha);

		assertEquals(7, p.getQuantMinuscula());
	}

	@Test
	public void verificaBonusLetraMinuscula() {

		Pontuacao p = passwordService.verifica(senha);

		assertEquals(6, p.getValorMinuscula());
	}
	
}
