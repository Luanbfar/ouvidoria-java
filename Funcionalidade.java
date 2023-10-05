package br.com.ouvidoriafase2.entidades;

import java.util.ArrayList;

public class Funcionalidade {

	private ArrayList<Manifestacao> listaElogios = new ArrayList<Manifestacao>();
	private ArrayList<Manifestacao> listaReclamacoes = new ArrayList<Manifestacao>();
	private ArrayList<Manifestacao> listaSugestoes = new ArrayList<Manifestacao>();

	public String menu() {
		String menu = """
					1) Listar manifestações.
					2) Listar reclamações.
					3) Listar sugestões.
					4) Listar elogios.
					5) Adicionar nova manifestação.
					6) Pesquisar manifestação por código.
					7) Remover manifestação por código.
					8) Alterar situação da manifestação.
					9) Sair do programa.
				""";
		return menu;
	}

	public void registrarManifestacao(String reclamante, String tipo, String titulo, String descricao) {
		Manifestacao manifestacao = new Manifestacao(reclamante, tipo, titulo, descricao);
		if (manifestacao != null && tipo.equalsIgnoreCase("elogio")) {
			listaElogios.add(manifestacao);
		} else if (manifestacao != null && tipo.equalsIgnoreCase("reclamacao")) {
			listaReclamacoes.add(manifestacao);
		} else if (manifestacao != null && tipo.equalsIgnoreCase("sugestao")) {
			listaSugestoes.add(manifestacao);
		}
	}

	public String listarGlobal() {
		String manifestacaoAchada = null;

		for (Manifestacao item : getTodasManifestacoes()) {
			manifestacaoAchada += "=====================================";
			manifestacaoAchada += "\nReclamante: " + item.getReclamante();
			manifestacaoAchada += "\nTipo da Manifestação: " + item.getTipoManifestacao();
			manifestacaoAchada += "\nCódigo: " + item.getCodigo();
			manifestacaoAchada += "\nTítulo: " + item.getTitulo();
			manifestacaoAchada += "\nDescrição: " + item.getDescricao();
			manifestacaoAchada += "=====================================";

		}
		return manifestacaoAchada;
	}

	public String listarElogio() {
		String elogioAchado = null;
		for (Manifestacao item : listaElogios) {
			elogioAchado += "=====================================";
			elogioAchado += "\nReclamante: " + item.getReclamante();
			elogioAchado += "\nCódigo: " + item.getCodigo();
			elogioAchado += "\nTítulo: " + item.getTitulo();
			elogioAchado += "\nDescrição: " + item.getDescricao();
			elogioAchado += "=====================================";
		}
		return elogioAchado;
	}

	public String listarReclamacao() {
		String ReclamacaoAchada = null;
		for (Manifestacao item : listaElogios) {
			ReclamacaoAchada += "=====================================";
			ReclamacaoAchada += "\nReclamante: " + item.getReclamante();
			ReclamacaoAchada += "\nCódigo: " + item.getCodigo();
			ReclamacaoAchada += "\nTítulo: " + item.getTitulo();
			ReclamacaoAchada += "\nDescrição: " + item.getDescricao();
			ReclamacaoAchada += "=====================================";
		}
		return ReclamacaoAchada;
	}

	public String listarSugestao() {
		String sugestaoAchada = null;
		for (Manifestacao item : listaElogios) {
			sugestaoAchada += "=====================================";
			sugestaoAchada += "\nReclamante: " + item.getReclamante();
			sugestaoAchada += "\nCódigo: " + item.getCodigo();
			sugestaoAchada += "\nTítulo: " + item.getTitulo();
			sugestaoAchada += "\nDescrição: " + item.getDescricao();
			sugestaoAchada += "=====================================";
		}
		return sugestaoAchada;
	}
	
	public void removerManifestacaoPorCodigo(int codigo) {
		//Parei aqui, mas cade a lista se n vai ser PRIVATE LA EM CIMA?
	}

	public ArrayList<Manifestacao> getTodasManifestacoes() {
		ArrayList<Manifestacao> listaGlobal = new ArrayList<Manifestacao>();
		listaGlobal.addAll(listaElogios);
		listaGlobal.addAll(listaReclamacoes);
		listaGlobal.addAll(listaSugestoes);
		return listaGlobal;

	}

	public ArrayList<Manifestacao> getListaElogio() {
		return listaElogios;
	}

	public ArrayList<Manifestacao> getListaReclamacao() {
		return listaReclamacoes;
	}

	public ArrayList<Manifestacao> getListaSugestao() {
		return listaSugestoes;
	}
}
