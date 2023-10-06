package br.com.ouvidoria.entidades;

public class Manifestacao {

	private int codigo;
	private String reclamante;
	private String titulo;
	private String descricao;

	
	private SituacaoManifesto situacao;
	
	private Tipo tipoManifestacao;
	private static int contador = 1;

	// Construtor com reclamante
	public Manifestacao(String reclamante, String titulo, String descricao, Tipo tipoManifestacao) {
		super();
		this.codigo = contador++;
		this.reclamante = reclamante;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipoManifestacao = tipoManifestacao;
		this.situacao = SituacaoManifesto.EM_ABERTO;
	}

	// Construtor sem reclamante
	public Manifestacao(String titulo, String descricao, Tipo tipoManifestacao) {
		super();
		this.codigo = contador++;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipoManifestacao = tipoManifestacao;
		this.situacao = SituacaoManifesto.EM_ABERTO;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getReclamante() {
		return reclamante;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo getTipoManifestacao() {
		return tipoManifestacao;
	}

	public SituacaoManifesto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoManifesto situacao) {
		this.situacao = situacao;
	}

	
	// Usando um enum iremos pegar só valores que sabemos quais são
	protected enum SituacaoManifesto {
		EM_ABERTO, EM_ATENDIMENTO, FINALIZADO;
	}

	// Mesmo objetivo do enum de cima, mas ele será usado foram dessa classe
	//(Indicando qual tipo ela será na hora de instanciar
	public enum Tipo {
		RECLAMACAO, SUGESTAO, ELOGIO;
	}

}
