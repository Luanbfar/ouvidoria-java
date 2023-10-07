package br.com.ouvidoria.entidades;

import java.util.ArrayList;

import br.com.ouvidoria.entidades.Manifestacao.SituacaoManifestacao;

public class Ouvidoria {

    private ArrayList<Manifestacao> listaManifestacoes = new ArrayList<Manifestacao>();

    private ArrayList<Manifestacao> listaReclamacoes = new ArrayList<Manifestacao>();

    private ArrayList<Manifestacao> listaElogios = new ArrayList<Manifestacao>();

    private ArrayList<Manifestacao> listaSugestoes = new ArrayList<Manifestacao>();

    public ArrayList<Manifestacao> obterListaManifestacao() {
        return listaManifestacoes;
    }

    public ArrayList<Manifestacao> obterListaReclamacoes() {
        return listaReclamacoes;
    }

    public ArrayList<Manifestacao> obterListaElogios() {
        return listaElogios;
    }

    public ArrayList<Manifestacao> obterListaSugestoes() {
        return listaSugestoes;
    }

    public void adicionarManifestacao(Manifestacao manifestacao) {
        if (manifestacao != null && manifestacao.getTipoManifestacao() == Manifestacao.Tipo.RECLAMACAO) {
            listaReclamacoes.add(manifestacao);
        } else if (manifestacao != null && manifestacao.getTipoManifestacao() == Manifestacao.Tipo.SUGESTAO) {
            listaSugestoes.add(manifestacao);
        } else if (manifestacao != null && manifestacao.getTipoManifestacao() == Manifestacao.Tipo.ELOGIO) {
            listaElogios.add(manifestacao);
        }

        listaManifestacoes.add(manifestacao);

    }

    public boolean removerManifestacaoPorCodigo(int codigo) {
        boolean manifestacaoAchada = false;
        Manifestacao manifestacaoPesquisa = pesquisarManifestacao(codigo);
        if (manifestacaoPesquisa != null) {
            listaManifestacoes.remove(manifestacaoPesquisa);
            manifestacaoAchada = true;
        }
        return manifestacaoAchada;
    }

    public Manifestacao pesquisarManifestacao(int codigo) {
        Manifestacao manifestacao = null;

        for (Manifestacao item : listaManifestacoes) {
            if (item.getCodigo() == codigo) {
                manifestacao = item;
            }
        }

        return manifestacao;
    }

    // Usando os valores de SituacaoManifesto para usar os possiveis
    // valores para alterar a situacao
    public void alterarSituacaoAtendimento(int codigo) {
        Manifestacao manifestacao = pesquisarManifestacao(codigo);
        if (manifestacao != null) {
            manifestacao.setSituacao(SituacaoManifestacao.EM_ATENDIMENTO);
        }
    }

    public void alterarSituacaoFinalizado(int codigo) {
        Manifestacao manifestacao = pesquisarManifestacao(codigo);
        if (manifestacao != null) {
            manifestacao.setSituacao(SituacaoManifestacao.FINALIZADO);
        }
    }

}
