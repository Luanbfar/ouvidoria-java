package br.com.ouvidoria;

import javax.swing.JOptionPane;

import br.com.ouvidoria.acoes.AcoesOuvidoria;
import br.com.ouvidoria.entidades.Manifestacao;
import br.com.ouvidoria.entidades.Manifestacao.Tipo;
import br.com.ouvidoria.entidades.Ouvidoria;

public class Teste {

    public static void main(String[] args) {

        Ouvidoria ouvidoria = new Ouvidoria();

        try {

            int opcao;
            String msg;
            do {

                String menu = AcoesOuvidoria.obterMenu();
                String opcaoStr = JOptionPane.showInputDialog(menu);
                Manifestacao resultado;

                if (opcaoStr == null) {
                    opcao = 9;
                } else {

                    opcao = Integer.parseInt(opcaoStr);


                    switch (opcao) {
                        case 1:
                            if (ouvidoria.obterListaManifestacao().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "A lista de manifestações está vazia!");
                            } else {
                                msg = AcoesOuvidoria.listarManifestacoes(ouvidoria.obterListaManifestacao());
                                JOptionPane.showMessageDialog(null, msg);
                            }
                            break;
                        case 2:
                            if (ouvidoria.obterListaReclamacoes().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "A lista de reclamações está vazia!");
                            } else {
                                msg = AcoesOuvidoria.listarReclamacao(ouvidoria.obterListaManifestacao());
                                JOptionPane.showMessageDialog(null, msg);
                            }
                            break;
                        case 3:
                            if (ouvidoria.obterListaSugestoes().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "A lista de sugestões está vazia!");
                            } else {
                                msg = AcoesOuvidoria.listarSugestao(ouvidoria.obterListaManifestacao());
                                JOptionPane.showMessageDialog(null, msg);
                            }
                            break;
                        case 4:
                            if (ouvidoria.obterListaElogios().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "A lista de elogios está vazia!");
                            } else {
                                msg = AcoesOuvidoria.listarElogio(ouvidoria.obterListaManifestacao());
                                JOptionPane.showMessageDialog(null, msg);
                            }
                            break;
                        case 5:
                            String reclamante = JOptionPane.showInputDialog("Reclamante:");
                            String tipoStr = JOptionPane.showInputDialog("Tipo: \n1)Reclamação \n2)Sugestão \n3)Elogio");
                            String titulo = JOptionPane.showInputDialog("Título:");
                            String descricao = JOptionPane.showInputDialog("Descrição:");

                            Tipo tipo = null;

                            if (!titulo.isEmpty() && !descricao.isEmpty() && (tipoStr.equals("1") || tipoStr.equals("2") || tipoStr.equals("3"))) {
                                if (tipoStr.equals("1")) {
                                    tipo = Tipo.RECLAMACAO;
                                } else if (tipoStr.equals("2")) {
                                    tipo = Tipo.SUGESTAO;
                                } else if (tipoStr.equals("3")) {
                                    tipo = Tipo.ELOGIO;
                                }

                                if (reclamante.length() > 0) {
                                    ouvidoria.adicionarManifestacao(new Manifestacao(reclamante, titulo, descricao, tipo));
                                } else {
                                    ouvidoria.adicionarManifestacao(new Manifestacao(titulo, descricao, tipo));
                                }

                                JOptionPane.showMessageDialog(null, "Manifestação adicionada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Insira valores válidos");
                            }
                            break;
                        case 6:
                            String codigoStr = JOptionPane.showInputDialog("Digite o código do manifestação que você deseja pesquisar");
                            int codigo = Integer.parseInt(codigoStr);

                            resultado = ouvidoria.pesquisarManifestacao(codigo);

                            if (resultado != null) {
                                msg = AcoesOuvidoria.montarResultadoPesquisa(resultado);
                                JOptionPane.showMessageDialog(null, msg);
                            } else {
                                JOptionPane.showMessageDialog(null, "Código não encontrado");
                            }

                            break;
                        case 7:
                            String remocaoStr = JOptionPane.showInputDialog("Digite o código do manifestação que você deseja remover");
                            int remocao = Integer.parseInt(remocaoStr);

                            resultado = ouvidoria.pesquisarManifestacao(remocao);

                            if (resultado == null) {
                                JOptionPane.showMessageDialog(null, "Não existe nenhuma manifestação cadastrada com esse código!!");

                            } else if (ouvidoria.obterListaManifestacao().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "A lista de manifestaçôes está vazia");

                            } else {
                                ouvidoria.removerManifestacaoPorCodigo(remocao);
                                JOptionPane.showMessageDialog(null, "Manifestação removida com sucesso!!");

                            }
                            break;
                        case 8:
                            String alterarStr = JOptionPane.showInputDialog("Digite o código do manifestação que você deseja alterar");

                            int alterar = Integer.parseInt(alterarStr);

                            resultado = ouvidoria.pesquisarManifestacao(alterar);

                            if (resultado == null) {
                                JOptionPane.showMessageDialog(null, "Não existe nenhuma manifestação cadastrada com esse código!!");

                            } else if (ouvidoria.obterListaManifestacao().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "A lista de manifestaçôes está vazia!");
                            } else {
                                String codigoAlteradoStr = JOptionPane.showInputDialog(null,
                                        AcoesOuvidoria.montarResultadoPesquisa(resultado) + "\n1) EM ATENDIMENTO \n2) FINALIZADO"
                                                + "\nDigite o código referente ao tipo da situação desejada para alteração: ");
                                int codigoAlterado = Integer.parseInt(codigoAlteradoStr);
                                if (codigoAlteradoStr.equalsIgnoreCase("1")) {
                                    ouvidoria.alterarSituacaoAtendimento(alterar);
                                    JOptionPane.showMessageDialog(null, "Manifestação alterada para *EM ATENDIMENTO*");

                                } else if (codigoAlteradoStr.equalsIgnoreCase("2")) {
                                    ouvidoria.alterarSituacaoFinalizado(alterar);
                                    JOptionPane.showMessageDialog(null, "Manifestação alterada para *FINALIZADO*");

                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Por favor, escolha a opção (1) ou opção (2) para as alterações! ");

                                }
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Obrigado por testar a Ouvidoria!!");
                            // throw new IllegalArgumentException("Unexpected value: " + opcao);
                    }

                }

            } while (opcao != 9);
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, erro + "Insira um valor válido!!");

        }

    }

}
