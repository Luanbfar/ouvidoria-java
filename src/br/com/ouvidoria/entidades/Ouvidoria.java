package br.com.ouvidoria.entidades;

import java.util.ArrayList;

import br.com.ouvidoria.entidades.Manifestacao.SituacaoManifesto;

public class Ouvidoria {

	private ArrayList<Manifestacao> listaManifestacoes = new ArrayList<Manifestacao>();

	public ArrayList<Manifestacao> obterListaReclamacao() {
		return listaManifestacoes;
	}

	public void adicionarManifestacao(Manifestacao manifestacao) {
		if (manifestacao != null) {
			listaManifestacoes.add(manifestacao);
		}
	}

	public boolean removerReclamcao(int codigo) {
		boolean removido = false;

		Manifestacao manifesto = pesquisarReclamcao(codigo);

		if (manifesto != null) {
			listaManifestacoes.remove(manifesto);
			removido = true;
		}

		return removido;
	}

	public Manifestacao pesquisarReclamcao(int codigo) {
		Manifestacao manifestacao = null;

		for (Manifestacao item : listaManifestacoes) {
			if (item.getCodigo() == codigo) {
				manifestacao = item;
				break;
			}
		}

		return manifestacao;
	}

	public void alterarReclamcao(int codigo, String titulo, String descricao) {
		Manifestacao manifesto = pesquisarReclamcao(codigo);

		if (manifesto != null) {
			manifesto.setTitulo(titulo);
			manifesto.setDescricao(descricao);
		}
	}

	public void alterarReclamcao(int codigo, String titulo) {
		Manifestacao manifesto = pesquisarReclamcao(codigo);
		if (manifesto != null) {
			manifesto.setTitulo(titulo);
		}
	}

	// Usando os valores de SituacaoManifesto para usar os possiveis
	// valores para alterar a situacao
	public void alterarSituacaoAtendimento(int codigo) {
		Manifestacao manifesto = pesquisarReclamcao(codigo);
		if (manifesto != null) {
			manifesto.setSituacao(SituacaoManifesto.EM_ATENDIMENTO);
		}
	}

	public void alterarSituacaoFinalizado(int codigo) {
		Manifestacao manifesto = pesquisarReclamcao(codigo);
		if (manifesto != null) {
			manifesto.setSituacao(SituacaoManifesto.FINALIZADO);
		}
	}

}
