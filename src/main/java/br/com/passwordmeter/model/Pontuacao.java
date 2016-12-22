package br.com.passwordmeter.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Pontuacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int pontuacao;
	private String complexidade;
	
	// Adições
	private int quantNumeroCaracter;
	private int valorNumeroCaracter;
	private int quantMaiuscula;
	private int valorMaiuscula;
	private int quantMinuscula;
	private int valorMinuscula;
	private int quantNumero;
	private int valorNumero;
	private int quantSimbolo;
	private int valorSimbolo;
	private int numeroSimbolo;
	private int valorNumeroSimbolo;
	private int quantRequisito;
	private int valorRequisito;
	
	// Deduções
	private int quantLetra;
	private int valorLetra;
	private int quantApenasNumero;
	private int valorApenasNumero;
	private int quantCaractereRepetido;
	private int valorCaractereRepetido;
	private int quantMaiusculaConsecutiva;
	private int valorMaiusculaConsecutiva;
	private int quantMinusculaConsecutiva;
	private int valorMinusculaConsecutiva;
	private int quantNumeroConsecutivo;
	private int valorNumeroConsecutivo;
	private int quantLetraSequencial;
	private int valorLetraSequencial;
	private int quantNumeroSequencial;
	private int valorNumeroSequencial;
	private int quantSimboloSequencial;
	private int valorSimboloSequencial;
	
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getComplexidade() {
		return complexidade;
	}
	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}
	public int getQuantNumeroCaracter() {
		return quantNumeroCaracter;
	}
	public void setQuantNumeroCaracter(int quantNumeroCaracter) {
		this.quantNumeroCaracter = quantNumeroCaracter;
	}
	public int getValorNumeroCaracter() {
		return valorNumeroCaracter;
	}
	public void setValorNumeroCaracter(int valorNumeroCaracter) {
		this.valorNumeroCaracter = valorNumeroCaracter;
	}
	public int getQuantMaiuscula() {
		return quantMaiuscula;
	}
	public void setQuantMaiuscula(int quantMaiuscula) {
		this.quantMaiuscula = quantMaiuscula;
	}
	public int getValorMaiuscula() {
		return valorMaiuscula;
	}
	public void setValorMaiuscula(int valorMaiuscula) {
		this.valorMaiuscula = valorMaiuscula;
	}
	public int getQuantMinuscula() {
		return quantMinuscula;
	}
	public void setQuantMinuscula(int quantMinuscula) {
		this.quantMinuscula = quantMinuscula;
	}
	public int getValorMinuscula() {
		return valorMinuscula;
	}
	public void setValorMinuscula(int valorMinuscula) {
		this.valorMinuscula = valorMinuscula;
	}
	public int getQuantNumero() {
		return quantNumero;
	}
	public void setQuantNumero(int quantNumero) {
		this.quantNumero = quantNumero;
	}
	public int getValorNumero() {
		return valorNumero;
	}
	public void setValorNumero(int valorNumero) {
		this.valorNumero = valorNumero;
	}
	public int getQuantSimbolo() {
		return quantSimbolo;
	}
	public void setQuantSimbolo(int quantSimbolo) {
		this.quantSimbolo = quantSimbolo;
	}
	public int getValorSimbolo() {
		return valorSimbolo;
	}
	public void setValorSimbolo(int valorSimbolo) {
		this.valorSimbolo = valorSimbolo;
	}
	public int getNumeroSimbolo() {
		return numeroSimbolo;
	}
	public void setNumeroSimbolo(int numeroSimbolo) {
		this.numeroSimbolo = numeroSimbolo;
	}
	public int getValorNumeroSimbolo() {
		return valorNumeroSimbolo;
	}
	public void setValorNumeroSimbolo(int valorNumeroSimbolo) {
		this.valorNumeroSimbolo = valorNumeroSimbolo;
	}
	public int getQuantRequisito() {
		return quantRequisito;
	}
	public void setQuantRequisito(int quantRequisito) {
		this.quantRequisito = quantRequisito;
	}
	public int getValorRequisito() {
		return valorRequisito;
	}
	public void setValorRequisito(int valorRequisito) {
		this.valorRequisito = valorRequisito;
	}
	public int getQuantLetra() {
		return quantLetra;
	}
	public void setQuantLetra(int quantLetra) {
		this.quantLetra = quantLetra;
	}
	public int getValorLetra() {
		return valorLetra;
	}
	public void setValorLetra(int valorLetra) {
		this.valorLetra = valorLetra;
	}
	public int getQuantApenasNumero() {
		return quantApenasNumero;
	}
	public void setQuantApenasNumero(int quantApenasNumero) {
		this.quantApenasNumero = quantApenasNumero;
	}
	public int getValorApenasNumero() {
		return valorApenasNumero;
	}
	public void setValorApenasNumero(int valorApenasNumero) {
		this.valorApenasNumero = valorApenasNumero;
	}
	public int getQuantCaractereRepetido() {
		return quantCaractereRepetido;
	}
	public void setQuantCaractereRepetido(int quantCaractereRepetido) {
		this.quantCaractereRepetido = quantCaractereRepetido;
	}
	public int getValorCaractereRepetido() {
		return valorCaractereRepetido;
	}
	public void setValorCaractereRepetido(int valorCaractereRepetido) {
		this.valorCaractereRepetido = valorCaractereRepetido;
	}
	public int getQuantMaiusculaConsecutiva() {
		return quantMaiusculaConsecutiva;
	}
	public void setQuantMaiusculaConsecutiva(int quantMaiusculaConsecutiva) {
		this.quantMaiusculaConsecutiva = quantMaiusculaConsecutiva;
	}
	public int getValorMaiusculaConsecutiva() {
		return valorMaiusculaConsecutiva;
	}
	public void setValorMaiusculaConsecutiva(int valorMaiusculaConsecutiva) {
		this.valorMaiusculaConsecutiva = valorMaiusculaConsecutiva;
	}
	public int getQuantMinusculaConsecutiva() {
		return quantMinusculaConsecutiva;
	}
	public void setQuantMinusculaConsecutiva(int quantMinusculaConsecutiva) {
		this.quantMinusculaConsecutiva = quantMinusculaConsecutiva;
	}
	public int getValorMinusculaConsecutiva() {
		return valorMinusculaConsecutiva;
	}
	public void setValorMinusculaConsecutiva(int valorMinusculaConsecutiva) {
		this.valorMinusculaConsecutiva = valorMinusculaConsecutiva;
	}
	public int getQuantNumeroConsecutivo() {
		return quantNumeroConsecutivo;
	}
	public void setQuantNumeroConsecutivo(int quantNumeroConsecutivo) {
		this.quantNumeroConsecutivo = quantNumeroConsecutivo;
	}
	public int getValorNumeroConsecutivo() {
		return valorNumeroConsecutivo;
	}
	public void setValorNumeroConsecutivo(int valorNumeroConsecutivo) {
		this.valorNumeroConsecutivo = valorNumeroConsecutivo;
	}
	public int getQuantLetraSequencial() {
		return quantLetraSequencial;
	}
	public void setQuantLetraSequencial(int quantLetraSequencial) {
		this.quantLetraSequencial = quantLetraSequencial;
	}
	public int getValorLetraSequencial() {
		return valorLetraSequencial;
	}
	public void setValorLetraSequencial(int valorLetraSequencial) {
		this.valorLetraSequencial = valorLetraSequencial;
	}
	public int getQuantNumeroSequencial() {
		return quantNumeroSequencial;
	}
	public void setQuantNumeroSequencial(int quantNumeroSequencial) {
		this.quantNumeroSequencial = quantNumeroSequencial;
	}
	public int getValorNumeroSequencial() {
		return valorNumeroSequencial;
	}
	public void setValorNumeroSequencial(int valorNumeroSequencial) {
		this.valorNumeroSequencial = valorNumeroSequencial;
	}
	public int getQuantSimboloSequencial() {
		return quantSimboloSequencial;
	}
	public void setQuantSimboloSequencial(int quantSimboloSequencial) {
		this.quantSimboloSequencial = quantSimboloSequencial;
	}
	public int getValorSimboloSequencial() {
		return valorSimboloSequencial;
	}
	public void setValorSimboloSequencial(int valorSimboloSequencial) {
		this.valorSimboloSequencial = valorSimboloSequencial;
	}
	
}