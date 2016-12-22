package br.com.passwordmeter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.passwordmeter.model.Pontuacao;
import br.com.passwordmeter.service.PasswordService;

public class LetraMaiusculaTest {

	private PasswordService passwordService;

	public static String senha = "!@s3curity";

	@Before
	public void setUp() {
		this.passwordService = new PasswordService();
	}

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
