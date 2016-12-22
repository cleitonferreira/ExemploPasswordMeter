package br.com.passwordmeter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.passwordmeter.model.Pontuacao;
import br.com.passwordmeter.service.PasswordService;

public class NumeroCaracterTest {

	private PasswordService passwordService;

	public static String senha = "!@s3curity";

	@Before
	public void setUp() {
		this.passwordService = new PasswordService();
	}

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
