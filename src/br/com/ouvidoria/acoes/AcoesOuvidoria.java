package br.com.ouvidoria.acoes;

import java.util.ArrayList;

import br.com.ouvidoria.entidades.Manifestacao;
import br.com.ouvidoria.entidades.Manifestacao.Tipo;

public class AcoesOuvidoria {
	static String linha = "-------------------------";

	public static String obterMenu() {
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

	public static String listarManifestacoes(ArrayList<Manifestacao> lista) {
		String msg = "Todas as reclamacoes:";

		for (Manifestacao item : lista) {
			msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nTitulo: " + item.getTitulo();
		}

		return msg;
	}

	public static String listarReclamacao(ArrayList<Manifestacao> lista) {
		String msg = "Todas as reclamacoes:";

		for (Manifestacao item : lista) {
			if (item.getTipoManifestacao() == Tipo.RECLAMACAO) {
				msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nTitulo: " + item.getTitulo();
			}
		}

		return msg;
	}

	public static String listarElogio(ArrayList<Manifestacao> lista) {
		String msg = "Todas as reclamacoes:";

		for (Manifestacao item : lista) {
			if (item.getTipoManifestacao() == Tipo.ELOGIO) {
				msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nTitulo: " + item.getTitulo();
			}
		}

		return msg;
	}

	public static String listarSugestao(ArrayList<Manifestacao> lista) {
		String msg = "Todas as reclamacoes:";

		for (Manifestacao item : lista) {
			if (item.getTipoManifestacao() == Tipo.SUGESTAO) {
				msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nTitulo: " + item.getTitulo();
			}
		}

		return msg;
	}
	
	public static String montarResultadoPesquisa(Manifestacao manifesto) {
		String msg = "Manifesto"
				+ "\n" + linha
				+ "\nCodigo: " + manifesto.getCodigo()
				+ "\nReclamante: " + manifesto.getReclamante()
				+ "\nTitulo: " + manifesto.getTitulo()
				+ "\nDescricao: " + manifesto.getDescricao()
				+ "\nTipo: " + manifesto.getTipoManifestacao()
				+ "\nStatus: " + manifesto.getSituacao()
				+ "\n" + linha;
		return msg;
	}

}
