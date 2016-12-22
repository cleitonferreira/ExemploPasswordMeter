package br.com.passwordmeter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.passwordmeter.model.Pontuacao;

@Service
public class PasswordService {

	private static final int ZERO = 0;
	public static final int PONTUACAO_MINIMA = 21;
	public static final int PONTUACAO_BOA = 41;
	public static final int PONTUACAO_FORTE = 61;
	public static final int PONTUACAO_MUITO_FORTE = 81;
	public static final int PONTUCAO_MAXIMA = 100;

	public static final int REQUISITO_MINIMO = 3;
	public static final int COMPRIMENTO_MINIMO = 8;
	public static final String LETRAS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMEROS = "01234567890";
	public static final String SIMBOLOS = ")!@#$%^&*()";

	private char[] password;
	private String passwordAsString;
	private String passwordLowercase;

	// adições
	private int maiuscula;
	private int minuscula;
	private int numero;
	private int simbolo;
	private int numeroSimbolo;
	private int requisito;

	// deduções
	private int letraMaiusculaConsecutiva;
	private int letraMinusculaConsecutiva;
	private int numeroConsecutivo;
	private int letraSequencial;
	private int numeroSequencial;
	private int simboloSequencial;

	@Autowired
	Pontuacao pontuacao;

	public Pontuacao verifica(String password) {
		this.password = password.toCharArray();
		this.passwordAsString = password;
		this.passwordLowercase = password.toLowerCase();
		int maiuscula = 0;
		int minuscula = 0;
		int numero = 0;
		int simbolo = 0;
		int numeroSimbolo = 0;
		int letraMaiusculaConsecutiva = 0;
		int letraMinusculaConsecutiva = 0;
		int numeroConsecutivo = 0;
		char anterior = ' ';

		for (int i = 0; i < password.length(); i++) {
			final char c = password.charAt(i);

			if (Character.isLetter(c)) { // Letra
				if (Character.isUpperCase(c)) {
					maiuscula++; // Maiúscula
					if (Character.isUpperCase(anterior))
						letraMaiusculaConsecutiva++;
				} else if (Character.isLowerCase(c)) {
					minuscula++; // Minúscula
					if (Character.isLowerCase(anterior))
						letraMinusculaConsecutiva++;
				}
			} else if (Character.isDigit(c)) {
				numero++; // Dígito
				if (i > 0 && (i + 1) != password.length())
					numeroSimbolo++;
				if (Character.isDigit(anterior))
					numeroConsecutivo++;
			} else if (contemSimbolo(c)) {
				simbolo++; // Símbolo
				if (i > 0 && (i + 1) != password.length()) {
					numeroSimbolo++;
				}
			}
			anterior = c;
		}
		this.maiuscula = maiuscula;
		this.minuscula = minuscula;
		this.numero = numero;
		this.simbolo = simbolo;
		this.numeroSimbolo = numeroSimbolo;
		this.requisito = getContagemRequisitos();
		this.letraMinusculaConsecutiva = letraMinusculaConsecutiva;
		this.letraMaiusculaConsecutiva = letraMaiusculaConsecutiva;
		this.numeroConsecutivo = numeroConsecutivo;
		int letraSequencial = ZERO;
		int numeroSequencial = ZERO;
		int simboloSequencial = ZERO;

		// buscar letras sequenciais
		for (int i = 0; i < (LETRAS.length() - 3); i++) {
			if (passwordLowercase.contains(LETRAS.substring(i, (i + 3)))) {
				letraSequencial++;
			}
		}
		for (int i = 0; i < (LETRAS.length() - 3); i++) {
			if (passwordLowercase.contains(new StringBuilder(LETRAS).reverse().toString().substring(i, (i + 3)))) {
				letraSequencial++;
			}
		}
		// buscar símbolos sequenciais
		for (int i = 0; i < (SIMBOLOS.length() - 3); i++) {
			if (passwordAsString.contains(SIMBOLOS.substring(i, (i + 3)))) {
				simboloSequencial++;
			}
		}
		for (int i = 0; i < (SIMBOLOS.length() - 3); i++) {
			if (passwordAsString.contains(new StringBuilder(SIMBOLOS).reverse().toString().substring(i, (i + 3)))) {
				simboloSequencial++;
			}
		}
		// buscar números sequenciais
		for (int i = 0; i < (NUMEROS.length() - 3); i++) {
			if (passwordAsString.contains(NUMEROS.substring(i, (i + 3)))) {
				numeroSequencial++;
			}
		}
		for (int i = 0; i < (NUMEROS.length() - 3); i++) {
			if (passwordAsString.contains(new StringBuilder(NUMEROS).reverse().toString().substring(i, (i + 3)))) {
				numeroSequencial++;
			}
		}
		this.letraSequencial = letraSequencial;
		this.simboloSequencial = simboloSequencial;
		this.numeroSequencial = numeroSequencial;

		return atualizarPontuacao();
	}
	
	private Pontuacao atualizarPontuacao() {

		//Pontuacao pontuacao = new Pontuacao();
		
		pontuacao.setPontuacao(this.getPontuacao());
		pontuacao.setComplexidade(this.getComplexidade());

		// adições
		pontuacao.setQuantNumeroCaracter(this.comprimento());
		pontuacao.setValorNumeroCaracter(this.getBonusNumeroCaracter());
		pontuacao.setQuantMaiuscula(this.getMaiuscula());
		pontuacao.setValorMaiuscula(this.getBonusMaiuscula());
		pontuacao.setQuantMinuscula(this.getMinuscula());
		pontuacao.setValorMinuscula(this.getBonusMinuscula());
		pontuacao.setQuantNumero(this.getNumero());
		pontuacao.setValorNumero(this.getBonusNumero());
		pontuacao.setQuantSimbolo(this.getSimbolo());
		pontuacao.setValorSimbolo(this.getBonusSimbolo());
		pontuacao.setNumeroSimbolo(this.getNumeroSimbolo());
		pontuacao.setValorNumeroSimbolo(this.getBonusNumeroSimbolo());
		pontuacao.setQuantRequisito(this.getRequisito());
		pontuacao.setValorRequisito(this.getBonusRequisito());

		// deduções
		pontuacao.setQuantLetra(this.getQuantidadeLetras());
		pontuacao.setValorLetra(this.getBonusSomenteLetras());
		pontuacao.setQuantApenasNumero(this.getSomenteNumeros());
		pontuacao.setValorApenasNumero(this.getBonusSomenteNumeros());
		pontuacao.setQuantCaractereRepetido(this.getCaracterRepetido());
		pontuacao.setQuantMaiusculaConsecutiva(this.getLetraMaiusculaConsecutiva());
		pontuacao.setValorMaiusculaConsecutiva(this.getBonusLetrasMaiusculasConsecutivas());
		pontuacao.setQuantMinusculaConsecutiva(this.getLetraMinusculaConsecutiva());
		pontuacao.setValorMinusculaConsecutiva(this.getBonusLetrasMinusculasConsecutivas());
		pontuacao.setQuantNumeroConsecutivo(this.getNumeroConsecutivo());
		pontuacao.setValorNumeroConsecutivo(this.getBonusNumerosConsecutivos());
		pontuacao.setQuantLetraSequencial(this.getLetraSequencial());
		pontuacao.setValorLetraSequencial(this.getBonusLetrasSequenciais());
		pontuacao.setQuantNumeroSequencial(this.getNumeroSequencial());
		pontuacao.setValorNumeroSequencial(this.getBonusNumerosSequenciais());
		pontuacao.setQuantSimboloSequencial(this.getSimboloSequencial());
		pontuacao.setValorSimboloSequencial(this.getBonusSimbolosSequenciais());

		return pontuacao;
	}

	public int getContagemRequisitos() {
		int requisitos = 0;
		if (comprimentoMinimo())
			requisitos++;
		if (contemLetrasMaiusculas())
			requisitos++;
		if (contemLetrasMinusculas())
			requisitos++;
		if (contemNumeros())
			requisitos++;
		if (contemSimbolos())
			requisitos++;
		return requisitos;
	}

	private boolean contemLetrasMaiusculas() {
		return maiuscula > 0;
	}

	private boolean contemLetrasMinusculas() {
		return minuscula > 0;
	}

	private boolean contemNumeros() {
		return numero > 0;
	}

	private boolean contemSimbolos() {
		return simbolo > 0;
	}

	public int getLetraMinusculaConsecutiva() {
		return letraMinusculaConsecutiva;
	}

	public int getLetraMaiusculaConsecutiva() {
		return letraMaiusculaConsecutiva;
	}

	public int getNumeroConsecutivo() {
		return numeroConsecutivo;
	}

	public int getBonusLetrasMinusculasConsecutivas() {
		return letraMinusculaConsecutiva * 2;
	}

	public int getBonusLetrasMaiusculasConsecutivas() {
		return letraMaiusculaConsecutiva * 2;
	}

	public int getBonusNumerosConsecutivos() {
		return numeroConsecutivo * 2;
	}

	public int getLetraSequencial() {
		return this.letraSequencial;
	}

	public int getBonusLetrasSequenciais() {
		return this.letraSequencial * 3;
	}

	public int getNumeroSequencial() {
		return this.numeroSequencial;
	}

	public int getBonusNumerosSequenciais() {
		return this.numeroSequencial * 3;
	}

	public int getSimboloSequencial() {
		return this.simboloSequencial;
	}

	public int getBonusSimbolosSequenciais() {
		return this.simboloSequencial * 3;
	}

	public int getMaiuscula() {
		return maiuscula;
	}

	public int getMinuscula() {
		return minuscula;
	}

	public int getNumero() {
		return numero;
	}

	public int getSimbolo() {
		return simbolo;
	}

	public int getNumeroSimbolo() {
		return numeroSimbolo;
	}

	public int getRequisito() {
		return requisito;
	}

	public int comprimento() {
		return this.password.length;
	}

	public boolean comprimentoMinimo() {
		return this.password.length >= 8;
	}

	public int getBonusNumeroCaracter() {
		return password.length * 4;
	}

	public int getBonusMaiuscula() {
		if (requisito < 2)
			return ZERO;
		if (maiuscula > 0)
			return (this.comprimento() - maiuscula) * 2;
		return 0;
	}

	public int getBonusMinuscula() {
		if (requisito < 2)
			return ZERO;
		if (minuscula > ZERO)
			return (this.comprimento() - minuscula) * 2;
		return ZERO;
	}

	public int getBonusNumeroSimbolo() {
		return numeroSimbolo * 2;
	}

	public int getBonusNumero() {
		if (requisito < 2)
			return ZERO;
		return numero * 4;
	}

	public int getBonusSimbolo() {
		if (requisito < 2)
			return ZERO;
		return simbolo * 6;
	}

	public int getBonusRequisito() {
		if (requisito > REQUISITO_MINIMO && comprimento() >= COMPRIMENTO_MINIMO)
			return requisito * 2;
		return ZERO;
	}

	public int getBonusTotalAdicoes() {
		return getBonusNumeroCaracter() + getBonusMaiuscula() + getBonusMinuscula() + getBonusNumero() + getBonusSimbolo()
				+ getBonusNumeroSimbolo() + getBonusRequisito();
	}

	public int getQuantidadeLetras() {
		if ((maiuscula + minuscula) == comprimento())
			return comprimento();
		return ZERO;
	}

	public int getBonusSomenteLetras() {
		return (numero == ZERO && simbolo == ZERO) ? comprimento() : 0;
	}

	public int getSomenteNumeros() {
		if (numero == comprimento())
			return comprimento();
		return ZERO;
	}

	public int getBonusSomenteNumeros() {
		return (numero == comprimento()) ? comprimento() : 0;
	}

	public int getCaracterRepetido() {
		int repetido = ZERO;
		final List<Character> prev = new ArrayList<Character>();
		for (char c : password) {
			if (prev.contains(c))
				repetido++;
			prev.add(c);
		}
		return repetido;
	}

	public int getPontuacao() {
		int parcial = getBonusTotalAdicoes() - getBonusTotalDeducoes();
		if (parcial > PONTUCAO_MAXIMA) {
			return PONTUCAO_MAXIMA;
		}
		if (parcial > ZERO)
			return parcial;
		return ZERO;
	}

	public int getBonusTotalDeducoes() {
		return getBonusSomenteNumeros() + getBonusSomenteLetras() + getBonusLetrasMinusculasConsecutivas()
				+ getBonusLetrasMaiusculasConsecutivas() + getBonusNumerosConsecutivos();
	}

	public String getComplexidade() {
		int pontuacao = getPontuacao();
		if (pontuacao < PONTUACAO_MINIMA)
			return "Muito fraco";
		if (pontuacao >= PONTUACAO_MINIMA && pontuacao < PONTUACAO_BOA)
			return "Fraco";
		if (pontuacao >= PONTUACAO_BOA && pontuacao < PONTUACAO_FORTE)
			return "Bom";
		if (pontuacao >= PONTUACAO_FORTE && pontuacao < PONTUACAO_MUITO_FORTE)
			return "Forte";
		if (pontuacao >= PONTUACAO_MUITO_FORTE)
			return "Muito forte";
		return "Algo deu errado";
	}

	public boolean contemSimbolo(char c) {
		return !Character.isAlphabetic(c) && !Character.isDigit(c) && !Character.isWhitespace(c) && c != '_'; 
	}

}