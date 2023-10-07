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
        String msg = "Todas as Manifestações: ";

        for (Manifestacao item : lista) {
            msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nReclamante: " + item.getReclamante() + "\nTipo: "
                    + item.getTipoManifestacao() + "\nTitulo: " + item.getTitulo() + "\nDescrição: "
                    + item.getDescricao() + "\nSituação:" + item.getSituacao();
        }

        return msg;
    }

    public static String listarReclamacao(ArrayList<Manifestacao> lista) {
        String msg = "Todas as reclamações:";

        for (Manifestacao item : lista) {
            if (item.getTipoManifestacao() == Tipo.RECLAMACAO) {
                msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nReclamante: " + item.getReclamante()
                        + "\nTitulo: " + item.getTitulo() + "\nDescrição: " + item.getDescricao() + "\nSituação:"
                        + item.getSituacao();
            }
        }

        return msg;
    }

    public static String listarElogio(ArrayList<Manifestacao> lista) {
        String msg = "Todos os Elogios:";

        for (Manifestacao item : lista) {
            if (item.getTipoManifestacao() == Tipo.ELOGIO) {
                msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nReclamante: " + item.getReclamante()
                        + "\nCódigo:" + item.getCodigo() + "\nTitulo: " + item.getTitulo() + "\nDescrição: "
                        + item.getDescricao() + "\nSituação:" + item.getSituacao();
            }
        }

        return msg;
    }

    public static String listarSugestao(ArrayList<Manifestacao> lista) {
        String msg = "Todas as Sugestões:";

        for (Manifestacao item : lista) {
            if (item.getTipoManifestacao() == Tipo.SUGESTAO) {
                msg += "\n" + linha + "\nCodigo: " + item.getCodigo() + "\nReclamante: " + item.getReclamante()
                        + "\nTitulo: " + item.getTitulo() + "\nDescrição: " + item.getDescricao() + "\nSituação:"
                        + item.getSituacao();
            }
        }

        return msg;
    }

    public static String montarResultadoPesquisa(Manifestacao manifestacao) {
        String msg = "Manifestação" + "\n" + linha + "\nCodigo: " + manifestacao.getCodigo() + "\nReclamante: "
                + manifestacao.getReclamante() + "\nTitulo: " + manifestacao.getTitulo() + "\nDescricao: "
                + manifestacao.getDescricao() + "\nTipo: " + manifestacao.getTipoManifestacao() + "\nSituação: "
                + manifestacao.getSituacao() + "\n" + linha;
        return msg;
    }

}
