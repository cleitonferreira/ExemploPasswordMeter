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
public class NumeroCaracterTest {

	@Autowired
	private PasswordService passwordService;

	public static String senha = "!@s3curity";

	@Test
	public void verificaNumerosCaracters() {

		Pontuacao p = passwordService.verifica(senha);

		assertEquals(10, p.getQuantNumeroCaracter());
	}

	@Test
	public void verificaBonusNumerosCaracters() {

		Pontuacao p = passwordService.verifica(senha);

		assertEquals(40, p.getValorNumeroCaracter());
	}
	
}
