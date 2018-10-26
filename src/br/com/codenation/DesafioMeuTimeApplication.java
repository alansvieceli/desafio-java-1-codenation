package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	public class Jogador {
		Long id;
		Long idTime;
		String nome;
		LocalDate dataNascimento;
		Integer nivelHabilidade;
		BigDecimal salario;
		boolean capitao = false;

		public Jogador() {
		}

		public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
				BigDecimal salario) {
			this.id = id;
			this.idTime = idTime;
			this.nome = nome;
			this.dataNascimento = dataNascimento;
			this.nivelHabilidade = nivelHabilidade;
			this.salario = salario;
		}

		public Jogador(Long id) {
			this.id = id;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getIdTime() {
			return idTime;
		}

		public void setIdTime(Long idTime) {
			this.idTime = idTime;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public LocalDate getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public Integer getNivelHabilidade() {
			return nivelHabilidade;
		}

		public void setNivelHabilidade(Integer nivelHabilidade) {
			this.nivelHabilidade = nivelHabilidade;
		}

		public BigDecimal getSalario() {
			return salario;
		}

		public void setSalario(BigDecimal salario) {
			this.salario = salario;
		}

		public boolean isCapitao() {
			return capitao;
		}

		public void setCapitao(boolean capitao) {
			this.capitao = capitao;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Jogador other = (Jogador) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		private DesafioMeuTimeApplication getOuterType() {
			return DesafioMeuTimeApplication.this;
		}

		@Override
		public String toString() {
			return "Jogador [id=" + id + ", idTime=" + idTime + ", nome=" + nome + ", dataNascimento=" + dataNascimento
					+ ", nivelHabilidade=" + nivelHabilidade + ", salario=" + salario + ", capitao=" + capitao + "]";
		}

	}

	public class Time {
		private Long id;
		private String nome;
		private LocalDate dataCriacao;
		private String corUniformePrincipal;
		private String corUniformeSecundario;

		public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
				String corUniformeSecundario) {
			this.id = id;
			this.nome = nome;
			this.dataCriacao = dataCriacao;
			this.corUniformePrincipal = corUniformePrincipal;
			this.corUniformeSecundario = corUniformeSecundario;
		}

		public Time(Long id) {
			this.id = id;
		}

		public Time() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public LocalDate getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDate dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public String getCorUniformePrincipal() {
			return corUniformePrincipal;
		}

		public void setCorUniformePrincipal(String corUniformePrincipal) {
			this.corUniformePrincipal = corUniformePrincipal;
		}

		public String getCorUniformeSecundario() {
			return corUniformeSecundario;
		}

		public void setCorUniformeSecundario(String corUniformeSecundario) {
			this.corUniformeSecundario = corUniformeSecundario;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Time other = (Time) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		private DesafioMeuTimeApplication getOuterType() {
			return DesafioMeuTimeApplication.this;
		}

	}

	private List<Time> listaTime = new ArrayList<>();
	private List<Jogador> listaJogadores = new ArrayList<>();

	private boolean validarTime(Long idTime) {
		Time time = new Time(idTime);
		int x = listaTime.indexOf(time);
		if (x < 0) {
			throw new TimeNaoEncontradoException("Time não cadastrado");
		}
		return true;
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {

		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		if (listaTime.contains(time)) {
			throw new IdentificadorUtilizadoException("Time já cadastrado");
		}

		listaTime.add(time);

	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {

		validarTime(idTime);

		Jogador j = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		if (listaJogadores.contains(j)) {
			throw new IdentificadorUtilizadoException("Jogador já cadastrado");
		}
		listaJogadores.add(j);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador j = new Jogador(idJogador);

		int x = listaJogadores.indexOf(j);

		if (x < 0) {
			throw new JogadorNaoEncontradoException("Jogador não cadastrado");
		}

		listaJogadores.get(x).setCapitao(true);

	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		validarTime(idTime);

		List<Jogador> listaJogadoresTime = listaJogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.collect(Collectors.toList());

		Optional<Jogador> jogadorOptional = listaJogadoresTime.stream().filter(c -> c.isCapitao()).findAny();

		if (!jogadorOptional.isPresent()) {
			throw new CapitaoNaoInformadoException("Time não possui capitão");
		}

		return jogadorOptional.get().getId();

	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		Optional<Jogador> jogadorOptional = listaJogadores.stream().filter(j -> j.getId().equals(idJogador)).findAny();

		if (!jogadorOptional.isPresent()) {
			throw new JogadorNaoEncontradoException("Jogador não encontrado");
		}

		return jogadorOptional.get().getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Optional<Time> timeOptional = listaTime.stream().filter(t -> t.getId().equals(idTime)).findAny();

		if (!timeOptional.isPresent()) {
			throw new TimeNaoEncontradoException("Time não encontrado");
		}

		return timeOptional.get().getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		validarTime(idTime);

		List<Jogador> listaDoTime = listaJogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.collect(Collectors.toList());
		List<Long> retorno = new ArrayList<>();

		for (Jogador p : listaDoTime) {
			retorno.add(p.getId());
		}

		return retorno.stream().sorted().collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		validarTime(idTime);

		List<Jogador> listaDoTime = listaJogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.collect(Collectors.toList());

		Optional<Jogador> jogador = listaDoTime.stream()
				.max((p1, p2) -> p1.getNivelHabilidade().compareTo(p2.getNivelHabilidade()));

		return jogador.get().getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		validarTime(idTime);

		List<Jogador> listaDoTime = listaJogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.collect(Collectors.toList());

		Comparator<Jogador> comp = (p1, p2) -> p1.getDataNascimento().compareTo(p2.getDataNascimento());
		Comparator<Jogador> comp2 = (p1, p2) -> p1.getId().compareTo(p2.getId());

		return listaDoTime.stream().sorted(comp2).sorted(comp).findFirst().get().getId();

	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Time> listaDoTime = listaTime.stream().sorted().collect(Collectors.toList());
		List<Long> retorno = new ArrayList<>();

		for (Time p : listaDoTime) {
			retorno.add(p.getId());
		}

		return retorno;

	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		validarTime(idTime);

		List<Jogador> listaDoTime = listaJogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.collect(Collectors.toList());

		Optional<Jogador> jogador = listaDoTime.stream().max((p1, p2) -> p1.getSalario().compareTo(p2.getSalario()));

		return jogador.get().getId();

	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		Optional<Jogador> jogadorOptional = listaJogadores.stream().filter(j -> j.getId().equals(idJogador)).findAny();

		if (!jogadorOptional.isPresent()) {
			throw new JogadorNaoEncontradoException("Jogador não encontrado");
		}

		return jogadorOptional.get().getSalario();

	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		Comparator<Jogador> comp = (p1, p2) -> p1.getNivelHabilidade().compareTo(p2.getNivelHabilidade());
		Comparator<Jogador> comp2 = (p1, p2) -> p1.getId().compareTo(p2.getId());
		
		List<Jogador> jogadores = listaJogadores.stream().sorted(comp2).sorted(comp).limit(top).collect(Collectors.toList());
		List<Long> lista = new ArrayList<>();

		for (Jogador p : jogadores) {
			lista.add(p.getId());
		}

		return lista;

	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		
		Optional<Time> timeCasa = listaTime.stream().filter(j -> j.getId().equals(timeDaCasa)).findAny();
		Optional<Time> timeFora = listaTime.stream().filter(j -> j.getId().equals(timeDeFora)).findAny();
		
		if (timeCasa.get().getCorUniformePrincipal() == timeFora.get().getCorUniformePrincipal()) {
			return timeFora.get().getCorUniformeSecundario();			
		} else {
			return timeFora.get().getCorUniformePrincipal();
		}
	}

}
