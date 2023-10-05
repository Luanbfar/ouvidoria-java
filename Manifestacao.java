package br.com.ouvidoriafase2.entidades;

public class Manifestacao {
	private String reclamante;
	private String titulo;
	private String descricao;
	private int codigo;
	private String situacao; // EM_ABERTO, EM_ANDAMENTO, FINALIZADO.
	private String tipoManifestacao; // Elogio, Sugestao ou Reclamacao.

	private static int cont; //Está incrementado, então não precisa de getters / setters

	public Manifestacao(String reclamante, String tipoManifestacao ,String titulo, String descricao) {
		this.reclamante = reclamante;
		this.tipoManifestacao = tipoManifestacao;
		this.titulo = titulo;
		this.descricao = descricao;

		this.codigo = cont++;
	
	}

	public String getReclamante() {
		return reclamante;
	}

	public void setReclamante(String reclamante) {
		this.reclamante = reclamante;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTipoManifestacao() {
		return tipoManifestacao;
	}

	public void setTipoManifestacao(String tipoManifestacao) {
		this.tipoManifestacao = tipoManifestacao;
	}


}