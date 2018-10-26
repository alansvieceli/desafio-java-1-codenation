package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeuTimeInterface time = new DesafioMeuTimeApplication();

		try {
			time.incluirTime(1L, "GRÊMIO", LocalDate.now(), "AZUL", "PRETO");
			time.incluirTime(2L, "INTERNACIONAL", LocalDate.now(), "VERMELHO", "BRANCO");
			time.incluirTime(3L, "PALMEIRAS", LocalDate.now(), "VERDE", "BRANCO");
			time.incluirTime(4L, "CORINTHIANS", LocalDate.now(), "BRANCO", "PRETO");
		} catch (IdentificadorUtilizadoException e) {
			System.err.println(e.getMessage());
		}

		try {
			time.incluirJogador(1L, 1L, "ALAN", LocalDate.of(1982, 05, 20), 88, new BigDecimal("88"));
			time.incluirJogador(2L, 1L, "JAQUE", LocalDate.of(1983, 01, 21), 90, new BigDecimal("500"));
			time.incluirJogador(4L, 1L, "GRAZI", LocalDate.of(1979, 01, 04), 84, new BigDecimal("40"));
			time.incluirJogador(5L, 1L, "IRCEU", LocalDate.of(1953, 03, 01), 188, new BigDecimal("180"));
			time.incluirJogador(3L, 1L, "ROSA", LocalDate.of(1953, 04, 01), 44, new BigDecimal("130"));
			
			time.incluirJogador(9L, 2L, "ROSA II", LocalDate.of(1953, 04, 21), 88, new BigDecimal("130"));
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		} catch (IdentificadorUtilizadoException e) {
			System.err.println(e.getMessage());
		}

		try {
			time.definirCapitao(3L);
		} catch (JogadorNaoEncontradoException e) {
			System.err.println(e.getMessage());
		}
		
		try {			
			
			System.out.println("Capitão: " + time.buscarCapitaoDoTime(1L));
			
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		} catch (CapitaoNaoInformadoException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			System.out.println("Nome: " + time.buscarNomeJogador(3L));
		} catch (JogadorNaoEncontradoException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			System.out.println("Time: " + time.buscarNomeTime(3L));			
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		};
		
		try {
			List<Long> lista = time.buscarJogadoresDoTime(1L);
			lista.forEach(System.out::println);
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		};
		
		try {
			System.out.println("Melhor jogador: " + time.buscarMelhorJogadorDoTime(1L));			
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		};
		
		try {
			System.out.println("Jogador mais velho: " + time.buscarJogadorMaisVelho(1L));			
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		};
		
		try {
			List<Long> lista = time.buscarJogadoresDoTime(1L);
			lista.forEach(System.out::println);
		} catch (TimeNaoEncontradoException e) {
			System.err.println(e.getMessage());
		};

		System.out.println("Chegou ao fim");

	}

}
